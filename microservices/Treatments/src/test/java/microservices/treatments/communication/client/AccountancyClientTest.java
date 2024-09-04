package microservices.treatments.communication.client;

import microservices.treatments.communication.dto.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class AccountancyClientTest {

    @Autowired
    AccountancyClient accountancyClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${hospital.accountancy.url}")
    String url;

    @Test
    void send() {
        Patient patient = new Patient("uuid", "name", "symptoms", "diagnosis", "treatment");

        accountancyClient.send(patient);

        verify(restTemplate).postForObject(url, patient, Void.class);
    }
}