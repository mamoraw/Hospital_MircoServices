package microservices.admission.logic;

import microservices.admission.communication.client.DiagnosesClient;
import microservices.admission.communication.dto.Patient;
import org.springframework.stereotype.Service;

@Service
public class Admission {

    private final UUIDProvider uuidProvider;
    private final DiagnosesClient diagnosesClient;

    public Admission(UUIDProvider uuidProvider, DiagnosesClient diagnosesClient) {
        this.uuidProvider = uuidProvider;
        this.diagnosesClient = diagnosesClient;
    }

    public Patient admit(Patient patient) {
        uuidProvider.provideUUID(patient);
        diagnosesClient.send(patient); // send patient to diagnoses webapp
        return patient;
    }
}
