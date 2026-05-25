package com.springjdbc_studentsmanagement.entities;

public class Students {
    private String kid;
    private String name;
    private String course;
    private int semester;
    private String address;

    public Students() {

    }
    public Students(String kid, String name, String course, int semester, String address) {
        this.kid = kid;
        this.name = name;
        this.course = course;
        this.semester = semester;
        this.address = address;
    }

    public String getKid() {
        return kid;
    }
    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Students{" +
                "kid='" + kid + '\'' +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", semester=" + semester +
                ", address='" + address + '\'' +
                '}';
    }
}
