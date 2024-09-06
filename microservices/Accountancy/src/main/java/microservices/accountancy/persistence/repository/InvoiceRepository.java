package microservices.accountancy.persistence.repository;

import microservices.accountancy.persistence.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
