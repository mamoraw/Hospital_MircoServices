package microservices.admission.logic;

import microservices.admission.communication.dto.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

class UUIDProviderTest {

    Map<String, String> cache;
    UUIDProvider uuidProvider;

    static Stream<Arguments> findUUIDparameters() {
        return Stream.of(
                of(Optional.empty(), ""),
                of(Optional.empty(), "unknown name"),
                of(Optional.of("uuid"), "name")
        );
    }

    @BeforeEach
    void setup() {
        cache = new HashMap<>();
        uuidProvider = new UUIDProvider(cache);
    }

    @Test
    void provideUUIDUnknownPatient() {
        Patient patient = new Patient("name", "uuid");

        uuidProvider.provideUUID(patient);

        assertNotNull(patient.getUuid());
    }

    @Test
    void provideUUIDKnownPatient() {
        String name = "name";
        String uuid = "uuid";
        cache.put(name, uuid);
        Patient patient = new Patient(name, uuid);
        assertNull(patient.getUuid());

        uuidProvider.provideUUID(patient);

        assertEquals(uuid, patient.getUuid());
    }

    @ParameterizedTest
    @MethodSource("findUUIDparameters")
    void findUUID(Optional<String> oExpected, String patientName) {
        cache.put("name", "uuid");

        Optional<String> oResult = uuidProvider.findUUID(patientName);

        assertEquals(oExpected, oResult);
    }

}