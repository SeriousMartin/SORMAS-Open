package de.symeda.sormas.app.validation;

import android.content.res.Resources;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import de.symeda.sormas.api.Disease;
import de.symeda.sormas.api.symptoms.SymptomState;
import de.symeda.sormas.api.symptoms.SymptomsDto;
import de.symeda.sormas.api.utils.Diseases;
import de.symeda.sormas.api.visit.VisitStatus;
import de.symeda.sormas.app.R;
import de.symeda.sormas.app.backend.common.DatabaseHelper;
import de.symeda.sormas.app.backend.symptoms.Symptoms;
import de.symeda.sormas.app.backend.visit.Visit;
import de.symeda.sormas.app.component.CheckBoxField;
import de.symeda.sormas.app.component.PropertyField;
import de.symeda.sormas.app.component.SymptomStateField;
import de.symeda.sormas.app.databinding.CaseSymptomsFragmentLayoutBinding;

/**
 * Created by Mate Strysewske on 21.07.2017.
 */
public final class SymptomsValidator {

    public static boolean validateCaseSymptoms(Symptoms symptoms, CaseSymptomsFragmentLayoutBinding binding) {
        Resources resources = DatabaseHelper.getContext().getResources();

        boolean success = true;

        List<SymptomStateField> nonConditionalSymptoms = getNonConditionalSymptoms(binding);
        List<SymptomStateField> conditionalBleedingSymptoms = getConditionalBleedingSymptoms(binding);
        List<SymptomStateField> lesionsFields = getLesionsFields(binding);
        List<SymptomStateField> monkeypoxFields = getMonkeypoxFields(binding);

        // Location where patient got ill
        if (binding.symptomsPatientIllLocation.getVisibility() == View.VISIBLE) {
            if (isAnySymptomSetTo(SymptomState.YES, nonConditionalSymptoms)) {
                if (symptoms.getPatientIllLocation() == null || symptoms.getPatientIllLocation().trim().isEmpty()) {
                    binding.symptomsPatientIllLocation.setError(resources.getString(R.string.validation_symptoms_patient_ill_location));
                    success = false;
                }
            }
        }

        // Date of initial symptom onset & initial onset symptom
        if (isAnySymptomSetTo(SymptomState.YES, nonConditionalSymptoms)) {
            if (symptoms.getOnsetSymptom() == null) {
                binding.symptomsOnsetSymptom.setError(resources.getString(R.string.validation_symptoms_onset_symptom));
                success = false;
            }
            if (symptoms.getOnsetDate() == null) {
                binding.symptomsOnsetDate.setError(resources.getString(R.string.validation_symptoms_onset_date));
                success = false;
            }
        }

        // Other clinical symptoms
        if (symptoms.getOtherNonHemorrhagicSymptoms() == SymptomState.YES &&
                (symptoms.getOtherNonHemorrhagicSymptomsText() == null || symptoms.getOtherNonHemorrhagicSymptomsText().trim().isEmpty())) {
            binding.symptomsOther1NonHemorrhagicSymptomsText.setError(resources.getString(R.string.validation_symptoms_other_clinical));
            success = false;
        }

        // Other hemorrhagic symptoms
        if (symptoms.getOtherHemorrhagicSymptoms() == SymptomState.YES &&
                (symptoms.getOtherHemorrhagicSymptomsText() == null || symptoms.getOtherHemorrhagicSymptomsText().trim().isEmpty())) {
            binding.symptomsOther1HemorrhagicSymptomsText.setError(resources.getString(R.string.validation_symptoms_other_hemorrhagic));
            success = false;
        }

        // Unexplained bleeding symptoms
        if (symptoms.getUnexplainedBleeding() == SymptomState.YES) {
            if (markAnySymptomSetTo(null, conditionalBleedingSymptoms, resources)) {
                success = false;
            }
        }

        // Lesions fields
        if (symptoms.getLesions() == SymptomState.YES) {
            if (markAnySymptomSetTo(null, lesionsFields, resources)) {
                success = false;
            }
        }

        // Monkeypox fields
        if (symptoms.getLesions() == SymptomState.YES) {
            if (markAnySymptomSetTo(null, monkeypoxFields, resources)) {
                success = false;
            }
        }

        return success;
    }

