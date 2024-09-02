package microservices.admission.communication.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import microservices.admission.communication.dto.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DiagnosesClientTest {

    @Autowired
    DiagnosesClient diagnosesClient;

    @SpyBean
    RestTemplate restTemplate;

    @Value("${diagnoses.url}")
    String mockServerUri;

    ObjectMapper mapper = new ObjectMapper();

    MockRestServiceServer mockServer;

    @BeforeEach
    void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    void send() throws JsonProcessingException {
        Patient patient = new Patient("UUID", "test", "test");
        mockServer.expect(once(),
                        requestToUriTemplate(mockServerUri))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().json(mapper.writeValueAsString(patient)))
                .andRespond(withSuccess()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(patient))
                );

        diagnosesClient.send(patient);

        verify(restTemplate).postForObject(mockServerUri, patient, Void.class);
        mockServer.verify();
    }
}