package de.symeda.sormas.api.epidata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.symeda.sormas.api.DataTransferObject;
import de.symeda.sormas.api.Disease;
import de.symeda.sormas.api.caze.YesNoUnknown;
import de.symeda.sormas.api.caze.YesNoUnknownHoriz;
import de.symeda.sormas.api.utils.Diseases;
import de.symeda.sormas.api.utils.PreciseDateAdapter;

public class EpiDataDto extends DataTransferObject {

	private static final long serialVersionUID = 6292411396563549093L;
	
	public static final String I18N_PREFIX = "EpiData";
	
	public static final String BURIAL_ATTENDED = "burialAttended";
	public static final String GATHERING_ATTENDED = "gatheringAttended";
	public static final String TRAVELED = "traveled";
	public static final String RODENTS = "rodents";
	public static final String BATS = "bats";
	public static final String PRIMATES = "primates";
	public static final String SWINE = "swine";
	public static final String BIRDS = "birds";
	public static final String POULTRY_EAT = "poultryEat";
	public static final String POULTRY = "poultry";
	public static final String POULTRY_DETAILS = "poultryDetails";
	public static final String POULTRY_SICK = "poultrySick";
	public static final String POULTRY_SICK_DETAILS = "poultrySickDetails";
	public static final String POULTRY_DATE = "poultryDate";
	public static final String POULTRY_LOCATION = "poultryLocation";
	public static final String WILDBIRDS = "wildbirds";
	public static final String WILDBIRDS_DETAILS = "wildbirdsDetails";
	public static final String WILDBIRDS_DATE = "wildbirdsDate";
	public static final String WILDBIRDS_LOCATION = "wildbirdsLocation";
	public static final String CATTLE = "cattle";
	public static final String OTHER_ANIMALS = "otherAnimals";
	public static final String OTHER_ANIMALS_DETAILS = "otherAnimalsDetails";
	public static final String WATER_SOURCE = "waterSource";
	public static final String WATER_SOURCE_OTHER = "waterSourceOther";
	public static final String WATER_BODY = "waterBody";
	public static final String WATER_BODY_DETAILS = "waterBodyDetails";
	public static final String TICKBITE = "tickBite";
	public static final String BURIALS = "burials";
	public static final String GATHERINGS = "gatherings";
	public static final String TRAVELS = "travels";
	
