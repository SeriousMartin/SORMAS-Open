package de.symeda.sormas.backend.report;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import de.symeda.sormas.api.report.WeeklyReportSummaryDto;
import de.symeda.sormas.api.user.UserRole;
import de.symeda.sormas.api.utils.EpiWeek;
import de.symeda.sormas.backend.common.AbstractAdoService;
import de.symeda.sormas.backend.facility.Facility;
import de.symeda.sormas.backend.region.DistrictFacadeEjb;
import de.symeda.sormas.backend.region.DistrictService;
import de.symeda.sormas.backend.region.Region;
import de.symeda.sormas.backend.region.RegionFacadeEjb;
import de.symeda.sormas.backend.region.RegionService;
import de.symeda.sormas.backend.user.User;

@Stateless
@LocalBean
public class WeeklyReportService extends AbstractAdoService<WeeklyReport> {

	@EJB
	private RegionService regionService;
	@EJB
	private DistrictService districtService;

	public WeeklyReportService() {
		super(WeeklyReport.class);
	}

	public long getNumberOfWeeklyReportsByFacility(Facility facility, EpiWeek epiWeek) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<WeeklyReport> from = cq.from(getElementClass());

		cq.select(cb.count(from));
		Predicate filter = cb.equal(from.get(WeeklyReport.HEALTH_FACILITY), facility);
		filter = cb.and(filter, cb.equal(from.get(WeeklyReport.YEAR), epiWeek.getYear()));
		filter = cb.and(filter, cb.equal(from.get(WeeklyReport.EPI_WEEK), epiWeek.getWeek()));

