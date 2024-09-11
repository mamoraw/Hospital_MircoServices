package microservices.accountancy.communication.endpoint;

import microservices.accountancy.communication.dto.PatientDTO;
import microservices.accountancy.logic.Accountant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    private final Accountant accountant;

    public PatientEndpoint(Accountant accountant) {
        this.accountant = accountant;
    }

    @PostMapping
    PatientDTO post(@RequestBody PatientDTO patientDTO) {
        accountant.invoice(patientDTO);
        return patientDTO;
    }
}