    public static boolean validateVisitSymptoms(Visit visit, Symptoms symptoms, CaseSymptomsFragmentLayoutBinding binding) {
        Resources resources = DatabaseHelper.getContext().getResources();

        boolean success = true;

        List<SymptomStateField> nonConditionalSymptoms = getNonConditionalSymptoms(binding);
        List<SymptomStateField> conditionalBleedingSymptoms = getConditionalBleedingSymptoms(binding);
        List<SymptomStateField> lesionsFields = getLesionsFields(binding);
        List<SymptomStateField> monkeypoxFields = getMonkeypoxFields(binding);

        // Onset symptom & date
        if (isAnySymptomSetTo(SymptomState.YES, nonConditionalSymptoms)) {
            if (symptoms.getOnsetSymptom() == null) {
                binding.symptomsOnsetSymptom.setError(resources.getString(R.string.validation_symptoms_onset_symptom));
                success = false;
            }
            if (symptoms.getOnsetDate() == null) {
                binding.symptomsOnsetDate.setError(resources.getString(R.string.validation_symptoms_onset_date));
                success = false;
            }
        }

        // Other clinical symptoms
        if (symptoms.getOtherNonHemorrhagicSymptoms() == SymptomState.YES &&
                (symptoms.getOtherNonHemorrhagicSymptomsText() == null || symptoms.getOtherNonHemorrhagicSymptomsText().trim().isEmpty())) {
            binding.symptomsOther1NonHemorrhagicSymptomsText.setError(resources.getString(R.string.validation_symptoms_other_clinical));
            success = false;
        }

        // Other hemorrhagic symptoms
        if (symptoms.getOtherHemorrhagicSymptoms() == SymptomState.YES &&
                (symptoms.getOtherHemorrhagicSymptomsText() == null || symptoms.getOtherHemorrhagicSymptomsText().trim().isEmpty())) {
            binding.symptomsOther1HemorrhagicSymptomsText.setError(resources.getString(R.string.validation_symptoms_other_hemorrhagic));
            success = false;
        }

        // Unexplained bleeding symptoms
        if (symptoms.getUnexplainedBleeding() == SymptomState.YES) {
            if (markAnySymptomSetTo(null, conditionalBleedingSymptoms, resources)) {
                success = false;
            }
        }

        // Lesions fields
        if (symptoms.getLesions() == SymptomState.YES) {
            if (markAnySymptomSetTo(null, lesionsFields, resources)) {
                success = false;
            }
        }

        // Monkeypox fields
        if (symptoms.getLesions() == SymptomState.YES) {
            if (markAnySymptomSetTo(null, monkeypoxFields, resources)) {
                success = false;
            }
        }

        if (visit.getVisitStatus() == VisitStatus.COOPERATIVE) {
            // Non-conditional symptoms
            if (markAnySymptomSetTo(null, nonConditionalSymptoms, resources)) {
                success = false;
            }
            // Temperature source
            if (symptoms.getTemperatureSource() == null) {
                binding.symptomsTemperatureSource.setError(resources.getString(R.string.validation_symptoms_temperature_source));
                success = false;
            }
            // Temperature & fever
            if (symptoms.getTemperature() == null) {
                binding.symptomsTemperature.setError(resources.getString(R.string.validation_symptoms_temperature));
                success = false;
            } else {
                if (symptoms.getTemperature().compareTo(38.0F) >= 0 && symptoms.getFever() != SymptomState.YES) {
                    binding.symptomsFever.setError(resources.getString(R.string.validation_symptoms_fever));
                    success = false;
                }
            }
        }

        return success;
    }

    public static void clearErrorsForSymptoms(CaseSymptomsFragmentLayoutBinding binding) {
        for (SymptomStateField field : getNonConditionalSymptoms(binding)) {
            field.clearError();
        }

        for (SymptomStateField field : getConditionalBleedingSymptoms(binding)) {
            field.clearError();
        }

        for (PropertyField field : getOtherSymptomsFields(binding)) {
            field.clearError();
        }

        for (PropertyField field : getLesionsFields(binding)) {
            field.clearError();
        }

        for (PropertyField field : getMonkeypoxFields(binding)) {
            field.clearError();
        }
    }

