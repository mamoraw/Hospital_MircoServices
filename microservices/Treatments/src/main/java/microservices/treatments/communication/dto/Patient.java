package microservices.treatments.communication.dto;

import java.util.Objects;

public class Patient {

    private String uuid;
    private String name;
    private String symptoms;
    private String diagnosis;
    private String treatment;

    Patient() {
    }

    public Patient(String uuid, String name, String symptoms, String diagnosis) {
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
    }

    public Patient(String uuid, String name, String symptoms, String diagnosis, String treatment) {
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
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

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getUuid(), patient.getUuid()) &&
                Objects.equals(getName(), patient.getName()) &&
                Objects.equals(getSymptoms(), patient.getSymptoms()) &&
                Objects.equals(getDiagnosis(), patient.getDiagnosis()) &&
                Objects.equals(getTreatment(), patient.getTreatment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getName(), getSymptoms(), getDiagnosis(), getTreatment());
    }
}
