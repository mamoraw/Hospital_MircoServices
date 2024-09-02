package microservices.admission.logic;

import microservices.admission.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UUIDProvider {

    private final Map<String, String> cache = new HashMap<>();

    void provideUUID(Patient patient) {
        String name = patient.getName();

        String uuid = cache.getOrDefault(name, String.valueOf(UUID.randomUUID()));
        patient.setUuid(String.valueOf(uuid));
        cache.putIfAbsent(name, uuid);
    }

    public Map<String, String> getCacheSnapshot() {
        return new HashMap<>(cache);
    }

    public Optional<String> findUUID(String name) {
        return Optional.ofNullable(cache.getOrDefault(name, null));
    }
}
