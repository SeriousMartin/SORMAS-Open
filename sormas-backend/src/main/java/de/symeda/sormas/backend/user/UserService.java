package de.symeda.sormas.backend.user;

import java.util.Arrays;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import de.symeda.sormas.api.user.UserRole;
import de.symeda.sormas.backend.common.AbstractAdoService;
import de.symeda.sormas.backend.common.AbstractDomainObject;
import de.symeda.sormas.backend.facility.Facility;
import de.symeda.sormas.backend.region.District;
import de.symeda.sormas.backend.region.Region;
import de.symeda.sormas.backend.util.PasswordHelper;

@Stateless
@LocalBean
public class UserService extends AbstractAdoService<User> {
	
	public UserService() {
		super(User.class);
	}
	
	public User createUser() {
		User user = new User();
		// dummy password to make sure no one can login with this user
		String password = PasswordHelper.createPass(12);
		user.setSeed(PasswordHelper.createPass(16));
		user.setPassword(PasswordHelper.encodePassword(password, user.getSeed()));		
		return user;
	}

	public User getByUserName(String userName) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		ParameterExpression<String> userNameParam = cb.parameter(String.class, User.USER_NAME);
		CriteriaQuery<User> cq = cb.createQuery(getElementClass());
		Root<User> from = cq.from(getElementClass());
		cq.where(cb.equal(from.get(User.USER_NAME), userNameParam));
		
		TypedQuery<User> q = em.createQuery(cq)
			.setParameter(userNameParam, userName);
		
		User entity = q.getResultList().stream()
				.findFirst()
				.orElse(null);
		
		return entity;
	}
	
	public List<User> getAllByRegionAndUserRoles(Region region, UserRole... userRoles) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(getElementClass());
		Root<User> from = cq.from(getElementClass());
		
		Predicate filter = null;
		if (region != null) {
			filter = cb.equal(from.get(User.REGION), region);
		}
		
		if (userRoles.length > 0) {
			Join<User, UserRole> joinRoles = from.join(User.USER_ROLES, JoinType.LEFT);
			Predicate rolesFilter = joinRoles.in(Arrays.asList(userRoles));
			if (filter != null) {
				filter = cb.and(filter, rolesFilter);
			} else {
				filter = rolesFilter;
			}
		}
		
		if (filter != null) {
			cq.where(filter);
		}
		
		cq.orderBy(cb.asc(from.get(AbstractDomainObject.ID)));
		return em.createQuery(cq).getResultList();
	}
	
	/**
	 * @param district
	 * @param includeSupervisors If set to true, all supervisors are returned independent of the district
	 * @param userRoles
	 * @return
	 */
	public List<User> getAllByDistrict(District district, boolean includeSupervisors, UserRole... userRoles) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(getElementClass());
		Root<User> from = cq.from(getElementClass());

		buildDistrictQuery(cb, cq, from, district, includeSupervisors, userRoles);
		
		cq.orderBy(cb.asc(from.get(AbstractDomainObject.ID)));
		return em.createQuery(cq).getResultList();
	}
	
	public List<User> getForWeeklyReportDetails(District district) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(getElementClass());
		Root<User> from = cq.from(getElementClass());
		
		buildDistrictQuery(cb, cq, from, district, false, UserRole.INFORMANT);
		
		Join<User, Facility> joinFacility = from.join(User.HEALTH_FACILITY, JoinType.LEFT);
		cq.orderBy(cb.asc(joinFacility.get(Facility.NAME)));
		return em.createQuery(cq).getResultList();
	}
	
	public long getNumberOfInformantsByFacility(Facility facility) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<User> from = cq.from(getElementClass());
		
		cq.select(cb.count(from));
		cq.where(cb.equal(from.get(User.HEALTH_FACILITY), facility));
		return em.createQuery(cq).getSingleResult();
	}

	public boolean isLoginUnique(String uuid, String userName) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		ParameterExpression<String> userNameParam = cb.parameter(String.class, User.USER_NAME);
		CriteriaQuery<User> cq = cb.createQuery(getElementClass());
		Root<User> from = cq.from(getElementClass());
		cq.where(cb.equal(from.get(User.USER_NAME), userNameParam));
		
		TypedQuery<User> q = em.createQuery(cq)
			.setParameter(userNameParam, userName);
		
		User entity = q.getResultList().stream()
				.findFirst()
				.orElse(null);
		
		return entity==null || (entity!=null&&entity.getUuid().equals(uuid));
	}
	
	public String resetPassword(String userUuid) {
		User user = getByUuid(userUuid);

		if (user == null) {
//			logger.warn("resetPassword() for unknown user '{}'", realmUserUuid);
			return null;
		}

		String password = PasswordHelper.createPass(12);
		user.setSeed(PasswordHelper.createPass(16));
		user.setPassword(PasswordHelper.encodePassword(password, user.getSeed()));
		ensurePersisted(user);

		return password;
	}

	@Override
	protected Predicate createUserFilter(CriteriaBuilder cb, CriteriaQuery cq, From<User, User> from, User user) {
		// a user can read all other users
		return null;
	}

	private void buildDistrictQuery(CriteriaBuilder cb, CriteriaQuery<User> cq, Root<User> from, District district, boolean includeSupervisors, UserRole... userRoles) {
		Predicate filter = cb.equal(from.get(User.DISTRICT), district);
		
		if (userRoles.length > 0) {
			Join<User, UserRole> joinRoles = from.join(User.USER_ROLES, JoinType.LEFT);
			Predicate rolesFilter = joinRoles.in(Arrays.asList(userRoles));
			if (filter != null) {
				filter = cb.and(filter, rolesFilter);
			} else {
				filter = rolesFilter;
			}
		}

		if (includeSupervisors) {
			Join<User, UserRole> joinRoles = from.join(User.USER_ROLES, JoinType.LEFT);
			Predicate supervisorFilter = joinRoles.in(Arrays.asList(UserRole.CASE_SUPERVISOR, UserRole.CONTACT_SUPERVISOR, UserRole.SURVEILLANCE_SUPERVISOR));
			if (filter != null) {
				filter = cb.or(filter, supervisorFilter);
			} else {
				filter = supervisorFilter;
			}
		}
		
		if (filter != null) {
			cq.where(filter);
		}
	}
	
}
