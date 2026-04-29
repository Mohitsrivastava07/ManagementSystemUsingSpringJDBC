package com.springjdbc_patientappointments.dao;

import com.springjdbc_patientappointments.entities.Appointments;

public interface AppointmentDao {
    public int insert(Appointments appointments);
    public int delete(String deleteAppointmentId);
    public Appointments viewAppointment(String appointmentId, String patientName);
}