    public static void setRequiredHintsForCaseSymptoms(CaseSymptomsFragmentLayoutBinding binding) {
        // Reset required hints
        resetRequiredHints(binding);

        // Set required hints
        if (isAnySymptomSetTo(SymptomState.YES, getNonConditionalSymptoms(binding))) {
            binding.symptomsOnsetSymptom.setRequiredHint(true);
            binding.symptomsOnsetDate.setRequiredHint(true);
            binding.symptomsPatientIllLocation.setRequiredHint(true);
        }

        // Always required because these fields are only visible when they are actually required
        for (SymptomStateField field : getConditionalBleedingSymptoms(binding)) {
            field.setRequiredHint(true);
        }
        for (SymptomStateField symptom : getLesionsFields(binding)) {
            symptom.setRequiredHint(true);
        }
        for (SymptomStateField symptom : getMonkeypoxFields(binding)) {
            symptom.setRequiredHint(true);
        }
        binding.symptomsOther1NonHemorrhagicSymptomsText.setRequiredHint(true);
        binding.symptomsOther1HemorrhagicSymptomsText.setRequiredHint(true);
    }

    public static void setRequiredHintsForVisitSymptoms(boolean cooperative, CaseSymptomsFragmentLayoutBinding binding) {
        // Reset required hints
        resetRequiredHints(binding);

        // Set required hints
        if (cooperative) {
            for (SymptomStateField field : getNonConditionalSymptoms(binding)) {
                field.setRequiredHint(true);
            }
            binding.symptomsTemperature.setRequiredHint(true);
            binding.symptomsTemperatureSource.setRequiredHint(true);
        }

        if (isAnySymptomSetTo(SymptomState.YES, getNonConditionalSymptoms(binding))) {
            binding.symptomsOnsetSymptom.setRequiredHint(true);
            binding.symptomsOnsetDate.setRequiredHint(true);
        }

        // Always required because these fields are only visible when they are actually required
        for (SymptomStateField field : getConditionalBleedingSymptoms(binding)) {
            field.setRequiredHint(true);
        }
        for (SymptomStateField symptom : getLesionsFields(binding)) {
            symptom.setRequiredHint(true);
        }
        for (SymptomStateField symptom : getMonkeypoxFields(binding)) {
            symptom.setRequiredHint(true);
        }
        binding.symptomsOther1NonHemorrhagicSymptomsText.setRequiredHint(true);
        binding.symptomsOther1HemorrhagicSymptomsText.setRequiredHint(true);
    }

    private static void resetRequiredHints(CaseSymptomsFragmentLayoutBinding binding) {
        // Reset required hints
        for (SymptomStateField field : getNonConditionalSymptoms(binding)) {
            field.setRequiredHint(false);
        }
        for (SymptomStateField field : getConditionalBleedingSymptoms(binding)) {
            field.setRequiredHint(false);
        }
        for (PropertyField field : getOtherSymptomsFields(binding)) {
            field.setRequiredHint(false);
        }
        for (SymptomStateField field : getLesionsFields(binding)) {
            field.setRequiredHint(false);
        }
        for (SymptomStateField field : getMonkeypoxFields(binding)) {
            field.setRequiredHint(false);
        }
    }

    private static List<SymptomStateField> getNonConditionalSymptoms(CaseSymptomsFragmentLayoutBinding binding) {
        // These should be in reverse order of how they're displayed on the screen
        return Arrays.asList(binding.symptomsFever, binding.symptomsVomiting,
                binding.symptomsDiarrhea, binding.symptomsBloodInStool, binding.symptomsNausea, binding.symptomsAbdominalPain,
                binding.symptomsHeadache, binding.symptomsMusclePain, binding.symptomsFatigueWeakness, binding.symptomsUnexplainedBleeding,
                binding.symptomsSkinRash, binding.symptomsNeckStiffness, binding.symptomsSoreThroat, binding.symptomsCough,
                binding.symptomsRunnyNose, binding.symptomsDifficultyBreathing, binding.symptomsChestPain, binding.symptomsConfusedDisoriented,
                binding.symptomsSeizures, binding.symptomsAlteredConsciousness, binding.symptomsConjunctivitis,
                binding.symptomsEyePainLightSensitive, binding.symptomsKopliksSpots, binding.symptomsThrobocytopenia,
                binding.symptomsOtitisMedia, binding.symptomsHearingloss, binding.symptomsDehydration, binding.symptomsAnorexiaAppetiteLoss,
                binding.symptomsRefusalFeedorDrink, binding.symptomsJointPain, binding.symptomsShock,
                binding.symptomsHiccups, binding.symptomsBackache, binding.symptomsEyesBleeding, binding.symptomsJaundice,
                binding.symptomsDarkUrine, binding.symptomsStomachBleeding, binding.symptomsRapidBreathing, binding.symptomsSwollenGlands,
                binding.symptomsOtherNonHemorrhagicSymptoms, binding.symptomsCutaneousEruption, binding.symptomsLesions, binding.symptomsLymphadenopathyAxillary,
                binding.symptomsLymphadenopathyCervical, binding.symptomsLymphadenopathyInguinal, binding.symptomsChillsSweats, binding.symptomsBedridden,
                binding.symptomsOralUlcers);
    }

