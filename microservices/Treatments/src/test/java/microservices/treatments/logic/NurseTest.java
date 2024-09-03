package microservices.treatments.logic;

import microservices.treatments.communication.client.AccountancyClient;
import microservices.treatments.communication.dto.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class NurseTest {

    @Autowired
    Nurse nurse;

    @MockBean
    TreatmentService treatmentService;

    @MockBean
    AccountancyClient accountancyClient;

    @Value("${hospital.treatments.default}")
    String treatment;

    @Test
    void treat() {
        Patient patient = new Patient("uuid", "name", "symptoms", "diagnosis");
        assertNull(patient.getTreatment());

        nurse.treat(patient);

        assertNotNull(patient.getTreatment());
        assertEquals(treatment, patient.getTreatment());
        verify(treatmentService).save(patient);
        verify(accountancyClient).send(patient);
    }
}