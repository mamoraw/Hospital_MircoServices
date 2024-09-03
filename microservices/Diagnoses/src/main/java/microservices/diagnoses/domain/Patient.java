package microservices.diagnoses.domain;

import java.util.Objects;

public class Patient {

    private String uuid;
    private String name;
    private String symptoms;
    private String diagnosis;

    Patient() {
    }

    public Patient(String uuid, String name, String symptoms) {
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
    }

    public Patient(String uuid, String name, String symptoms, String diagnosis) {
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
    }

    public String getUuid() {
        return uuid;
    }

    void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getUuid(), patient.getUuid()) &&
                Objects.equals(getName(), patient.getName()) &&
                Objects.equals(getSymptoms(), patient.getSymptoms()) &&
                Objects.equals(getDiagnosis(), patient.getDiagnosis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getName(), getSymptoms(), getDiagnosis());
    }
}
