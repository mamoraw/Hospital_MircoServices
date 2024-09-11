package microservices.accountancy.logic;

import microservices.accountancy.communication.dto.PatientDTO;
import microservices.accountancy.persistence.domain.Invoice;
import microservices.accountancy.persistence.domain.Patient;
import microservices.accountancy.persistence.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class AccountantTest {

    @Autowired
    Accountant accountant;

    @MockBean
    InvoiceService invoiceService;

    @MockBean
    PatientRepository patientRepository;

    @MockBean
    SecurityFilterChain securityFilterChain;

    @Value("${hospital.accountancy.cost}")
    double cost;

    @Test
    void invoiceDoesNotFindPatient() {
        String uuid = "uuid";
        PatientDTO patientDTO = new PatientDTO(uuid, "name", "symptoms", "diagnosis", "treatment");
        when(patientRepository.findOneByUuid(uuid))
                .thenReturn(Optional.empty());
        Patient patient = new Patient(uuid, "name", "symptoms", "diagnosis", "treatment");
        when(patientRepository.save(patient))
                .thenReturn(patient);

        accountant.invoice(patientDTO);

        verify(patientRepository).findOneByUuid(uuid);
        verify(patientRepository).save(patient);
        Invoice invoice = new Invoice(cost, patient);
        verify(invoiceService).save(invoice);
    }

    @Test
    void invoiceFindsPatient() {
        String uuid = "uuid";
        PatientDTO patientDTO = new PatientDTO(uuid, "name", "symptoms", "diagnosis", "treatment");
        Patient patient = new Patient(uuid, "name", "symptoms", "diagnosis", "treatment");
        when(patientRepository.findOneByUuid(uuid))
                .thenReturn(Optional.of(patient));

        accountant.invoice(patientDTO);

        verify(patientRepository).findOneByUuid(uuid);
        verifyNoMoreInteractions(patientRepository);
        Invoice invoice = new Invoice(cost, patient);
        verify(invoiceService).save(invoice);
    }
}