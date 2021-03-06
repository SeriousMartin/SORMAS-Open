package de.symeda.sormas.app.backend.symptoms;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import de.symeda.sormas.api.symptoms.SymptomState;
import de.symeda.sormas.api.symptoms.TemperatureSource;
import de.symeda.sormas.app.backend.common.AbstractDomainObject;
import de.symeda.sormas.app.backend.common.EmbeddedAdo;
import de.symeda.sormas.app.backend.location.Location;

@Entity(name= Symptoms.TABLE_NAME)
@DatabaseTable(tableName = Symptoms.TABLE_NAME)
@EmbeddedAdo
public class Symptoms extends AbstractDomainObject {
	
	private static final long serialVersionUID = 392886645668778670L;

	public static final String TABLE_NAME = "symptoms";
	public static final String I18N_PREFIX = "Symptoms";

	@DatabaseField(dataType = DataType.DATE_LONG)
	private Date onsetDate;
	@Column(length = 255)
	private String onsetSymptom;
	@Column(length = 255)
	private String symptomsComments;
	@DatabaseField
	private Boolean symptomatic;
	@Column(length = 512)
	private String patientIllLocation;

	@Deprecated
	@DatabaseField(columnName = "illLocation_id")
	private Long illLocationId;
	@Deprecated
	@DatabaseField(dataType = DataType.DATE_LONG)
	private Date illLocationFrom;
	@Deprecated
	@DatabaseField(dataType = DataType.DATE_LONG)
	private Date illLocationTo;

