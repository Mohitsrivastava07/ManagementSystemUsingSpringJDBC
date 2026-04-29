package com.springjdbc_patientappointments.dao;

import com.springjdbc_patientappointments.entities.Doctors;

public interface DoctorsDao {
    public Doctors viewDoctors(String doctorId, String doctorName);
    public int update(Doctors doctors);
    public int delete(String doctorId, String doctorName);
}
