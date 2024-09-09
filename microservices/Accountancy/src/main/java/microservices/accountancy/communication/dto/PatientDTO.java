package microservices.accountancy.communication.dto;

import java.util.Objects;

public class PatientDTO {

    private String uuid;
    private String name;
    private String symptoms;
    private String diagnosis;
    private String treatment;

    public PatientDTO() {
    }

    public PatientDTO(String uuid, String name, String symptoms, String diagnosis, String treatment) {
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
        if (!(o instanceof PatientDTO)) return false;
        PatientDTO that = (PatientDTO) o;
        return Objects.equals(getUuid(), that.getUuid()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getSymptoms(), that.getSymptoms()) &&
                Objects.equals(getDiagnosis(), that.getDiagnosis()) &&
                Objects.equals(getTreatment(), that.getTreatment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getName(), getSymptoms(), getDiagnosis(), getTreatment());
    }
}
