package microservices.treatments.endpoint;

import microservices.treatments.logic.TreatmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TreatmentEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    TreatmentService treatmentService;

    String url = "/treatments";

    @Test
    void get() {
        testRestTemplate.getForObject(url, ArrayList.class);

        verify(treatmentService).findAll();
    }

    @Test
    void getByUuid() {
        String uuid = "uuid";

        testRestTemplate.getForObject(url + "/" + uuid, ArrayList.class);

        verify(treatmentService).findByUuid(uuid);
    }
}