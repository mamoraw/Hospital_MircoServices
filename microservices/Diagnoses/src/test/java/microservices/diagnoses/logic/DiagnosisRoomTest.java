package microservices.diagnoses.logic;

import microservices.diagnoses.client.TreatmentsClient;
import microservices.diagnoses.domain.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class DiagnosisRoomTest {

    @Autowired
    DiagnosisRoom diagnosisRoom;

    @MockBean
    Doctor doctor;

    @MockBean
    TreatmentsClient treatmentsClient;

    @Test
    void diagnose() {
        Patient patient = new Patient("test", "test", "test");

        diagnosisRoom.diagnose(patient);

        verify(doctor).diagnose(patient);
        verify(treatmentsClient).send(patient);
    }
}