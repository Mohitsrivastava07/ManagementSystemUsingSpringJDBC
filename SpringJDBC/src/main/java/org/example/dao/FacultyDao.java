package org.example.dao;

import org.example.entities.Faculty;

public interface FacultyDao {
    public int insert(Faculty faculty);
    public int update(Faculty faculty);
    public int delete(String facultyId, String facultyName);
    public Faculty getFaculty(String facultyId, String facultyName);
}
