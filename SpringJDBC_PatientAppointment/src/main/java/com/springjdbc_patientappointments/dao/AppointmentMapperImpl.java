package com.springjdbc_patientappointments.dao;

import com.springjdbc_patientappointments.entities.Appointments;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentMapperImpl implements RowMapper<Appointments> {
    @Override
    public Appointments mapRow(ResultSet rs, int rowNum) throws SQLException {
        Appointments appointments = new Appointments();
        appointments.setAppointmentId(rs.getString(1));
        appointments.setPatientId(rs.getString(2));
        appointments.setDoctorId(rs.getString(3));
        appointments.setAppointmentDateTime(rs.getString(4));
        return appointments;
    }
}
