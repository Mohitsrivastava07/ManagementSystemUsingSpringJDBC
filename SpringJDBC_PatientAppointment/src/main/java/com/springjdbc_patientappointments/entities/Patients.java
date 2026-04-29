package com.springjdbc_patientappointments.entities;

public class Patients {
    private String patientId;
    private String patientName;
    private String patientGender;
    private String patientAge;
    private String patientAddress;

    public Patients() {

    }

    public Patients(String patientId, String patientName, String patientGender, String patientAge, String patientAddress) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.patientAddress = patientAddress;
    }

    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public String getPatientGender() {
        return patientGender;
    }
    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }
    public String getPatientAge() {
        return patientAge;
    }
    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }
    public String getPatientAddress() {
        return patientAddress;
    }
    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientGender='" + patientGender + '\'' +
                ", patientAge='" + patientAge + '\'' +
                ", patientAddress='" + patientAddress + '\'' +
                '}';
    }
}
