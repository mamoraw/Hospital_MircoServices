package microservices.diagnoses.endpoint;

import microservices.diagnoses.domain.Patient;
import microservices.diagnoses.logic.DiagnosisRoom;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    private final DiagnosisRoom diagnosisRoom;

    public PatientEndpoint(DiagnosisRoom diagnosisRoom) {
        this.diagnosisRoom = diagnosisRoom;
    }

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        return diagnosisRoom.diagnose(patient);
    }
}
