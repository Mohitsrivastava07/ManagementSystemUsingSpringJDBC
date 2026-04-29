package com.springjdbc_patientappointments.entities;

public class Doctors {
    private String doctorId;
    private String doctorName;
    private String doctorGender;
    private String doctorSpecialization;

    public Doctors() {

    }

    public Doctors(String doctorId, String doctorName, String doctorGender, String doctorSpecialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorGender = doctorGender;
        this.doctorSpecialization = doctorSpecialization;
    }

    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public String getDoctorGender() {
        return doctorGender;
    }
    public void setDoctorGender(String doctorGender) {
        this.doctorGender = doctorGender;
    }
    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }
    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorGender='" + doctorGender + '\'' +
                ", doctorSpecialization='" + doctorSpecialization + '\'' +
                '}';
    }
}
