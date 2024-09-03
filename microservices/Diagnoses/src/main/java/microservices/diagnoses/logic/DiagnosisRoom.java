package microservices.diagnoses.logic;

import microservices.diagnoses.client.TreatmentsClient;
import microservices.diagnoses.domain.Patient;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {

    private final Doctor doctor;
    private final TreatmentsClient treatmentsClient;

    public DiagnosisRoom(Doctor doctor, TreatmentsClient treatmentsClient) {
        this.doctor = doctor;
        this.treatmentsClient = treatmentsClient;
    }

    // Give the patient a diagnose and sends it to the treatmentsClient.
    public Patient diagnose(Patient patient) {
        doctor.diagnose(patient);
        treatmentsClient.send(patient);
        return patient;
    }
}
