package de.symeda.sormas.api.symptoms;

import java.util.Date;

import de.symeda.sormas.api.DataTransferObject;
import de.symeda.sormas.api.Disease;
import de.symeda.sormas.api.utils.Diseases;

public class SymptomsDto extends DataTransferObject {

	public static final String I18N_PREFIX = "Symptoms";

	private static final long serialVersionUID = 4146526547904182448L;

	public static final String TEMPERATURE = "temperature";
	public static final String TEMPERATURE_SOURCE = "temperatureSource";
	public static final String ONSET_DATE = "onsetDate";
	public static final String ONSET_SYMPTOM = "onsetSymptom";
	public static final String PATIENT_ILL_LOCATION = "patientIllLocation";

	public static final String ABDOMINAL_PAIN = "abdominalPain";
	public static final String ALTERED_CONSCIOUSNESS = "alteredConsciousness";
	public static final String ANOREXIA_APPETITE_LOSS = "anorexiaAppetiteLoss";
	public static final String BACKACHE = "backache";
	public static final String BEDRIDDEN = "bedridden";
	public static final String BLOOD_IN_STOOL = "bloodInStool";
	public static final String CHEST_PAIN = "chestPain";
	public static final String CHILLS_SWEATS = "chillsSweats";
	public static final String CONFUSED_DISORIENTED = "confusedDisoriented";
	public static final String CONJUNCTIVITIS = "conjunctivitis";
	public static final String COUGH = "cough";
	public static final String CUTANEOUS_ERUPTION = "cutaneousEruption";
	public static final String DARK_URINE = "darkUrine";
	public static final String DEHYDRATION = "dehydration";
	public static final String DIARRHEA = "diarrhea";
	public static final String DIFFICULTY_BREATHING = "difficultyBreathing";
	public static final String EYE_PAIN_LIGHT_SENSITIVE = "eyePainLightSensitive";
	public static final String EYES_BLEEDING = "eyesBleeding";
	public static final String FATIGUE_WEAKNESS = "fatigueWeakness";
	public static final String FEVER = "fever";
	public static final String HEADACHE = "headache";
	public static final String HEARINGLOSS = "hearingloss";
	public static final String HICCUPS = "hiccups";
	public static final String JAUNDICE = "jaundice";
	public static final String JOINT_PAIN = "jointPain";
	public static final String KOPLIKS_SPOTS = "kopliksSpots";
	public static final String LESIONS = "lesions";
	public static final String LESIONS_SAME_STATE = "lesionsSameState";
	public static final String LESIONS_SAME_SIZE = "lesionsSameSize";
	public static final String LESIONS_DEEP_PROFOUND = "lesionsDeepProfound";
	public static final String LESIONS_FACE = "lesionsFace";
	public static final String LESIONS_LEGS = "lesionsLegs";
	public static final String LESIONS_SOLES_FEET = "lesionsSolesFeet";
	public static final String LESIONS_PALMS_HANDS = "lesionsPalmsHands";
	public static final String LESIONS_THORAX = "lesionsThorax";
	public static final String LESIONS_ARMS = "lesionsArms";
	public static final String LESIONS_GENITALS = "lesionsGenitals";
	public static final String LESIONS_ALL_OVER_BODY = "lesionsAllOverBody";
	public static final String LESIONS_RESEMBLE_IMG1 = "lesionsResembleImg1";
	public static final String LESIONS_RESEMBLE_IMG2 = "lesionsResembleImg2";
	public static final String LESIONS_RESEMBLE_IMG3 = "lesionsResembleImg3";
	public static final String LESIONS_RESEMBLE_IMG4 = "lesionsResembleImg4";
	public static final String LESIONS_THAT_ITCH = "lesionsThatItch";
	public static final String LYMPHADENOPATHY_AXILLARY = "lymphadenopathyAxillary";
	public static final String LYMPHADENOPATHY_CERVICAL = "lymphadenopathyCervical";
	public static final String LYMPHADENOPATHY_INGUINAL = "lymphadenopathyInguinal";
	public static final String MUSCLE_PAIN = "musclePain";
	public static final String NAUSEA = "nausea";
	public static final String NECK_STIFFNESS = "neckStiffness";
	public static final String ORAL_ULCERS = "oralUlcers";
	public static final String OTITIS_MEDIA = "otitisMedia";
	public static final String RAPID_BREATHING = "rapidBreathing";
	public static final String REFUSAL_FEEDOR_DRINK = "refusalFeedorDrink";
	public static final String RUNNY_NOSE = "runnyNose";
	public static final String SEIZURES = "seizures";
	public static final String SHOCK = "shock";
	public static final String SKIN_RASH = "skinRash";
	public static final String SORE_THROAT = "soreThroat";
	public static final String STOMACH_BLEEDING = "stomachBleeding";
	public static final String SWOLLEN_GLANDS = "swollenGlands";
	public static final String THROBOCYTOPENIA = "throbocytopenia";
	public static final String VOMITING = "vomiting";
	public static final String OTHER_NON_HEMORRHAGIC_SYMPTOMS = "otherNonHemorrhagicSymptoms";
	public static final String OTHER_NON_HEMORRHAGIC_SYMPTOMS_TEXT = "otherNonHemorrhagicSymptomsText";
	public static final String UNEXPLAINED_BLEEDING = "unexplainedBleeding";
	public static final String GUMS_BLEEDING = "gumsBleeding";
	public static final String INJECTION_SITE_BLEEDING = "injectionSiteBleeding";
	public static final String NOSE_BLEEDING = "noseBleeding";
	public static final String BLOODY_BLACK_STOOL = "bloodyBlackStool";
	public static final String RED_BLOOD_VOMIT = "redBloodVomit";
	public static final String DIGESTED_BLOOD_VOMIT = "digestedBloodVomit";
	public static final String COUGHING_BLOOD = "coughingBlood";
	public static final String BLEEDING_VAGINA = "bleedingVagina";
	public static final String SKIN_BRUISING = "skinBruising";
	public static final String BLOOD_URINE = "bloodUrine";
	public static final String OTHER_HEMORRHAGIC_SYMPTOMS = "otherHemorrhagicSymptoms";
	public static final String OTHER_HEMORRHAGIC_SYMPTOMS_TEXT = "otherHemorrhagicSymptomsText";
	public static final String SYMPTOMS_COMMENTS = "symptomsComments";

