package com.springjdbc_studentsmanagement.dao;

import com.springjdbc_studentsmanagement.entities.Students;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Students students) {
        //insert query
        String sqlQuery = "insert into student_tb(kid, name, course, semester, address) values(?, ?, ?, ?, ?)";
        int r = this.jdbcTemplate.update(sqlQuery, students.getKid(), students.getName(), students.getCourse(), students.getSemester(), students.getAddress());
        return r;
    }

    @Override
    public int update(Students students) {
        String sqlQuery = "update student_tb set name=?, course=?, semester=?, address=? where kid=?";
        int r  = this.jdbcTemplate.update(sqlQuery, students.getName(), students.getCourse(), students.getSemester(), students.getAddress(), students.getKid());
        return r;
    }

    @Override
    public int delete(Students students) {
        String sqlQuery = "delete from student_tb where kid=? and name=?";
        int r = this.jdbcTemplate.update(sqlQuery, students.getKid(), students.getName());
        return r;
    }

    @Override
    public Students viewStudent(String kid, String name) {
        String sqlQuery = "select * from student_tb where kid=? and name=?";
        StudentsMapperImpl studentsMapper = new StudentsMapperImpl();
        Students students = (Students) this.jdbcTemplate.queryForObject(sqlQuery, studentsMapper, kid, name);
        return students;
    }
}
