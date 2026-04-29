package com.springjdbc_patientappointments.dao;

import com.springjdbc_patientappointments.entities.Patients;

public interface PatientsDao {
    public Patients viewPatient(String patientId, String patientName);
    public int insert(Patients patients);
    public int update(Patients patients);
    public int delete(String patientId, String patientName);
}
