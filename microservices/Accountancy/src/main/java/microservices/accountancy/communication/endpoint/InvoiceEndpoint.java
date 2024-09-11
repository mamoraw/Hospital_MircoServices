package microservices.accountancy.communication.endpoint;

import microservices.accountancy.logic.InvoiceService;
import microservices.accountancy.persistence.domain.Invoice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceEndpoint {

    private final InvoiceService invoiceService;

    public InvoiceEndpoint(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    List<Invoice> get() {
        return invoiceService.findAll();
    }

    @PutMapping("/{id}/paid")
    void put(@PathVariable Long id) {
        invoiceService.markAsPaid(id);
    }
}
