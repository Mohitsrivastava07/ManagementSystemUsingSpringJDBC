package com.springjdbc_studentsmanagement.dao;

import com.springjdbc_studentsmanagement.entities.Students;

public interface StudentDao {
    public int insert(Students students);
    public int update(Students students);
    public int delete(Students students);
    public Students viewStudent(String kid, String name);
}
