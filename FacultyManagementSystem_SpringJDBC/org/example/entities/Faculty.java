package org.example.entities;

public class Faculty {
    private String fId;
    private String facultyName;
    private String emailId;
    private String roomNumber;
    private String whichMonth;

    public Faculty(String fId, String facultyName, String emailId, String roomNumber, String whichMonth) {
        this.fId = fId;
        this.facultyName = facultyName;
        this.emailId = emailId;
        this.roomNumber = roomNumber;
        this.whichMonth = whichMonth;
    }

    public Faculty() {

    }

    public String getfId() {
        return fId;
    }
    public void setfId(String fId) {
        this.fId = fId;
    }
    public String getFacultyName() {
        return facultyName;
    }
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getWhichMonth() {
        return whichMonth;
    }
    public void setWhichMonth(String whichMonth) {
        this.whichMonth = whichMonth;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "fId='" + fId + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", whichMonth='" + whichMonth + '\'' +
                '}';
    }
}
