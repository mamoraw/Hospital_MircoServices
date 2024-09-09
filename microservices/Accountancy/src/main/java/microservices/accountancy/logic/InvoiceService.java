package microservices.accountancy.logic;

import microservices.accountancy.persistence.domain.Invoice;
import microservices.accountancy.persistence.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void markAsPaid(Long id) {
        // Nice alternative instead of an Optional throw  exception right away.
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        invoice.setPaid(true);
        invoiceRepository.save(invoice);
    }
}
