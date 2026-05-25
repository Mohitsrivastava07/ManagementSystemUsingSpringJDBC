package com.springjdbc_studentsmanagement;


import com.springjdbc_studentsmanagement.dao.StudentDao;
import com.springjdbc_studentsmanagement.entities.Students;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

public class TestStudents {
    enum Course {
        BCA, Btech, MCA, Mtech, Bsc_Agriculture, Msc_Agriculture, Nursing, BPT
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Students students = new Students();

        ApplicationContext context = new ClassPathXmlApplicationContext("students.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        int choice1;
        String studentKid;
        String studentName;
        String studentCourse;
        int studentCurrentSemester;
        String studentAddress;


        System.out.println("Program Started.....");
        System.out.println("WELCOME TO STUDENTS MANAGEMENT SYSTEM");
        while (true) {
            System.out.println();
            System.out.println("1. Inserted Student");
            System.out.println("2. Updated Student");
            System.out.println("3. Deleted Student");
            System.out.println("4. View Students");
            System.out.println("5. Exits");

            System.out.print("Enter choice any option: ");
            if (input.hasNextInt()) {
                choice1 = input.nextInt();
                input.nextLine();

                if (choice1 == 1) {
                    System.out.println("\nInserted Students....");
                    while (true) {
                        try {
                            System.out.print("Enter student kid: ");
                            studentKid = input.nextLine();
                            if (!studentKid.matches("K\\d{5}") || studentKid.isEmpty()) {
                                throw new InvalidStudentKidException("Invalid Student Kid! Student KID have must be started with 'K' with followed by 5 digits unique numbers...");
                            } else {
                                while (true) {
                                    try {
                                        System.out.print("Enter student name: ");
                                        studentName = input.nextLine();
                                        if (!studentName.matches("[a-zA-Z ]+") || studentName.matches(".*\\d.*") || studentName.isEmpty()) {
                                            throw new InvalidStudentNameException("Invalid Student Name! Student name doest not contains any special character and any numbers...");
                                        } else {
                                            while (true) {
                                                System.out.print("Enter student course: ");
                                                studentCourse = input.nextLine();
                                                try {
                                                    Course course = Course.valueOf(studentCourse);

                                                    while (true) {
                                                        System.out.print("Enter student current semester: ");
                                                        if (input.hasNextInt()) {
                                                            studentCurrentSemester = input.nextInt();
                                                            input.nextLine();
                                                            try {
                                                                if (studentCurrentSemester > 10 || studentCurrentSemester <= 0) {
                                                                    throw new InvalidAboveSemesterException("Invalid Student Current Semester! Semester > 10 and Semester <= 0 does not valid, Semester is valid from 1 to 10...");
                                                                } else {
                                                                    while (true) {
                                                                        try {
                                                                            System.out.print("Enter student address: ");
                                                                            studentAddress = input.nextLine();
                                                                            if (!studentAddress.matches("[a-zA-Z0-9 ]+") || studentAddress.isEmpty()) {
                                                                                throw new InvalidStudentAddressException("Invalid Address! Address must be contains alphabets with number not any special character...");
                                                                            } else {
                                                                                break;
                                                                            }
                                                                        } catch (InvalidStudentAddressException e) {
                                                                            System.out.println(e.getMessage());
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                            } catch (InvalidAboveSemesterException e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        } else {
                                                            System.out.println("Invalid Student Current Semester! Current Semester of Student from 1 to 10 not above...");
                                                            input.next();
                                                        }
                                                    }
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            }
                                            break;
                                        }
                                    } catch (InvalidStudentNameException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                break;
                            }
                        } catch (InvalidStudentKidException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    students.setKid(studentKid);
                    students.setName(studentName);
                    students.setCourse(studentCourse);
                    students.setSemester(studentCurrentSemester);
                    students.setAddress(studentAddress);

                    int result = studentDao.insert(students);
                    System.out.println("\nStudent Inserted Successfully " + result);

                } else if (choice1 == 2) {
                    String studentUpdateName;
                    String studentUpdateCourse;
                    int studentUpdateCurrentSemester;
                    String studentUpdateAddress;

                    System.out.println("\nUpdated Students....");
                    while (true) {
                        try {
                            System.out.print("Enter student kid: ");
                            studentKid = input.nextLine();
                            if (!studentKid.matches("K\\d{5}") || studentKid.isEmpty()) {
                                throw new InvalidStudentKidException("Invalid Student Kid! Student KID have must be started with 'K' with followed by 5 digits unique numbers...");
                            } else {
                                while (true) {
                                    try {
                                        System.out.print("Enter update student name: ");
                                        studentUpdateName = input.nextLine();
                                        if (!studentUpdateName.matches("[a-zA-Z ]+") || studentUpdateName.matches(".*\\d.*") || studentUpdateName.isEmpty()) {
                                            throw new InvalidStudentNameException("Invalid Update Student Name! Update Student name doest not contains any special character and any numbers...");
                                        } else {
                                            while (true) {
                                                System.out.print("Enter update student course: ");
                                                studentUpdateCourse = input.nextLine();
                                                try {
                                                    Course course = Course.valueOf(studentUpdateCourse);

                                                    while (true) {
                                                        System.out.print("Enter update student current semester: ");
                                                        if (input.hasNextInt()) {
                                                            studentUpdateCurrentSemester = input.nextInt();
                                                            input.nextLine();
                                                            try {
                                                                if (studentUpdateCurrentSemester > 10 || studentUpdateCurrentSemester <= 0) {
                                                                    throw new InvalidAboveSemesterException("Invalid update Student Current Semester! Semester > 10 and Semester <= 0 does not valid, Semester is valid from 1 to 10...");
                                                                } else {
                                                                    while (true) {
                                                                        try {
                                                                            System.out.print("Enter update student address: ");
                                                                            studentUpdateAddress = input.nextLine();
                                                                            if (!studentUpdateAddress.matches("[a-zA-Z0-9 ]+") || studentUpdateAddress.isEmpty()) {
                                                                                throw new InvalidStudentAddressException("Invalid update Address! Update Address must be contains alphabets with number not any special character...");
                                                                            } else {
                                                                                break;
                                                                            }
                                                                        } catch (InvalidStudentAddressException e) {
                                                                            System.out.println(e.getMessage());
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                            } catch (InvalidAboveSemesterException e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        } else {
                                                            System.out.println("Invalid Update Student Current Semester! Update Current Semester of Student from 1 to 10 not above...");
                                                            input.next();
                                                        }
                                                    }
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            }
                                            break;
                                        }
                                    } catch (InvalidStudentNameException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                break;
                            }
                        } catch (InvalidStudentKidException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    students.setKid(studentKid);
                    students.setName(studentUpdateName);
                    students.setCourse(studentUpdateCourse);
                    students.setSemester(studentUpdateCurrentSemester);
                    students.setAddress(studentUpdateAddress);

                    int result = studentDao.update(students);
                    System.out.println("\nStudent Updated Successfully " + result);

                } else if (choice1 == 3) {
                    String deleteKid;
                    String deleteName;

                    System.out.println("\nDeleted Students....");
                    while (true) {
                        try {
                            System.out.print("Enter delete student kid: ");
                            deleteKid = input.nextLine();
                            if (!deleteKid.matches("K\\d{5}") || deleteKid.isEmpty()) {
                                throw new InvalidStudentKidException("Invalid Deleted Student Kid! Student KID have must be started with 'K' with followed by 5 digits unique numbers...");
                            } else {
                                while (true) {
                                    try {
                                        System.out.print("Enter delete student name: ");
                                        deleteName = input.nextLine();
                                        if (!deleteName.matches("[a-zA-Z ]+") || deleteName.matches(".*\\d.*") || deleteName.isEmpty()) {
                                            throw new InvalidStudentNameException("Invalid Deleted Student Name! Update Student name doest not contains any special character and any numbers...");
                                        } else {
                                            break;
                                        }
                                    } catch (InvalidStudentNameException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                break;
                            }
                        } catch (InvalidStudentKidException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    students.setKid(deleteKid);
                    students.setName(deleteName);

                    int result = studentDao.delete(students);
                    System.out.println("\nStudent Deleted Successfully! " + result);

                } else if (choice1 == 4) {
                    String viewKid;
                    String viewName;

                    System.out.println("\nView Students....");
                    while (true) {
                        try {
                            System.out.print("Enter student kid: ");
                            viewKid = input.nextLine();
                            if (!viewKid.matches("K\\d{5}") || viewKid.isEmpty()) {
                                throw new InvalidStudentKidException("Invalid Student Kid! Student KID have must be started with 'K' with followed by 5 digits unique numbers...");
                            } else {
                                while (true) {
                                    try {
                                        System.out.print("Enter student name: ");
                                        viewName = input.nextLine();
                                        if (!viewName.matches("[a-zA-Z ]+") || viewName.matches(".*\\d.*") || viewName.isEmpty()) {
                                            throw new InvalidStudentNameException("Invalid Student Name! Student name doest not contains any special character and any numbers...");
                                        } else {
                                            break;
                                        }
                                    } catch (InvalidStudentNameException e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                                break;
                            }
                        } catch (InvalidStudentKidException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    Students student = studentDao.viewStudent(viewKid, viewName);
                    System.out.println("\nRetrieve Student Data Successfully! " + student);
                    if (student != null) {
                        System.out.println("\n==============================================");
                        System.out.println("            STUDENT DETAILS TABLE             ");
                        System.out.println("==============================================");

                        System.out.printf("%-25s : %s%n", "Student KID", student.getKid());
                        System.out.printf("%-25s : %s%n", "Student Name", student.getName());
                        System.out.printf("%-25s : %s%n", "Student Course", student.getCourse());
                        System.out.printf("%-25s : %d%n", "Current Semester", student.getSemester());
                        System.out.printf("%-25s : %s%n", "Student Address", student.getAddress());
                        System.out.println("==============================================");
                    } else {
                        System.out.println("Student Record Not Found!");
                    }
                    System.out.println();

                } else if (choice1 == 5) {
                    System.out.print("Exiting System");
                    int i = 5;
                    while (i != 0) {
                        System.out.print(".");
                        Thread.sleep(400);
                        i--;
                    }
                    System.out.println();
                }

            } else {
                System.out.println("Invalid Choice Option! Try Again...");
                input.next();
            }
        }


    }
}
