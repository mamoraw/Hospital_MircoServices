package microservices.admission.logic;

import microservices.admission.communication.client.DiagnosesClient;
import microservices.admission.communication.dto.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AdmissionTest {

    @Autowired
    Admission admission;

    @MockBean
    UUIDProvider uuidProvider;

    @MockBean
    DiagnosesClient diagnosesClient;

    @Test
    void test() {
        Patient patient = new Patient("test", "test");

        admission.admit(patient);

        verify(uuidProvider).provideUUID(patient);
        verify(diagnosesClient).send(patient);
    }
}