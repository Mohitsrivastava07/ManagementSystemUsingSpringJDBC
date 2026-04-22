package org.example.dao;

import org.example.entities.Faculty;
import org.springframework.jdbc.core.JdbcTemplate;

public class FacultyDaoImpl implements FacultyDao {
    private JdbcTemplate jdbcTemplate;

    public int insert(Faculty faculty) {
        //insert query
        String query = "insert into faculty_tb(fid, faculty_name, email_id, room_number, which_month) values(?, ?, ?, ? ,?)";
        int r = this.jdbcTemplate.update(query, faculty.getfId(), faculty.getFacultyName(), faculty.getEmailId(), faculty.getRoomNumber(), faculty.getWhichMonth());
        return r;
    }

    public int update(Faculty faculty) {
        //update query
        String query = "update faculty_tb set faculty_name=?, email_id=?, room_number=?, which_month=? where fid=?";
        int r = this.jdbcTemplate.update(query, faculty.getFacultyName(), faculty.getEmailId(), faculty.getRoomNumber(), faculty.getWhichMonth(), faculty.getfId());
        return r;
    }

    public int delete(String facultyId, String facultyName) {
        //delete query
        String query = "delete from faculty_tb where fid=? and faculty_name=?";
        int r = this.jdbcTemplate.update(query, facultyId, facultyName);
        return r;
    }

    public Faculty getFaculty(String facultyId, String facultyName) {
        //single faculty retrieve
        String query = "select * from faculty_tb where fid=?";
        FacultyMapperImpl facultyMapper = new FacultyMapperImpl();
        Faculty faculty = this.jdbcTemplate.queryForObject(query, facultyMapper, facultyId);
        return faculty;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