    private static List<SymptomStateField> getConditionalBleedingSymptoms(CaseSymptomsFragmentLayoutBinding binding) {
        // These should be in reverse order of how they're displayed on the screen
        return Arrays.asList(binding.symptomsGumsBleeding, binding.symptomsInjectionSiteBleeding,
                binding.symptomsNoseBleeding, binding.symptomsBloodyBlackStool, binding.symptomsRedBloodVomit,
                binding.symptomsDigestedBloodVomit, binding.symptomsCoughingBlood, binding.symptomsBleedingVagina,
                binding.symptomsSkinBruising, binding.symptomsBloodUrine, binding.symptomsOtherHemorrhagicSymptoms);
    }

    private static List<SymptomStateField> getLesionsFields(CaseSymptomsFragmentLayoutBinding binding) {
        return Arrays.asList(binding.symptomsLesionsSameState, binding.symptomsLesionsSameSize, binding.symptomsLesionsDeepProfound, binding.symptomsLesionsThatItch);
    }

    private static List<SymptomStateField> getMonkeypoxFields(CaseSymptomsFragmentLayoutBinding binding) {
        return Arrays.asList(binding.symptomsLesionsResembleImg1, binding.symptomsLesionsResembleImg2, binding.symptomsLesionsResembleImg3, binding.symptomsLesionsResembleImg4);
    }

    public static boolean isSymptomatic(CaseSymptomsFragmentLayoutBinding binding) {
        return isAnySymptomSetTo(SymptomState.YES, getNonConditionalSymptoms(binding)) ||
                (binding.symptomsTemperature.getValue() != null && (Float) binding.symptomsTemperature.getValue() >= 38.0f);
    }

    private static List<PropertyField<?>> getOtherSymptomsFields(CaseSymptomsFragmentLayoutBinding binding) {
        return Arrays.asList(binding.symptomsOnsetDate, binding.symptomsOnsetSymptom,
                binding.symptomsOther1HemorrhagicSymptomsText, binding.symptomsOther1NonHemorrhagicSymptomsText,
                binding.symptomsTemperature, binding.symptomsTemperatureSource, binding.symptomsPatientIllLocation);
    }

    /**
     * Returns true if there is any visible non-conditional symptom set to the given symptom state
     * or null, in which case true is returned if any symptom state is not set
     */
    private static boolean isAnySymptomSetTo(SymptomState reqSymptomState, List<SymptomStateField> nonConditionalSymptoms) {
        for(SymptomStateField field : nonConditionalSymptoms) {
            if(field.getVisibility() == View.VISIBLE && field.getValue() == reqSymptomState) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns true if there is any visible conditional bleeding symptom set to the given symptom state
     * or null, in which case true is returned if any symptom state is not set
     */
    private static boolean markAnySymptomSetTo(SymptomState reqSymptomState, List<SymptomStateField> symptomsList, Resources resources) {
        boolean fieldMarked = false;
        for(SymptomStateField field : symptomsList) {
            if(field.getVisibility() == View.VISIBLE && field.getValue() == reqSymptomState) {
                field.setError(resources.getString(R.string.validation_symptoms_symptom));
                fieldMarked = true;
            }
        }

        return fieldMarked;
    }

}
