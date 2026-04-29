package com.springjdbc_patientappointments.dao;

import com.springjdbc_patientappointments.entities.Doctors;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorsMapperImpl implements RowMapper<Doctors> {
    @Override
    public Doctors mapRow(ResultSet rs, int rowNum) throws SQLException {
        Doctors doctors = new Doctors();
        doctors.setDoctorId(rs.getString(1));
        doctors.setDoctorName(rs.getString(2));
        doctors.setDoctorGender(rs.getString(3));
        doctors.setDoctorSpecialization(rs.getString(4));
        return doctors;
    }
}