	@Column(columnDefinition = "float8")
	private Float temperature;
	@Enumerated(EnumType.STRING)
	private TemperatureSource temperatureSource;
	@Enumerated(EnumType.STRING)
	private SymptomState fever;
	@Enumerated(EnumType.STRING)
	private SymptomState vomiting;
	@Enumerated(EnumType.STRING)
	private SymptomState diarrhea;
	@Enumerated(EnumType.STRING)
	private SymptomState bloodInStool;
	@Enumerated(EnumType.STRING)
	private SymptomState nausea;
	@Enumerated(EnumType.STRING)
	private SymptomState abdominalPain;
	@Enumerated(EnumType.STRING)
	private SymptomState headache;
	@Enumerated(EnumType.STRING)
	private SymptomState musclePain;
	@Enumerated(EnumType.STRING)
	private SymptomState fatigueWeakness;
	@Enumerated(EnumType.STRING)
	private SymptomState unexplainedBleeding;
	@Enumerated(EnumType.STRING)
	private SymptomState gumsBleeding;
	@Enumerated(EnumType.STRING)
	private SymptomState injectionSiteBleeding;
	@Enumerated(EnumType.STRING)
	private SymptomState noseBleeding;
	@Enumerated(EnumType.STRING)
	private SymptomState bloodyBlackStool;
	@Enumerated(EnumType.STRING)
	private SymptomState redBloodVomit;
	@Enumerated(EnumType.STRING)
	private SymptomState digestedBloodVomit;
	@Enumerated(EnumType.STRING)
	private SymptomState coughingBlood;
	@Enumerated(EnumType.STRING)
	private SymptomState bleedingVagina;
	@Enumerated(EnumType.STRING)
	private SymptomState skinBruising;
	@Enumerated(EnumType.STRING)
	private SymptomState bloodUrine;
	@Enumerated(EnumType.STRING)
	private SymptomState skinRash;
	@Enumerated(EnumType.STRING)
	private SymptomState neckStiffness;
	@Enumerated(EnumType.STRING)
	private SymptomState soreThroat;
	@Enumerated(EnumType.STRING)
	private SymptomState cough;
	@Enumerated(EnumType.STRING)
	private SymptomState runnyNose;
	@Enumerated(EnumType.STRING)
	private SymptomState difficultyBreathing;
	@Enumerated(EnumType.STRING)
	private SymptomState chestPain;
	@Enumerated(EnumType.STRING)
	private SymptomState confusedDisoriented;
	@Enumerated(EnumType.STRING)
	private SymptomState seizures;
	@Enumerated(EnumType.STRING)
	private SymptomState alteredConsciousness;
	@Enumerated(EnumType.STRING)
	private SymptomState conjunctivitis;
	@Enumerated(EnumType.STRING)
	private SymptomState eyePainLightSensitive;
	@Enumerated(EnumType.STRING)
	private SymptomState kopliksSpots;
	@Enumerated(EnumType.STRING)
	private SymptomState throbocytopenia;
	@Enumerated(EnumType.STRING)
	private SymptomState otitisMedia;
	@Enumerated(EnumType.STRING)
	private SymptomState hearingloss;
	@Enumerated(EnumType.STRING)
	private SymptomState dehydration;
	@Enumerated(EnumType.STRING)
	private SymptomState anorexiaAppetiteLoss;
	@Enumerated(EnumType.STRING)
	private SymptomState refusalFeedorDrink;
	@Enumerated(EnumType.STRING)
	private SymptomState jointPain;
	@Enumerated(EnumType.STRING)
	private SymptomState shock;
	@Enumerated(EnumType.STRING)
	private SymptomState hiccups;
	@Enumerated(EnumType.STRING)
	private SymptomState backache;
	@Enumerated(EnumType.STRING)
	private SymptomState eyesBleeding;
	@Enumerated(EnumType.STRING)
	private SymptomState jaundice;
	@Enumerated(EnumType.STRING)
	private SymptomState darkUrine;
	@Enumerated(EnumType.STRING)
	private SymptomState stomachBleeding;
	@Enumerated(EnumType.STRING)
	private SymptomState rapidBreathing;
	@Enumerated(EnumType.STRING)
	private SymptomState swollenGlands;
	@Enumerated(EnumType.STRING)
	private SymptomState cutaneousEruption;
	@Enumerated(EnumType.STRING)
	private SymptomState lesions;
	@Enumerated(EnumType.STRING)
	private SymptomState lesionsThatItch;
	@Enumerated(EnumType.STRING)
	private SymptomState lesionsSameState;
	@Enumerated(EnumType.STRING)
	private SymptomState lesionsSameSize;
	@Enumerated(EnumType.STRING)
	private SymptomState lesionsDeepProfound;
	@DatabaseField
	private Boolean lesionsFace;
	@DatabaseField
	private Boolean lesionsLegs;
	@DatabaseField
	private Boolean lesionsSolesFeet;
	@DatabaseField
	private Boolean lesionsPalmsHands;
	@DatabaseField
	private Boolean lesionsThorax;
	@DatabaseField
	private Boolean lesionsArms;
	@DatabaseField
	private Boolean lesionsGenitals;
	@DatabaseField
	private Boolean lesionsAllOverBody;
	@Enumerated(EnumType.STRING)
	private SymptomState lesionsResembleImg1;
	@Enumerated(EnumType.STRING)
	private SymptomState lesionsResembleImg2;
	@Enumerated(EnumType.STRING)
	private SymptomState lesionsResembleImg3;
	@Enumerated(EnumType.STRING)
	private SymptomState lesionsResembleImg4;
	@Enumerated(EnumType.STRING)
	private SymptomState lymphadenopathyInguinal;
	@Enumerated(EnumType.STRING)
	private SymptomState lymphadenopathyAxillary;
	@Enumerated(EnumType.STRING)
	private SymptomState lymphadenopathyCervical;
	@Enumerated(EnumType.STRING)
	private SymptomState chillsSweats;
	@Enumerated(EnumType.STRING)
	private SymptomState bedridden;
	@Enumerated(EnumType.STRING)
	private SymptomState oralUlcers;
	@Enumerated(EnumType.STRING)
	private SymptomState otherHemorrhagicSymptoms;
	@Column(length = 255)
	private String otherHemorrhagicSymptomsText;
	@Enumerated(EnumType.STRING)
	private SymptomState otherNonHemorrhagicSymptoms;
	@Column(length = 255)
	private String otherNonHemorrhagicSymptomsText;

	public Date getOnsetDate() {
		return onsetDate;
	}

	public void setOnsetDate(Date onsetDate) {
		this.onsetDate = onsetDate;
	}

