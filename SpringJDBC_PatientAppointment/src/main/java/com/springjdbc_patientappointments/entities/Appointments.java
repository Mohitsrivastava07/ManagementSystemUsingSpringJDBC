package com.springjdbc_patientappointments.entities;

public class Appointments {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String appointmentDateTime;

    public Appointments() {

    }
    public Appointments(String appointmentId, String patientId, String doctorId, String appointmentDateTime) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
    public String getAppointmentDateTime() {
        return appointmentDateTime;
    }
    public void setAppointmentDateTime(String appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", appointmentDateTime='" + appointmentDateTime + '\'' +
                '}';
    }
}