		cq.where(filter);
		return em.createQuery(cq).getSingleResult();
	}

	public List<WeeklyReport> getByFacility(Facility facility, EpiWeek epiWeek) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<WeeklyReport> cq = cb.createQuery(getElementClass());
		Root<WeeklyReport> from = cq.from(getElementClass());

		Predicate filter = cb.equal(from.get(WeeklyReport.HEALTH_FACILITY), facility);
		filter = cb.and(filter, cb.equal(from.get(WeeklyReport.YEAR), epiWeek.getYear()));
		filter = cb.and(filter, cb.equal(from.get(WeeklyReport.EPI_WEEK), epiWeek.getWeek()));

		cq.where(filter);
		cq.orderBy(cb.asc(from.get(WeeklyReport.HEALTH_FACILITY)));
		return em.createQuery(cq).getResultList();
	}

	public WeeklyReport getByEpiWeekAndUser(EpiWeek epiWeek, User user) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<WeeklyReport> cq = cb.createQuery(getElementClass());
		Root<WeeklyReport> from = cq.from(getElementClass());

		Predicate filter = cb.equal(from.get(WeeklyReport.EPI_WEEK), epiWeek.getWeek());
		filter = cb.and(filter, cb.equal(from.get(WeeklyReport.YEAR), epiWeek.getYear()));
		filter = cb.and(filter, cb.equal(from.get(WeeklyReport.INFORMANT), user));

		cq.where(filter);
		try {
			return em.createQuery(cq).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<WeeklyReportSummaryDto> getWeeklyReportSummariesPerRegion(EpiWeek epiWeek) {
		Query query = em.createNativeQuery("SELECT region_id, COUNT(fac) as facilities, SUM(missing) as missing, SUM(report) as report, SUM(zero) as zero "
				+ "FROM ("
					+ "SELECT facility.id as fac, facility.region_id, "
					+ "CASE WHEN COUNT(users.id) > COUNT(wr.id) THEN 1 ELSE 0 END as missing, "
					+ "CASE WHEN SUM(wr.totalnumberofcases) > 0 AND COUNT(users.id) = COUNT(wr.id) THEN 1 ELSE 0 END as report, "
					+ "CASE WHEN SUM(wr.totalnumberofcases) = 0 AND COUNT(users.id) = COUNT(wr.id) THEN 1 ELSE 0 END as zero "
					+ "FROM users "
					+ "INNER JOIN userroles ON userroles.user_id = users.id "
					+ "INNER JOIN facility ON users.healthfacility_id = facility.id "
					+ "LEFT JOIN ("
						+ "SELECT * FROM weeklyreport WHERE year = " + epiWeek.getYear() + " AND epiweek = " + epiWeek.getWeek() 
					+ ") as wr ON wr.informant_id = users.id "
					+ "WHERE userroles.userrole = 'INFORMANT' "
					+ "GROUP BY facility.id"
				+ ") as inner_query "
				+ "GROUP BY region_id;");

		@SuppressWarnings("rawtypes")
		List results = query.getResultList();

		List<WeeklyReportSummaryDto> summaryDtos = new ArrayList<>();

		for (int i = 0; i < results.size(); i++) {
			Object[] result = (Object[]) results.get(i);
			int reports = ((Long) result[3]).intValue();
			int missingReports = ((Long) result[2]).intValue();
			int zeroReports = ((Long) result[4]).intValue();
			int totalReports = reports + missingReports + zeroReports;
			
			WeeklyReportSummaryDto summaryDto = new WeeklyReportSummaryDto();
			summaryDto.setRegion(RegionFacadeEjb.toReferenceDto(regionService.getById((long) result[0])));
			summaryDto.setFacilities(((Long) result[1]).intValue());
			summaryDto.setMissingReports(missingReports);
			summaryDto.setReports(reports);
			summaryDto.setZeroReports(zeroReports);
			summaryDto.setMissingReportsPercentage(new BigDecimal(missingReports).multiply(new BigDecimal(100)).divide(new BigDecimal(totalReports), RoundingMode.HALF_UP).intValue());
			summaryDto.setReportsPercentage(new BigDecimal(reports).multiply(new BigDecimal(100)).divide(new BigDecimal(totalReports), RoundingMode.HALF_UP).intValue());
			summaryDto.setZeroReportsPercentage(new BigDecimal(zeroReports).multiply(new BigDecimal(100)).divide(new BigDecimal(totalReports), RoundingMode.HALF_UP).intValue());
			
			summaryDtos.add(summaryDto);
		}

		return summaryDtos;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<WeeklyReportSummaryDto> getWeeklyReportSummariesPerDistrict(Region region, EpiWeek epiWeek) {
		Query query = em.createNativeQuery("SELECT district_id, COUNT(fac) as facilities, SUM(missing) as missing, SUM(report) as report, SUM(zero) as zero "
				+ "FROM ("
					+ "SELECT facility.id as fac, facility.district_id, "
					+ "CASE WHEN COUNT(users.id) > COUNT(wr.id) THEN 1 ELSE 0 END as missing, "
					+ "CASE WHEN SUM(wr.totalnumberofcases) > 0 AND COUNT(users.id) = COUNT(wr.id) THEN 1 ELSE 0 END as report, "
					+ "CASE WHEN SUM(wr.totalnumberofcases) = 0 AND COUNT(users.id) = COUNT(wr.id) THEN 1 ELSE 0 END as zero "
					+ "FROM users "
					+ "INNER JOIN userroles ON userroles.user_id = users.id "
					+ "INNER JOIN facility ON users.healthfacility_id = facility.id "
					+ "LEFT JOIN ("
						+ "SELECT * FROM weeklyreport WHERE year = " + epiWeek.getYear() + " AND epiweek = " + epiWeek.getWeek() 
					+ ") as wr ON wr.informant_id = users.id "
					+ "WHERE userroles.userrole = 'INFORMANT' "
						+ "AND facility.region_id = " + region.getId() + " "
					+ "GROUP BY facility.id"
				+ ") as inner_query "
				+ "GROUP BY district_id;");

		@SuppressWarnings("rawtypes")
		List results = query.getResultList();

		List<WeeklyReportSummaryDto> summaryDtos = new ArrayList<>();

		for (int i = 0; i < results.size(); i++) {
			Object[] result = (Object[]) results.get(i);
			int reports = ((Long) result[3]).intValue();
			int missingReports = ((Long) result[2]).intValue();
			int zeroReports = ((Long) result[4]).intValue();
			int totalReports = reports + missingReports + zeroReports;
			
			WeeklyReportSummaryDto summaryDto = new WeeklyReportSummaryDto();
			summaryDto.setDistrict(DistrictFacadeEjb.toReferenceDto(districtService.getById((long) result[0])));
			summaryDto.setFacilities(((Long) result[1]).intValue());
			summaryDto.setMissingReports(missingReports);
			summaryDto.setReports(reports);
			summaryDto.setZeroReports(zeroReports);
			summaryDto.setMissingReportsPercentage(new BigDecimal(missingReports).multiply(new BigDecimal(100)).divide(new BigDecimal(totalReports), RoundingMode.HALF_UP).intValue());
			summaryDto.setReportsPercentage(new BigDecimal(reports).multiply(new BigDecimal(100)).divide(new BigDecimal(totalReports), RoundingMode.HALF_UP).intValue());
			summaryDto.setZeroReportsPercentage(new BigDecimal(zeroReports).multiply(new BigDecimal(100)).divide(new BigDecimal(totalReports), RoundingMode.HALF_UP).intValue());
			
			summaryDtos.add(summaryDto);
		}

		return summaryDtos;
	}

	/**
	 * @see /sormas-backend/doc/UserDataAccess.md
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Predicate createUserFilter(CriteriaBuilder cb, CriteriaQuery cq, From<WeeklyReport, WeeklyReport> from, User user) {
		// National users can access all reports in the system
		if (user.getUserRoles().contains(UserRole.NATIONAL_USER)) {
			return null;
		}

		// Whoever created the weekly report is allowed to access it
		Predicate filter = cb.equal(from.get(WeeklyReport.INFORMANT), user);

		// Allow access based on user role
		for (UserRole userRole : user.getUserRoles()) {
			switch (userRole) {
			case SURVEILLANCE_SUPERVISOR:
			case CONTACT_SUPERVISOR:
			case CASE_SUPERVISOR:
				// Supervisors see all reports from facilities in their region
				if (user.getRegion() != null) {
					Join<WeeklyReport, User> informant = from.join(WeeklyReport.INFORMANT, JoinType.LEFT);
					filter = cb.or(filter, cb.equal(informant.join(User.HEALTH_FACILITY, JoinType.LEFT).get(Facility.REGION), user.getRegion()));
				}
				break;
			case SURVEILLANCE_OFFICER:
			case CONTACT_OFFICER:
			case CASE_OFFICER:
				// Officers see all reports from facilities in their district
				if (user.getDistrict() != null) {
					Join<WeeklyReport, User> informant = from.join(WeeklyReport.INFORMANT, JoinType.LEFT);
					filter = cb.or(filter, cb.equal(informant.join(User.HEALTH_FACILITY, JoinType.LEFT).get(Facility.DISTRICT), user.getDistrict()));
				}
				break;
			default:
				break;
			}
		}

		return filter;
	}

}
