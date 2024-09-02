package microservices.admission.configuration;

import microservices.admission.logic.UUIDProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class UUIDProviderConfiguration {

    @Bean
    UUIDProvider uuidProvider() {
        return new UUIDProvider(new HashMap<>());
    }
}
