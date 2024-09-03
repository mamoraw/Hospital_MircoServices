package microservices.treatments.logic;

import microservices.treatments.communication.client.AccountancyClient;
import microservices.treatments.communication.dto.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Nurse {

    private final TreatmentService treatmentService;
    private final AccountancyClient accountancyClient;
    private final String treatment;

    public Nurse(TreatmentService treatmentService, AccountancyClient accountancyClient, @Value("${hospital.treatments.default}") String treatment) {
        this.treatmentService = treatmentService;
        this.accountancyClient = accountancyClient;
        this.treatment = treatment;
    }

    public void treat(Patient patient) {
        patient.setTreatment(treatment);
        treatmentService.save(patient);
        accountancyClient.send(patient);
    }
}
