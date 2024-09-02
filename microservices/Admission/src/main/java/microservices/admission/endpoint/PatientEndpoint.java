package microservices.admission.endpoint;

import microservices.admission.domain.Patient;
import microservices.admission.logic.Admission;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    private final Admission admission;

    public PatientEndpoint(Admission admission) {
        this.admission = admission;
    }

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        return admission.admit(patient);
    }
}
