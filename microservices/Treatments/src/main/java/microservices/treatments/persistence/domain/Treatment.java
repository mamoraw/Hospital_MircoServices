package microservices.treatments.persistence.domain;

import java.util.Objects;

public class Treatment {

    private String id;
    private String uuid;
    private String name;
    private String symptoms;
    private String diagnosis;
    private String treatment;

    Treatment() {
    }

    public Treatment(String uuid, String name, String symptoms, String diagnosis, String treatment) {
        this.uuid = uuid;
        this.name = name;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        if (!(o instanceof Treatment)) return false;
        Treatment treatment1 = (Treatment) o;
        return Objects.equals(getId(), treatment1.getId()) &&
                Objects.equals(getUuid(), treatment1.getUuid()) &&
                Objects.equals(getName(), treatment1.getName()) &&
                Objects.equals(getSymptoms(), treatment1.getSymptoms()) &&
                Objects.equals(getDiagnosis(), treatment1.getDiagnosis()) &&
                Objects.equals(getTreatment(), treatment1.getTreatment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUuid(), getName(), getSymptoms(), getDiagnosis(), getTreatment());
    }
}
