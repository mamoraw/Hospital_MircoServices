package microservices.treatments.endpoint;

import microservices.treatments.communication.dto.Patient;
import microservices.treatments.logic.Nurse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    private final Nurse nurse;

    public PatientEndpoint(Nurse nurse) {
        this.nurse = nurse;
    }

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        // Even though nurse.treat is void, we can return the patient here.
        nurse.treat(patient);
        return patient;
    }
}
