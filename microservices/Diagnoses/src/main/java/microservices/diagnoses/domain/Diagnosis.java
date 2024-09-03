package microservices.diagnoses.domain;

import java.util.Objects;

public class Diagnosis {

    private String name;
    private String symptoms;

    public Diagnosis() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis = (Diagnosis) o;
        return Objects.equals(name, diagnosis.name) && Objects.equals(symptoms, diagnosis.symptoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symptoms);
    }
}
