package microservices.diagnoses.configuration;

import microservices.diagnoses.domain.Diagnosis;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("hospital")
public class DiagnosesConfiguration {

    private List<Diagnosis> diagnoses;

    @Bean
    List<Diagnosis> diagnoses() {
        return diagnoses;
    }

    void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
