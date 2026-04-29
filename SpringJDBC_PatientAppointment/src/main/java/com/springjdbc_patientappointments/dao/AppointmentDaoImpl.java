package com.springjdbc_patientappointments.dao;

import com.springjdbc_patientappointments.entities.Appointments;
import org.springframework.jdbc.core.JdbcTemplate;

public class AppointmentDaoImpl implements AppointmentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Appointments appointments) {
        //insert query
        String sql = "insert into appointment_tb(appointment_id, patient_id, doctor_id, appointment_date_time) values(?, ?, ?, ?)";
        int r = this.jdbcTemplate.update(sql, appointments.getAppointmentId(), appointments.getPatientId(), appointments.getDoctorId(), appointments.getAppointmentDateTime());
        return r;
    }

    @Override
    public int delete(String deleteAppointmentId) {
        //update query
        String sql = "delete from appointment_tb where appointment_id=?";
        int r = this.jdbcTemplate.update(sql, deleteAppointmentId);
        return r;
    }

    @Override
    public Appointments viewAppointment(String appointmentId, String patientId) {
        //select/retrieve query
        String sql = "select * from appointment_tb where appointment_id=? and patient_id=?";
        AppointmentMapperImpl appointmentMapper = new AppointmentMapperImpl();
        Appointments appointments = this.jdbcTemplate.queryForObject(sql, appointmentMapper, appointmentId, patientId);
        return appointments;
    }
}
