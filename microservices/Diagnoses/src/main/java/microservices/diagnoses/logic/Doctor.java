package microservices.diagnoses.logic;

import microservices.diagnoses.domain.Diagnosis;
import microservices.diagnoses.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Doctor {

    // Injecting the diagnoses from the yml file.
    private final List<Diagnosis> diagnoses;

    public Doctor(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void diagnose(Patient patient) {
        String diagnosis = findDiagnosis(patient);
        patient.setDiagnosis(diagnosis);
    }

    // Matching the patient's symptoms with the ones form the yml file
    private String findDiagnosis(Patient patient) {
        return diagnoses.stream()
                .filter(diagnosis -> diagnosis
                        .getSymptoms()
                        .equalsIgnoreCase(patient.getSymptoms()))
                .map(Diagnosis::getName)
                .findFirst()
                .orElse("lupus");
    }
}
