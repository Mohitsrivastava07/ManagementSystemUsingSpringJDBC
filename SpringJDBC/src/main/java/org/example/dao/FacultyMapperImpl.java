package org.example.dao;

import org.example.entities.Faculty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyMapperImpl implements RowMapper<Faculty> {

    @Override
    public Faculty mapRow(ResultSet rs, int rowNum) throws SQLException {
        Faculty faculty = new Faculty();
        faculty.setfId(rs.getString(1));
        faculty.setFacultyName(rs.getString(2));
        faculty.setEmailId(rs.getString(3));
        faculty.setRoomNumber(rs.getString(4));
        faculty.setWhichMonth(rs.getString(5));
        return faculty;
    }
}