	public Float getTemperature() {
		return temperature;
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public TemperatureSource getTemperatureSource() {
		return temperatureSource;
	}
	public void setTemperatureSource(TemperatureSource temperatureSource) {
		this.temperatureSource = temperatureSource;
	}

	public SymptomState getFever() {
		return fever;
	}
	public void setFever(SymptomState fever) {
		this.fever = fever;
	}

	public SymptomState getDiarrhea() {
		return diarrhea;
	}
	public void setDiarrhea(SymptomState diarrhea) {
		this.diarrhea = diarrhea;
	}

	public SymptomState getAnorexiaAppetiteLoss() {
		return anorexiaAppetiteLoss;
	}
	public void setAnorexiaAppetiteLoss(SymptomState anorexiaAppetiteLoss) {
		this.anorexiaAppetiteLoss = anorexiaAppetiteLoss;
	}
	public SymptomState getAbdominalPain() {
		return abdominalPain;
	}
	public void setAbdominalPain(SymptomState abdominalPain) {
		this.abdominalPain = abdominalPain;
	}
	public SymptomState getChestPain() {
		return chestPain;
	}
	public void setChestPain(SymptomState chestPain) {
		this.chestPain = chestPain;
	}
	public SymptomState getMusclePain() {
		return musclePain;
	}
	public void setMusclePain(SymptomState musclePain) {
		this.musclePain = musclePain;
	}
	public SymptomState getJointPain() {
		return jointPain;
	}
	public void setJointPain(SymptomState jointPain) {
		this.jointPain = jointPain;
	}
	public SymptomState getHeadache() {
		return headache;
	}
	public void setHeadache(SymptomState headache) {
		this.headache = headache;
	}
	public SymptomState getCough() {
		return cough;
	}
	public void setCough(SymptomState cough) {
		this.cough = cough;
	}
	public SymptomState getDifficultyBreathing() {
		return difficultyBreathing;
	}
	public void setDifficultyBreathing(SymptomState difficultyBreathing) {
		this.difficultyBreathing = difficultyBreathing;
	}

	public SymptomState getSoreThroat() {
		return soreThroat;
	}
	public void setSoreThroat(SymptomState soreThroat) {
		this.soreThroat = soreThroat;
	}
	public SymptomState getConjunctivitis() {
		return conjunctivitis;
	}
	public void setConjunctivitis(SymptomState conjunctivitis) {
		this.conjunctivitis = conjunctivitis;
	}
	public SymptomState getSkinRash() {
		return skinRash;
	}
	public void setSkinRash(SymptomState skinRash) {
		this.skinRash = skinRash;
	}
	public SymptomState getHiccups() {
		return hiccups;
	}
	public void setHiccups(SymptomState hiccups) {
		this.hiccups = hiccups;
	}
	public SymptomState getEyePainLightSensitive() {
		return eyePainLightSensitive;
	}
	public void setEyePainLightSensitive(SymptomState eyePainLightSensitive) {
		this.eyePainLightSensitive = eyePainLightSensitive;
	}
	public SymptomState getConfusedDisoriented() {
		return confusedDisoriented;
	}
	public void setConfusedDisoriented(SymptomState confusedDisoriented) {
		this.confusedDisoriented = confusedDisoriented;
	}
	public SymptomState getUnexplainedBleeding() {
		return unexplainedBleeding;
	}
	public void setUnexplainedBleeding(SymptomState unexplainedBleeding) {
		this.unexplainedBleeding = unexplainedBleeding;
	}
	public SymptomState getGumsBleeding() {
		return gumsBleeding;
	}
	public void setGumsBleeding(SymptomState gumsBleeding) {
		this.gumsBleeding = gumsBleeding;
	}
	public SymptomState getInjectionSiteBleeding() {
		return injectionSiteBleeding;
	}
	public void setInjectionSiteBleeding(SymptomState injectionSiteBleeding) {
		this.injectionSiteBleeding = injectionSiteBleeding;
	}
	public SymptomState getDigestedBloodVomit() {
		return digestedBloodVomit;
	}
	public void setDigestedBloodVomit(SymptomState digestedBloodVomit) {
		this.digestedBloodVomit = digestedBloodVomit;
	}
	public SymptomState getBleedingVagina() {
		return bleedingVagina;
	}
	public void setBleedingVagina(SymptomState bleedingVagina) {
		this.bleedingVagina = bleedingVagina;
	}

	public SymptomState getDehydration() {
		return dehydration;
	}

	public void setDehydration(SymptomState dehydration) {
		this.dehydration = dehydration;
	}

	public SymptomState getFatigueWeakness() {
		return fatigueWeakness;
	}

	public void setFatigueWeakness(SymptomState fatigueWeakness) {
		this.fatigueWeakness = fatigueWeakness;
	}

	public SymptomState getKopliksSpots() {
		return kopliksSpots;
	}

	public void setKopliksSpots(SymptomState kopliksSpots) {
		this.kopliksSpots = kopliksSpots;
	}

	public SymptomState getNausea() {
		return nausea;
	}

	public void setNausea(SymptomState nausea) {
		this.nausea = nausea;
	}

	public SymptomState getNeckStiffness() {
		return neckStiffness;
	}

	public void setNeckStiffness(SymptomState neckStiffness) {
		this.neckStiffness = neckStiffness;
	}

	public String getOnsetSymptom() {
		return onsetSymptom;
	}

	public void setOnsetSymptom(String onsetSymptom) {
		this.onsetSymptom = onsetSymptom;
	}

	public SymptomState getOtitisMedia() {
		return otitisMedia;
	}

	public void setOtitisMedia(SymptomState otitisMedia) {
		this.otitisMedia = otitisMedia;
	}

	public SymptomState getRefusalFeedorDrink() {
		return refusalFeedorDrink;
	}

	public void setRefusalFeedorDrink(SymptomState refusalFeedorDrink) {
		this.refusalFeedorDrink = refusalFeedorDrink;
	}

	public SymptomState getRunnyNose() {
		return runnyNose;
	}

	public void setRunnyNose(SymptomState runnyNose) {
		this.runnyNose = runnyNose;
	}

	public Boolean getSymptomatic() {
		return symptomatic;
	}

	public void setSymptomatic(Boolean symptomatic) {
		this.symptomatic = symptomatic;
	}

	public SymptomState getVomiting() {
		return vomiting;
	}

	public void setVomiting(SymptomState vomiting) {
		this.vomiting = vomiting;
	}

	public SymptomState getOtherHemorrhagicSymptoms() {
		return otherHemorrhagicSymptoms;
	}

	public void setOtherHemorrhagicSymptoms(SymptomState otherHemorrhagicSymptoms) {
		this.otherHemorrhagicSymptoms = otherHemorrhagicSymptoms;
	}

	public String getOtherHemorrhagicSymptomsText() {
		return otherHemorrhagicSymptomsText;
	}

	public void setOtherHemorrhagicSymptomsText(String otherHemorrhagicSymptomsText) {
		this.otherHemorrhagicSymptomsText = otherHemorrhagicSymptomsText;
	}

	public SymptomState getOtherNonHemorrhagicSymptoms() {
		return otherNonHemorrhagicSymptoms;
	}

	public void setOtherNonHemorrhagicSymptoms(SymptomState otherNonHemorrhagicSymptoms) {
		this.otherNonHemorrhagicSymptoms = otherNonHemorrhagicSymptoms;
	}

	public String getOtherNonHemorrhagicSymptomsText() {
		return otherNonHemorrhagicSymptomsText;
	}

	public void setOtherNonHemorrhagicSymptomsText(String otherNonHemorrhagicSymptomsText) {
		this.otherNonHemorrhagicSymptomsText = otherNonHemorrhagicSymptomsText;
	}

	public String getSymptomsComments() {
		return symptomsComments;
	}

	public void setSymptomsComments(String symptomsComments) {
		this.symptomsComments = symptomsComments;
	}

	public SymptomState getBloodInStool() {
		return bloodInStool;
	}

	public void setBloodInStool(SymptomState bloodInStool) {
		this.bloodInStool = bloodInStool;
	}

	public SymptomState getNoseBleeding() {
		return noseBleeding;
	}

	public void setNoseBleeding(SymptomState noseBleeding) {
		this.noseBleeding = noseBleeding;
	}

	public SymptomState getBloodyBlackStool() {
		return bloodyBlackStool;
	}

	public void setBloodyBlackStool(SymptomState bloodyBlackStool) {
		this.bloodyBlackStool = bloodyBlackStool;
	}

	public SymptomState getRedBloodVomit() {
		return redBloodVomit;
	}

	public void setRedBloodVomit(SymptomState redBloodVomit) {
		this.redBloodVomit = redBloodVomit;
	}

	public SymptomState getCoughingBlood() {
		return coughingBlood;
	}

	public void setCoughingBlood(SymptomState coughingBlood) {
		this.coughingBlood = coughingBlood;
	}

	public SymptomState getSkinBruising() {
		return skinBruising;
	}

	public void setSkinBruising(SymptomState skinBruising) {
		this.skinBruising = skinBruising;
	}

	public SymptomState getBloodUrine() {
		return bloodUrine;
	}

	public void setBloodUrine(SymptomState bloodUrine) {
		this.bloodUrine = bloodUrine;
	}

	public SymptomState getThrobocytopenia() {
		return throbocytopenia;
	}

	public void setThrobocytopenia(SymptomState throbocytopenia) {
		this.throbocytopenia = throbocytopenia;
	}

	public SymptomState getHearingloss() {
		return hearingloss;
	}

	public void setHearingloss(SymptomState hearingloss) {
		this.hearingloss = hearingloss;
	}

	public SymptomState getShock() {
		return shock;
	}

	public void setShock(SymptomState shock) {
		this.shock = shock;
	}

	public SymptomState getSeizures() {
		return seizures;
	}

	public void setSeizures(SymptomState seizures) {
		this.seizures = seizures;
	}

	public SymptomState getAlteredConsciousness() {
		return alteredConsciousness;
	}

	public void setAlteredConsciousness(SymptomState alteredConsciousness) {
		this.alteredConsciousness = alteredConsciousness;
	}

	public SymptomState getBackache() {
		return backache;
	}

	public void setBackache(SymptomState backache) {
		this.backache = backache;
	}

	public SymptomState getEyesBleeding() {
		return eyesBleeding;
	}

	public void setEyesBleeding(SymptomState eyesBleeding) {
		this.eyesBleeding = eyesBleeding;
	}

	public SymptomState getJaundice() {
		return jaundice;
	}

	public void setJaundice(SymptomState jaundice) {
		this.jaundice = jaundice;
	}

	public SymptomState getDarkUrine() {
		return darkUrine;
	}

	public void setDarkUrine(SymptomState darkUrine) {
		this.darkUrine = darkUrine;
	}

	public SymptomState getStomachBleeding() {
		return stomachBleeding;
	}

	public void setStomachBleeding(SymptomState stomachBleeding) {
		this.stomachBleeding = stomachBleeding;
	}

	public SymptomState getRapidBreathing() {
		return rapidBreathing;
	}

	public void setRapidBreathing(SymptomState rapidBreathing) {
		this.rapidBreathing = rapidBreathing;
	}

	public SymptomState getSwollenGlands() {
		return swollenGlands;
	}

	public void setSwollenGlands(SymptomState swollenGlands) {
		this.swollenGlands = swollenGlands;
	}

	public SymptomState getCutaneousEruption() {
		return cutaneousEruption;
	}

	public void setCutaneousEruption(SymptomState cutaneousEruption) {
		this.cutaneousEruption = cutaneousEruption;
	}

	public SymptomState getLesions() {
		return lesions;
	}

	public void setLesions(SymptomState lesions) {
		this.lesions = lesions;
	}

	public SymptomState getLesionsThatItch() {
		return lesionsThatItch;
	}

	public void setLesionsThatItch(SymptomState lesionsThatItch) {
		this.lesionsThatItch = lesionsThatItch;
	}

	public SymptomState getLesionsSameState() {
		return lesionsSameState;
	}

	public void setLesionsSameState(SymptomState lesionsSameState) {
		this.lesionsSameState = lesionsSameState;
	}

	public SymptomState getLesionsSameSize() {
		return lesionsSameSize;
	}

	public void setLesionsSameSize(SymptomState lesionsSameSize) {
		this.lesionsSameSize = lesionsSameSize;
	}

	public SymptomState getLesionsDeepProfound() {
		return lesionsDeepProfound;
	}

	public void setLesionsDeepProfound(SymptomState lesionsDeepProfound) {
		this.lesionsDeepProfound = lesionsDeepProfound;
	}

	public Boolean getLesionsFace() {
		return lesionsFace;
	}

	public void setLesionsFace(Boolean lesionsFace) {
		this.lesionsFace = lesionsFace;
	}

	public Boolean getLesionsLegs() {
		return lesionsLegs;
	}

	public void setLesionsLegs(Boolean lesionsLegs) {
		this.lesionsLegs = lesionsLegs;
	}

	public Boolean getLesionsSolesFeet() {
		return lesionsSolesFeet;
	}

	public void setLesionsSolesFeet(Boolean lesionsSolesFeet) {
		this.lesionsSolesFeet = lesionsSolesFeet;
	}

	public Boolean getLesionsPalmsHands() {
		return lesionsPalmsHands;
	}

	public void setLesionsPalmsHands(Boolean lesionsPalmsHands) {
		this.lesionsPalmsHands = lesionsPalmsHands;
	}

	public Boolean getLesionsThorax() {
		return lesionsThorax;
	}

	public void setLesionsThorax(Boolean lesionsThorax) {
		this.lesionsThorax = lesionsThorax;
	}

	public Boolean getLesionsArms() {
		return lesionsArms;
	}

	public void setLesionsArms(Boolean lesionsArms) {
		this.lesionsArms = lesionsArms;
	}

	public Boolean getLesionsGenitals() {
		return lesionsGenitals;
	}

	public void setLesionsGenitals(Boolean lesionsGenitals) {
		this.lesionsGenitals = lesionsGenitals;
	}

	public Boolean getLesionsAllOverBody() {
		return lesionsAllOverBody;
	}

	public void setLesionsAllOverBody(Boolean lesionsAllOverBody) {
		this.lesionsAllOverBody = lesionsAllOverBody;
	}

	public SymptomState getLesionsResembleImg1() {
		return lesionsResembleImg1;
	}

	public void setLesionsResembleImg1(SymptomState lesionsResembleImg1) {
		this.lesionsResembleImg1 = lesionsResembleImg1;
	}

	public SymptomState getLesionsResembleImg2() {
		return lesionsResembleImg2;
	}

	public void setLesionsResembleImg2(SymptomState lesionsResembleImg2) {
		this.lesionsResembleImg2 = lesionsResembleImg2;
	}

	public SymptomState getLesionsResembleImg3() {
		return lesionsResembleImg3;
	}

	public void setLesionsResembleImg3(SymptomState lesionsResembleImg3) {
		this.lesionsResembleImg3 = lesionsResembleImg3;
	}

	public SymptomState getLesionsResembleImg4() {
		return lesionsResembleImg4;
	}

	public void setLesionsResembleImg4(SymptomState lesionsResembleImg4) {
		this.lesionsResembleImg4 = lesionsResembleImg4;
	}

	public SymptomState getLymphadenopathyInguinal() {
		return lymphadenopathyInguinal;
	}

	public void setLymphadenopathyInguinal(SymptomState lymphadenopathyInguinal) {
		this.lymphadenopathyInguinal = lymphadenopathyInguinal;
	}

	public SymptomState getLymphadenopathyAxillary() {
		return lymphadenopathyAxillary;
	}

	public void setLymphadenopathyAxillary(SymptomState lymphadenopathyAxillary) {
		this.lymphadenopathyAxillary = lymphadenopathyAxillary;
	}

	public SymptomState getLymphadenopathyCervical() {
		return lymphadenopathyCervical;
	}

	public void setLymphadenopathyCervical(SymptomState lymphadenopathyCervical) {
		this.lymphadenopathyCervical = lymphadenopathyCervical;
	}

	public SymptomState getChillsSweats() {
		return chillsSweats;
	}

	public void setChillsSweats(SymptomState chillsSweats) {
		this.chillsSweats = chillsSweats;
	}

	public SymptomState getBedridden() {
		return bedridden;
	}

	public void setBedridden(SymptomState bedridden) {
		this.bedridden = bedridden;
	}

	public SymptomState getOralUlcers() {
		return oralUlcers;
	}

	public void setOralUlcers(SymptomState oralUlcers) {
		this.oralUlcers = oralUlcers;
	}

	public String getPatientIllLocation() {
		return patientIllLocation;
	}

	public void setPatientIllLocation(String patientIllLocation) {
		this.patientIllLocation = patientIllLocation;
	}

	@Override
	public String getI18nPrefix() {
		return I18N_PREFIX;
	}

}
