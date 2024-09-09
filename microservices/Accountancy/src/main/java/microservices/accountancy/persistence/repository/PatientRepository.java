package microservices.accountancy.persistence.repository;

import microservices.accountancy.persistence.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findOneByUuid(String uuid);
}
