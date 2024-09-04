package microservices.treatments.repository;

import microservices.treatments.persistence.domain.Treatment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TreatmentRepository extends MongoRepository<Treatment, String>  {

    List<Treatment> findByUuid(String uuid);
}
