package microservices.accountancy.logic;

import microservices.accountancy.communication.dto.PatientDTO;
import microservices.accountancy.persistence.domain.Invoice;
import microservices.accountancy.persistence.domain.Patient;
import microservices.accountancy.persistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Accountant {

    private final InvoiceService invoiceService;
    private final PatientRepository patientRepository;
    private final double cost;

    public Accountant(InvoiceService invoiceService, PatientRepository patientRepository, @Value("${hospital.cost}") double cost) {
        this.invoiceService = invoiceService;
        this.patientRepository = patientRepository;
        this.cost = cost;
    }

    public void invoice(PatientDTO patientDTO) {
        Patient patient = findOrCreateNew(patientDTO);
        Invoice invoice = generateInvoice(patient);
        invoiceService.save(invoice);
    }

    private Patient findOrCreateNew(PatientDTO patientDTO) {
        return patientRepository.findOneByUuid(patientDTO.getUuid())
                .orElseGet(() ->{
                    Patient newPatient = createNew(patientDTO);
                    return patientRepository.save(newPatient);  // Save the new patient to the database
                });
    }

    private Patient createNew(PatientDTO patientDTO) {
        return new Patient(patientDTO.getUuid(),
                patientDTO.getName(),
                patientDTO.getSymptoms(),
                patientDTO.getDiagnosis(),
                patientDTO.getTreatment()
        );
    }

    private Invoice generateInvoice(Patient patient) {
        return new Invoice(cost, patient);
    }
}
