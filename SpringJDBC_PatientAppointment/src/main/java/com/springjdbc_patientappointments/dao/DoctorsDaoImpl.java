package com.springjdbc_patientappointments.dao;

import com.springjdbc_patientappointments.entities.Doctors;
import org.springframework.jdbc.core.JdbcTemplate;

public class DoctorsDaoImpl implements  DoctorsDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Doctors viewDoctors(String doctorId, String doctorName) {
        //only retrieve query
        String sql = "select * from doctor_tb where doctor_id=? and doctor_name=?";
        DoctorsMapperImpl doctorMapper = new DoctorsMapperImpl();
        Doctors doctors = this.jdbcTemplate.queryForObject(sql, doctorMapper, doctorId, doctorName);
        return doctors;
    }

    @Override
    public int update(Doctors doctors) {
        //update query
        String sql = "update doctor_tb set doctor_name=?, doctor_gender=?, specialization=? where doctor_id=?";
        int r = this.jdbcTemplate.update(sql, doctors.getDoctorName(), doctors.getDoctorGender(), doctors.getDoctorSpecialization(), doctors.getDoctorId());
        return r;
    }

    @Override
    public int delete(String doctorId, String doctorName) {
        //delete query
        String sql = "delete from doctor_tb where doctor_id=? and doctor_name=?";
        int r = this.jdbcTemplate.update(sql, doctorId, doctorName);
        return r;
    }


}
