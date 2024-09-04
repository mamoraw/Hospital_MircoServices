package microservices.treatments.logic;

import microservices.treatments.communication.dto.Patient;
import microservices.treatments.persistence.domain.Treatment;
import microservices.treatments.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;

    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    public void save(Patient patient) {
        Treatment treatment = createTreatment(patient);
        treatmentRepository.save(treatment);
    }

    private Treatment createTreatment(Patient patient) {
        return new Treatment(
                patient.getUuid(),
                patient.getName(),
                patient.getSymptoms(),
                patient.getDiagnosis(),
                patient.getTreatment()
        );
    }

    public List<Treatment> findAll() {
        return treatmentRepository.findAll();
    }

    public List<Treatment> findByUuid(String uuid) {
        return treatmentRepository.findByUuid(uuid);
    }
}
