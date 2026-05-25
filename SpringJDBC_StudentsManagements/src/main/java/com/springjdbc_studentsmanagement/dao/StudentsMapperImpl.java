package com.springjdbc_studentsmanagement.dao;

import com.springjdbc_studentsmanagement.entities.Students;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsMapperImpl implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Students students = new Students();
        students.setKid(rs.getString(1));
        students.setName(rs.getString(2));
        students.setCourse(rs.getString(3));
        students.setSemester(rs.getInt(4));
        students.setAddress(rs.getString(5));
        return students;
    }
}
