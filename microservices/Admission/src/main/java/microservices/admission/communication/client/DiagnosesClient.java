package microservices.admission.communication.client;

import microservices.admission.communication.dto.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
public class DiagnosesClient {

    private final RestTemplate restTemplate;
    private final String url;

    public DiagnosesClient(RestTemplate restTemplate, @Value("${diagnoses.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public void send(Patient patient) {
        // Enhance Error handling.
        try {
            restTemplate.postForObject(url, patient, Void.class);
        } catch (HttpClientErrorException.Unauthorized e) {
            // Handle 401 Unauthorized error specifically
            System.out.println("Unauthorized access - check credentials: " + e.getMessage());
            // Optionally, throw a custom exception or handle the error gracefully
        } catch (HttpClientErrorException e) {
            // Handle other HTTP errors
            System.out.println("HTTP error occurred: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other errors
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
