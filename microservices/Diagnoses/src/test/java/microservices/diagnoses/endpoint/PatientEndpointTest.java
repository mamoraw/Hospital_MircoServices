package microservices.diagnoses.endpoint;

import microservices.diagnoses.domain.Patient;
import microservices.diagnoses.logic.DiagnosisRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PatientEndpointTest {

    // This test is not working correctly, because of the security settings.

    @Autowired
    TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = restTemplate.withBasicAuth("drhousehospital", "drhousehospital");
    }

    @MockBean
    DiagnosisRoom diagnosisRoom;

    String url = "/patients";

    @Test
    void post() {
        Patient patient = new Patient("test", "test", "test");

        restTemplate.postForObject(url, patient, Patient.class);

        verify(diagnosisRoom).diagnose(patient);
    }
//@Autowired
//TestRestTemplate restTemplate;
//
//    @MockBean
//    DiagnosisRoom diagnosisRoom;
//
//    String url = "/patients";
//
//    @Test
//    void post() {
//        Patient patient = new Patient("test", "test", "test");
//
//        // Perform the POST request
//        restTemplate.postForObject(url, patient, Patient.class);
//
//        // Verify that diagnose method was called with the correct patient
//        verify(diagnosisRoom, times(1)).diagnose(patient);
//    }
}