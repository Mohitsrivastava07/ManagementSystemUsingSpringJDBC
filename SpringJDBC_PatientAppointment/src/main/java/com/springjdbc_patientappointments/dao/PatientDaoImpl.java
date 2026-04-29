package com.springjdbc_patientappointments.dao;

import com.springjdbc_patientappointments.entities.Patients;
import org.springframework.jdbc.core.JdbcTemplate;

public class PatientDaoImpl implements PatientsDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Patients patients) {
        //insert query
        String sql = "insert into patient_tb(patient_id, patient_name, patient_gender, patient_age, patient_address) values(?, ?, ?, ?, ?)";
        int r = this.jdbcTemplate.update(sql, patients.getPatientId(), patients.getPatientName(), patients.getPatientGender(), patients.getPatientAge(), patients.getPatientAddress());
        return r;
    }

    @Override
    public int delete(String patientId, String patientName) {
        //delete query
        String sql = "delete from patient_tb where patient_id=? and patient_name=?";
        int r = this.jdbcTemplate.update(sql, patientId, patientName);
        return r;
    }

    @Override
    public int update(Patients patients) {
        //update query
        String sql = "update patient_tb set patient_name=?, patient_gender=?, patient_age=?, patient_address=? where patient_id=? and patient_name=?";
        int r = this.jdbcTemplate.update(sql, patients.getPatientName(), patients.getPatientGender(), patients.getPatientAge(), patients.getPatientAddress(), patients.getPatientId(), patients.getPatientName());
        return r;
    }

    public Patients viewPatient(String patientId, String patientName) {
        //select/retieve query
        String sql = "select * from patient_tb where patient_id=? and patient_name=?";
        PatientMapperImpl patientMapper = new PatientMapperImpl();
        Patients patients = this.jdbcTemplate.queryForObject(sql, patientMapper, patientId, patientName);
        return patients;
    }
}
