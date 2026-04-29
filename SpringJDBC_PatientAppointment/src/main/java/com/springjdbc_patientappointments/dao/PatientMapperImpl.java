package com.springjdbc_patientappointments.dao;

import com.springjdbc_patientappointments.entities.Patients;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientMapperImpl implements RowMapper<Patients> {

    @Override
    public Patients mapRow(ResultSet rs, int rowNum) throws SQLException {
        Patients patients = new Patients();
        patients.setPatientId(rs.getString(1));
        patients.setPatientName(rs.getString(2));
        patients.setPatientGender(rs.getString(3));
        patients.setPatientAge(String.valueOf(rs.getInt(4)));
        patients.setPatientAddress(rs.getString(5));
        return patients;
    }
}
