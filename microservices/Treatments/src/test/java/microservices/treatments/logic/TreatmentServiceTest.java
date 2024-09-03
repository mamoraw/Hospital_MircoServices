package microservices.treatments.logic;

import microservices.treatments.communication.dto.Patient;
import microservices.treatments.persistence.domain.Treatment;
import microservices.treatments.repository.TreatmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TreatmentServiceTest {

    @Autowired
    TreatmentService treatmentService;

    @MockBean
    TreatmentRepository treatmentRepository;

    @Test
    void save() {
        Patient patient = new Patient("uuid", "name", "symptoms", "diagnosis", "treatment");

        treatmentService.save(patient);

        Treatment treatment = new Treatment("uuid", "name", "symptoms", "diagnosis", "treatment");
        verify(treatmentRepository).save(treatment);
    }

    @Test
    void findAll() {
        treatmentService.findAll();

        verify(treatmentRepository).findAll();
    }

    @Test
    void findByUuid() {
        String uuid = "uuid";

        treatmentService.findByUuid(uuid);

        verify(treatmentRepository).findByUuid(uuid);
    }
}