	public static final String SYMPTOMATIC = "symptomatic";

	private Boolean symptomatic;
	private Date onsetDate;
	private String onsetSymptom;
	
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.YELLOW_FEVER,Disease.DENGUE,Disease.MONKEYPOX,Disease.OTHER})
	private Float temperature;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.YELLOW_FEVER,Disease.DENGUE,Disease.MONKEYPOX,Disease.OTHER})
	private TemperatureSource temperatureSource;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.YELLOW_FEVER,Disease.DENGUE,Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState fever;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.YELLOW_FEVER,Disease.DENGUE,Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState vomiting;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.OTHER})
	private SymptomState diarrhea;
	@Diseases({Disease.CHOLERA,Disease.YELLOW_FEVER,Disease.OTHER})
	private SymptomState bloodInStool;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.YELLOW_FEVER,Disease.DENGUE,Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState nausea;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CHOLERA,Disease.YELLOW_FEVER,Disease.DENGUE,Disease.OTHER})
	private SymptomState abdominalPain;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.YELLOW_FEVER,Disease.DENGUE,Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState headache;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.YELLOW_FEVER,Disease.DENGUE,Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState musclePain;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.YELLOW_FEVER,Disease.DENGUE,Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState fatigueWeakness;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.OTHER})
	private SymptomState unexplainedBleeding;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.YELLOW_FEVER,Disease.DENGUE,Disease.OTHER})
	private SymptomState gumsBleeding;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.OTHER})
	private SymptomState injectionSiteBleeding;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.YELLOW_FEVER,Disease.OTHER})
	private SymptomState noseBleeding;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.OTHER})
	private SymptomState bloodyBlackStool;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.DENGUE,Disease.OTHER})
	private SymptomState redBloodVomit;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.OTHER})
	private SymptomState digestedBloodVomit;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.OTHER})
	private SymptomState coughingBlood;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.OTHER})
	private SymptomState bleedingVagina;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.OTHER})
	private SymptomState skinBruising;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.OTHER})
	private SymptomState bloodUrine;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.OTHER})
	private SymptomState otherHemorrhagicSymptoms;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.OTHER})
	private String otherHemorrhagicSymptomsText;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.MEASLES,Disease.DENGUE,Disease.OTHER})
	private SymptomState skinRash;
	@Diseases({Disease.CSM,Disease.OTHER})
	private SymptomState neckStiffness;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.MEASLES,Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState soreThroat;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.MEASLES,Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState cough;
	@Diseases({Disease.AVIAN_INFLUENCA,Disease.MEASLES,Disease.OTHER})
	private SymptomState runnyNose;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.MEASLES,Disease.OTHER})
	private SymptomState difficultyBreathing;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.OTHER})
	private SymptomState chestPain;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.OTHER})
	private SymptomState confusedDisoriented;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.OTHER})
	private SymptomState seizures;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.OTHER})
	private SymptomState alteredConsciousness;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.MEASLES,Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState conjunctivitis;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.MEASLES,Disease.DENGUE,Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState eyePainLightSensitive;
	@Diseases({Disease.MEASLES,Disease.OTHER})
	private SymptomState kopliksSpots;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.OTHER})
	private SymptomState throbocytopenia;
	@Diseases({Disease.AVIAN_INFLUENCA,Disease.MEASLES,Disease.OTHER})
	private SymptomState otitisMedia;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.OTHER})
	private SymptomState hearingloss;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.CHOLERA,Disease.OTHER})
	private SymptomState dehydration;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.CSM,Disease.CHOLERA,Disease.YELLOW_FEVER,Disease.OTHER})
	private SymptomState anorexiaAppetiteLoss;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.CSM,Disease.CHOLERA,Disease.OTHER})
	private SymptomState refusalFeedorDrink;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.MEASLES,Disease.DENGUE,Disease.OTHER})
	private SymptomState jointPain;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.OTHER})
	private SymptomState shock;
	@Diseases({Disease.EVD,Disease.OTHER})
	private SymptomState hiccups;
	@Diseases({Disease.YELLOW_FEVER,Disease.OTHER})
	private SymptomState backache;
	@Diseases({Disease.YELLOW_FEVER,Disease.OTHER})
	private SymptomState eyesBleeding;
	@Diseases({Disease.YELLOW_FEVER,Disease.OTHER})
	private SymptomState jaundice;
	@Diseases({Disease.YELLOW_FEVER,Disease.OTHER})
	private SymptomState darkUrine;
	@Diseases({Disease.YELLOW_FEVER,Disease.OTHER})
	private SymptomState stomachBleeding;
	@Diseases({Disease.DENGUE,Disease.OTHER})
	private SymptomState rapidBreathing;
	@Diseases({Disease.DENGUE,Disease.OTHER})
	private SymptomState swollenGlands;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState cutaneousEruption;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState lesions;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState lesionsSameState;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState lesionsSameSize;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState lesionsDeepProfound;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private Boolean lesionsFace;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private Boolean lesionsLegs;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private Boolean lesionsSolesFeet;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private Boolean lesionsPalmsHands;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private Boolean lesionsThorax;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private Boolean lesionsArms;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private Boolean lesionsGenitals;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private Boolean lesionsAllOverBody;
	@Diseases({Disease.MONKEYPOX})
	private SymptomState lesionsResembleImg1;
	@Diseases({Disease.MONKEYPOX})
	private SymptomState lesionsResembleImg2;
	@Diseases({Disease.MONKEYPOX})
	private SymptomState lesionsResembleImg3;
	@Diseases({Disease.MONKEYPOX})
	private SymptomState lesionsResembleImg4;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState lymphadenopathyInguinal;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState lymphadenopathyAxillary;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState lymphadenopathyCervical;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState chillsSweats;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState lesionsThatItch;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState bedridden;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState oralUlcers;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.DENGUE,Disease.MONKEYPOX,Disease.OTHER})
	private SymptomState otherNonHemorrhagicSymptoms;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.DENGUE,Disease.MONKEYPOX,Disease.OTHER})
	private String otherNonHemorrhagicSymptomsText;
	@Diseases({Disease.EVD,Disease.LASSA,Disease.AVIAN_INFLUENCA,Disease.CSM,Disease.CHOLERA,Disease.MEASLES,Disease.DENGUE,Disease.MONKEYPOX,Disease.OTHER})
	private String symptomsComments;
	@Diseases({Disease.MONKEYPOX,Disease.OTHER})
	private String patientIllLocation;

	public Boolean getSymptomatic() {
		return symptomatic;
	}
	public void setSymptomatic(Boolean symptomatic) {
		this.symptomatic = symptomatic;
	}
	public Date getOnsetDate() {
		return onsetDate;
	}
	public void setOnsetDate(Date onsetDate) {
		this.onsetDate = onsetDate;
	}
	public String getOnsetSymptom() {
		return onsetSymptom;
	}
	public void setOnsetSymptom(String onsetSymptom) {
		this.onsetSymptom = onsetSymptom;
	}
	public String getPatientIllLocation() {
		return patientIllLocation;
	}
	public void setPatientIllLocation(String patientIllLocation) {
		this.patientIllLocation = patientIllLocation;
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
	public SymptomState getVomiting() {
		return vomiting;
	}
	public void setVomiting(SymptomState vomiting) {
		this.vomiting = vomiting;
	}
	public SymptomState getDiarrhea() {
		return diarrhea;
	}
	public void setDiarrhea(SymptomState diarrhea) {
		this.diarrhea = diarrhea;
	}
	public SymptomState getBloodInStool() {
		return bloodInStool;
	}
	public void setBloodInStool(SymptomState bloodInStool) {
		this.bloodInStool = bloodInStool;
	}
	public SymptomState getNausea() {
		return nausea;
	}
	public void setNausea(SymptomState nausea) {
		this.nausea = nausea;
	}
	public SymptomState getAbdominalPain() {
		return abdominalPain;
	}
	public void setAbdominalPain(SymptomState abdominalPain) {
		this.abdominalPain = abdominalPain;
	}
	public SymptomState getHeadache() {
		return headache;
	}
	public void setHeadache(SymptomState headache) {
		this.headache = headache;
	}
	public SymptomState getMusclePain() {
		return musclePain;
	}
	public void setMusclePain(SymptomState musclePain) {
		this.musclePain = musclePain;
	}
	public SymptomState getFatigueWeakness() {
		return fatigueWeakness;
	}
	public void setFatigueWeakness(SymptomState fatigueWeakness) {
		this.fatigueWeakness = fatigueWeakness;
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
	public SymptomState getDigestedBloodVomit() {
		return digestedBloodVomit;
	}
	public void setDigestedBloodVomit(SymptomState digestedBloodVomit) {
		this.digestedBloodVomit = digestedBloodVomit;
	}
	public SymptomState getCoughingBlood() {
		return coughingBlood;
	}
	public void setCoughingBlood(SymptomState coughingBlood) {
		this.coughingBlood = coughingBlood;
	}
	public SymptomState getBleedingVagina() {
		return bleedingVagina;
	}
	public void setBleedingVagina(SymptomState bleedingVagina) {
		this.bleedingVagina = bleedingVagina;
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
	public SymptomState getSkinRash() {
		return skinRash;
	}
	public void setSkinRash(SymptomState skinRash) {
		this.skinRash = skinRash;
	}
	public SymptomState getNeckStiffness() {
		return neckStiffness;
	}
	public void setNeckStiffness(SymptomState neckStiffness) {
		this.neckStiffness = neckStiffness;
	}
	public SymptomState getSoreThroat() {
		return soreThroat;
	}
	public void setSoreThroat(SymptomState soreThroat) {
		this.soreThroat = soreThroat;
	}
	public SymptomState getCough() {
		return cough;
	}
	public void setCough(SymptomState cough) {
		this.cough = cough;
	}
	public SymptomState getRunnyNose() {
		return runnyNose;
	}
	public void setRunnyNose(SymptomState runnyNose) {
		this.runnyNose = runnyNose;
	}
	public SymptomState getDifficultyBreathing() {
		return difficultyBreathing;
	}
	public void setDifficultyBreathing(SymptomState difficultyBreathing) {
		this.difficultyBreathing = difficultyBreathing;
	}
	public SymptomState getChestPain() {
		return chestPain;
	}
	public void setChestPain(SymptomState chestPain) {
		this.chestPain = chestPain;
	}
	public SymptomState getConfusedDisoriented() {
		return confusedDisoriented;
	}
	public void setConfusedDisoriented(SymptomState confusedDisoriented) {
		this.confusedDisoriented = confusedDisoriented;
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
	public SymptomState getConjunctivitis() {
		return conjunctivitis;
	}
	public void setConjunctivitis(SymptomState conjunctivitis) {
		this.conjunctivitis = conjunctivitis;
	}
	public SymptomState getEyePainLightSensitive() {
		return eyePainLightSensitive;
	}
	public void setEyePainLightSensitive(SymptomState eyePainLightSensitive) {
		this.eyePainLightSensitive = eyePainLightSensitive;
	}
	public SymptomState getKopliksSpots() {
		return kopliksSpots;
	}
	public void setKopliksSpots(SymptomState kopliksSpots) {
		this.kopliksSpots = kopliksSpots;
	}
	public SymptomState getThrobocytopenia() {
		return throbocytopenia;
	}
	public void setThrobocytopenia(SymptomState throbocytopenia) {
		this.throbocytopenia = throbocytopenia;
	}
	public SymptomState getOtitisMedia() {
		return otitisMedia;
	}
	public void setOtitisMedia(SymptomState otitisMedia) {
		this.otitisMedia = otitisMedia;
	}
	public SymptomState getHearingloss() {
		return hearingloss;
	}
	public void setHearingloss(SymptomState hearingloss) {
		this.hearingloss = hearingloss;
	}
	public SymptomState getDehydration() {
		return dehydration;
	}
	public void setDehydration(SymptomState dehydration) {
		this.dehydration = dehydration;
	}
	public SymptomState getAnorexiaAppetiteLoss() {
		return anorexiaAppetiteLoss;
	}
	public void setAnorexiaAppetiteLoss(SymptomState anorexiaAppetiteLoss) {
		this.anorexiaAppetiteLoss = anorexiaAppetiteLoss;
	}
	public SymptomState getRefusalFeedorDrink() {
		return refusalFeedorDrink;
	}
	public void setRefusalFeedorDrink(SymptomState refusalFeedorDrink) {
		this.refusalFeedorDrink = refusalFeedorDrink;
	}
	public SymptomState getJointPain() {
		return jointPain;
	}
	public void setJointPain(SymptomState jointPain) {
		this.jointPain = jointPain;
	}
	public SymptomState getShock() {
		return shock;
	}
	public void setShock(SymptomState shock) {
		this.shock = shock;
	}
	public SymptomState getHiccups() {
		return hiccups;
	}
	public void setHiccups(SymptomState hiccups) {
		this.hiccups = hiccups;
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
	public SymptomState getLesionsThatItch() {
		return lesionsThatItch;
	}
	public void setLesionsThatItch(SymptomState lesionsThatItch) {
		this.lesionsThatItch = lesionsThatItch;
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
	
}
