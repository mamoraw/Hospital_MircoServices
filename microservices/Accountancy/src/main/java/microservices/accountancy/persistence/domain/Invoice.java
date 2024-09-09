package microservices.accountancy.persistence.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    private double cost;

    private boolean paid;

    @ManyToOne
    private Patient patient;

    public Invoice() {
    }

    public Invoice(double cost, Patient patient) {
        this.cost = cost;
        this.patient = patient;
    }

    public Invoice(double cost, boolean paid, Patient patient) {
        this.cost = cost;
        this.paid = paid;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(invoice.getCost(), getCost()) == 0 &&
                isPaid() == invoice.isPaid() &&
                Objects.equals(getId(), invoice.getId()) &&
                Objects.equals(getPatient(), invoice.getPatient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCost(), isPaid(), getPatient());
    }
}