	@Diseases({Disease.EVD,Disease.LASSA})
	private YesNoUnknown burialAttended;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES})
	private YesNoUnknown gatheringAttended;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES})
	private YesNoUnknown traveled;
	@Diseases({Disease.EVD,Disease.LASSA})
	private YesNoUnknownHoriz rodents;
	@Diseases({Disease.EVD,Disease.LASSA})
	private YesNoUnknownHoriz bats;
	@Diseases({Disease.EVD,Disease.LASSA})
	private YesNoUnknownHoriz primates;
	@Diseases({Disease.EVD,Disease.LASSA})
	private YesNoUnknownHoriz swine;
	@Diseases({Disease.EVD,Disease.LASSA})
	private YesNoUnknownHoriz birds;
	@Diseases({Disease.AVIAN_INFLUENCA})
	private YesNoUnknownHoriz poultryEat;
	@Diseases({Disease.AVIAN_INFLUENCA})
	private YesNoUnknown poultry;
	@Diseases({Disease.AVIAN_INFLUENCA})
	private String poultryDetails;
	@Diseases({Disease.AVIAN_INFLUENCA})
	private YesNoUnknown poultrySick;
	@Diseases({Disease.AVIAN_INFLUENCA})
	private String poultrySickDetails;
	@Diseases({Disease.AVIAN_INFLUENCA})
	private Date poultryDate;
	@Diseases({Disease.AVIAN_INFLUENCA})
	private String poultryLocation;
	@Diseases({Disease.AVIAN_INFLUENCA})
	private YesNoUnknownHoriz wildbirds;
	@Diseases({Disease.AVIAN_INFLUENCA})
	private String wildbirdsDetails;
	@Diseases({Disease.AVIAN_INFLUENCA})
	private Date wildbirdsDate;
	@Diseases({Disease.AVIAN_INFLUENCA})
	private String wildbirdsLocation;
	@Diseases({Disease.EVD,Disease.LASSA})
	private YesNoUnknownHoriz cattle;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA})
	private YesNoUnknownHoriz otherAnimals;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA})
	private String otherAnimalsDetails;
	@Diseases({Disease.CHOLERA})
	private WaterSource waterSource;
	@Diseases({Disease.CHOLERA})
	private String waterSourceOther;
	@Diseases({Disease.CHOLERA})
	private YesNoUnknown waterBody;
	@Diseases({Disease.CHOLERA})
	private String waterBodyDetails;
	@Diseases({Disease.EVD,Disease.LASSA})
	private YesNoUnknown tickBite;

	private List<EpiDataBurialDto> burials = new ArrayList<>();
	private List<EpiDataGatheringDto> gatherings = new ArrayList<>();
	private List<EpiDataTravelDto> travels = new ArrayList<>();
	
	public YesNoUnknown getBurialAttended() {
		return burialAttended;
	}
	public void setBurialAttended(YesNoUnknown burialAttended) {
		this.burialAttended = burialAttended;
	}
	
	public YesNoUnknown getGatheringAttended() {
		return gatheringAttended;
	}
	public void setGatheringAttended(YesNoUnknown gatheringAttended) {
		this.gatheringAttended = gatheringAttended;
	}
	
	public YesNoUnknown getTraveled() {
		return traveled;
	}
	public void setTraveled(YesNoUnknown traveled) {
		this.traveled = traveled;
	}
	
	public YesNoUnknownHoriz getRodents() {
		return rodents;
	}
	public void setRodents(YesNoUnknownHoriz rodents) {
		this.rodents = rodents;
	}
	
	public YesNoUnknownHoriz getBats() {
		return bats;
	}
	public void setBats(YesNoUnknownHoriz bats) {
		this.bats = bats;
	}
	
	public YesNoUnknownHoriz getPrimates() {
		return primates;
	}
	public void setPrimates(YesNoUnknownHoriz primates) {
		this.primates = primates;
	}
	
	public YesNoUnknownHoriz getSwine() {
		return swine;
	}
	public void setSwine(YesNoUnknownHoriz swine) {
		this.swine = swine;
	}
	
	public YesNoUnknownHoriz getBirds() {
		return birds;
	}
	public void setBirds(YesNoUnknownHoriz birds) {
		this.birds = birds;
	}
	
	public YesNoUnknownHoriz getPoultryEat() {
		return poultryEat;
	}
	public void setPoultryEat(YesNoUnknownHoriz poultryEat) {
		this.poultryEat = poultryEat;
	}
	
	public YesNoUnknown getPoultry() {
		return poultry;
	}
	public void setPoultry(YesNoUnknown poultry) {
		this.poultry = poultry;
	}
	
	public String getPoultryDetails() {
		return poultryDetails;
	}
	public void setPoultryDetails(String poultryDetails) {
		this.poultryDetails = poultryDetails;
	}
	
	public YesNoUnknown getPoultrySick() {
		return poultrySick;
	}
	public void setPoultrySick(YesNoUnknown poultrySick) {
		this.poultrySick = poultrySick;
	}
	
	public String getPoultrySickDetails() {
		return poultrySickDetails;
	}
	public void setPoultrySickDetails(String poultrySickDetails) {
		this.poultrySickDetails = poultrySickDetails;
	}

	@XmlJavaTypeAdapter(PreciseDateAdapter.class)
	public Date getPoultryDate() {
		return poultryDate;
	}
	@XmlJavaTypeAdapter(PreciseDateAdapter.class)
	public void setPoultryDate(Date poultryDate) {
		this.poultryDate = poultryDate;
	}
	
	public String getPoultryLocation() {
		return poultryLocation;
	}
	public void setPoultryLocation(String poultryLocation) {
		this.poultryLocation = poultryLocation;
	}
	
	public YesNoUnknownHoriz getWildbirds() {
		return wildbirds;
	}
	public void setWildbirds(YesNoUnknownHoriz wildbirds) {
		this.wildbirds = wildbirds;
	}
	
	public String getWildbirdsDetails() {
		return wildbirdsDetails;
	}
	public void setWildbirdsDetails(String wildbirdsDetails) {
		this.wildbirdsDetails = wildbirdsDetails;
	}

	@XmlJavaTypeAdapter(PreciseDateAdapter.class)
	public Date getWildbirdsDate() {
		return wildbirdsDate;
	}
	@XmlJavaTypeAdapter(PreciseDateAdapter.class)
	public void setWildbirdsDate(Date wildbirdsDate) {
		this.wildbirdsDate = wildbirdsDate;
	}
	
	public String getWildbirdsLocation() {
		return wildbirdsLocation;
	}
	public void setWildbirdsLocation(String wildbirdsLocation) {
		this.wildbirdsLocation = wildbirdsLocation;
	}
	
	public YesNoUnknownHoriz getCattle() {
		return cattle;
	}
	public void setCattle(YesNoUnknownHoriz cattle) {
		this.cattle = cattle;
	}
	
	public YesNoUnknownHoriz getOtherAnimals() {
		return otherAnimals;
	}
	public void setOtherAnimals(YesNoUnknownHoriz otherAnimals) {
		this.otherAnimals = otherAnimals;
	}
	
	public String getOtherAnimalsDetails() {
		return otherAnimalsDetails;
	}
	public void setOtherAnimalsDetails(String otherAnimalsDetails) {
		this.otherAnimalsDetails = otherAnimalsDetails;
	}
	
	public WaterSource getWaterSource() {
		return waterSource;
	}
	public void setWaterSource(WaterSource waterSource) {
		this.waterSource = waterSource;
	}
	
	public String getWaterSourceOther() {
		return waterSourceOther;
	}
	public void setWaterSourceOther(String waterSourceOther) {
		this.waterSourceOther = waterSourceOther;
	}
	
	public YesNoUnknown getWaterBody() {
		return waterBody;
	}
	public void setWaterBody(YesNoUnknown waterBody) {
		this.waterBody = waterBody;
	}
	
	public String getWaterBodyDetails() {
		return waterBodyDetails;
	}
	public void setWaterBodyDetails(String waterBodyDetails) {
		this.waterBodyDetails = waterBodyDetails;
	}
	
	public YesNoUnknown getTickBite() {
		return tickBite;
	}
	public void setTickBite(YesNoUnknown tickBite) {
		this.tickBite = tickBite;
	}
	
	public List<EpiDataBurialDto> getBurials() {
		return burials;
	}
	public void setBurials(List<EpiDataBurialDto> burials) {
		this.burials = burials;
	}
	
	public List<EpiDataGatheringDto> getGatherings() {
		return gatherings;
	}
	public void setGatherings(List<EpiDataGatheringDto> gatherings) {
		this.gatherings = gatherings;
	}
	
	public List<EpiDataTravelDto> getTravels() {
		return travels;
	}
	public void setTravels(List<EpiDataTravelDto> travels) {
		this.travels = travels;
	}

}