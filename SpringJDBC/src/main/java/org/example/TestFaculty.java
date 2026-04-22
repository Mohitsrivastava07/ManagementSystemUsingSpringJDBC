package org.example;

import org.example.dao.FacultyDao;
import org.example.entities.Faculty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

public class TestFaculty {
    enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
        JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("My program started......");

        ApplicationContext context = new ClassPathXmlApplicationContext("faculty.xml");
        FacultyDao facultyDao = context.getBean("facultyDao", FacultyDao.class);

        Faculty faculty = new Faculty();


        while (true) {
            System.out.println();
            System.out.println("1. Faculty Insert");
            System.out.println("2. Faculty View By FID(faculty id)");
            System.out.println("3. Faculty Update");
            System.out.println("4. Faculty Delete");
            System.out.println("0. Exit");

            try {
                System.out.print("Choice any option (from 0 to 4): ");
                int choice1 = input.nextInt();
                input.nextLine();
                switch (choice1) {
                    case 1:
                        System.out.println();
                        String faculty_id;
                        String faculty_name;
                        String email_id;
                        String room_number;
                        String which_month;

                        while(true) {
                            try {
                                System.out.print("Enter faculty id: ");
                                faculty_id = input.nextLine();
                                if (!faculty_id.matches("F\\d{5}")) {
                                    throw new IncludingFiveDigitsException("Invalid faculty id! Must be started with 'F' with followed by 5-digits...");
                                } else {
                                    while (true) {
                                        try {
                                            System.out.print("Enter faculty name: ");
                                            faculty_name = input.nextLine();
                                            if (faculty_name.matches(".*\\d.*")) {
                                                throw new InvalidFacultyNameException("Invalid faculty name! Not include any number...");
                                            } else {
                                                while (true) {
                                                    try {
                                                        System.out.print("Enter faculty email id: ");
                                                        email_id = input.nextLine();
                                                        if (!email_id.endsWith("@gmail.com")) {
                                                            throw new InvalidEmailIdException("Invalid faculty email id! Email id must be ends-with '@gmail.com'...");
                                                        } else {
                                                            while (true) {
                                                                try {
                                                                    System.out.print("Enter faculty room number: ");
                                                                    room_number = input.nextLine();
                                                                    if((!room_number.matches("A\\d{3}")) && (!room_number.matches("B\\d{3}"))) {
                                                                        throw new InvalidRoomNumberWithThreeDigits("Invalid faculty room number! Room number started with 'A' or 'B' with both followed by three digits...");
                                                                    } else {
                                                                        while (true) {
                                                                            System.out.print("Enter a month name: ");
                                                                            which_month = input.nextLine().toUpperCase();
                                                                            try {
                                                                                Month message = Month.valueOf(which_month);
                                                                                break;
                                                                            }
                                                                            catch (IllegalArgumentException e) {
                                                                                System.out.println("Invalid month! Try again.");
                                                                            }
                                                                        }
                                                                        break;
                                                                    }
                                                                } catch (InvalidRoomNumberWithThreeDigits e) {
                                                                    System.out.println(e.getMessage());
                                                                }
                                                            }
                                                            break;
                                                        }
                                                    } catch (InvalidEmailIdException e) {
                                                        System.out.println(e.getMessage());
                                                    }
                                                }
                                                break;
                                            }
                                        } catch (InvalidFacultyNameException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    }
                                    break;
                                }
                            } catch (IncludingFiveDigitsException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        faculty.setfId(faculty_id);
                        faculty.setFacultyName(faculty_name);
                        faculty.setEmailId(email_id);
                        faculty.setRoomNumber(room_number);
                        faculty.setWhichMonth(which_month);
                        int result1 = facultyDao.insert(faculty);
                        System.out.println("Faculty Inserted " + result1);
                        break;

                    case 2:
                        String viewFacultyId;
                        String viewFacultyName;

                        while (true) {
                            try {
                                System.out.print("Enter faculty id: ");
                                viewFacultyId = input.nextLine();
                                if (!viewFacultyId.matches("F\\d{5}")) {
                                    throw new IncludingFiveDigitsException("Invalid faculty id! Must be started with 'F' with followed by 5-digits...");
                                } else {
                                    while (true) {
                                        try {
                                            System.out.print("Enter faculty name: ");
                                            viewFacultyName = input.nextLine();
                                            if (viewFacultyName.matches(".*\\d.*")) {
                                                throw new InvalidFacultyNameException("Invalid faculty name! Not include any number...");
                                            } else {
                                                break;
                                            }
                                        } catch (InvalidFacultyNameException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    }
                                    break;
                                }
                            } catch (IncludingFiveDigitsException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        Faculty faculty1 = facultyDao.getFaculty(viewFacultyId, viewFacultyName);
                        System.out.println(faculty1);
                        break;

                    case 3:
                        String fId;
                        String updateFacultyName;
                        String updateFacultyEmailId;
                        String updateRoomNumber;
                        String updateWhichMonth;

                        while(true) {
                            try {
                                System.out.print("Enter faculty id: ");
                                fId = input.nextLine();
                                if (!fId.matches("F\\d{5}")) {
                                    throw new IncludingFiveDigitsException("Invalid faculty id! Must be started with 'F' with followed by 5-digits...");
                                } else {
                                    while (true) {
                                        try {
                                            System.out.print("Enter update faculty name: ");
                                            updateFacultyName = input.nextLine();
                                            if (updateFacultyName.matches(".*\\d.*")) {
                                                throw new InvalidFacultyNameException("Invalid faculty name! Not include any number...");
                                            } else {
                                                while (true) {
                                                    try {
                                                        System.out.print("Enter update faculty email id: ");
                                                        updateFacultyEmailId = input.nextLine();
                                                        if (!updateFacultyEmailId.endsWith("@gmail.com")) {
                                                            throw new InvalidEmailIdException("Invalid faculty email id! Email id must be ends-with '@gmail.com'...");
                                                        } else {
                                                            while (true) {
                                                                try {
                                                                    System.out.print("Enter update faculty room number: ");
                                                                    updateRoomNumber = input.nextLine();
                                                                    if((!updateRoomNumber.matches("A\\d{3}")) && (!updateRoomNumber.matches("B\\d{3}"))) {
                                                                        throw new InvalidRoomNumberWithThreeDigits("Invalid faculty room number! Room number started with 'A' or 'B' with both followed by three digits...");
                                                                    } else {
                                                                        while (true) {
                                                                            System.out.print("Enter update month name(as deposit fees): ");
                                                                            updateWhichMonth = input.nextLine().toUpperCase();
                                                                            try {
                                                                                Month message = Month.valueOf(updateWhichMonth);
                                                                                break;
                                                                            }
                                                                            catch (IllegalArgumentException e) {
                                                                                System.out.println("Invalid month! Try again.");
                                                                            }
                                                                        }
                                                                        break;
                                                                    }
                                                                } catch (InvalidRoomNumberWithThreeDigits e) {
                                                                    System.out.println(e.getMessage());
                                                                }
                                                            }
                                                            break;
                                                        }
                                                    } catch (InvalidEmailIdException e) {
                                                        System.out.println(e.getMessage());
                                                    }
                                                }
                                                break;
                                            }
                                        } catch (InvalidFacultyNameException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    }
                                    break;
                                }
                            } catch (IncludingFiveDigitsException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        faculty.setfId(fId);
                        faculty.setFacultyName(updateFacultyName);
                        faculty.setEmailId(updateFacultyEmailId);
                        faculty.setRoomNumber(updateRoomNumber);
                        faculty.setWhichMonth(updateWhichMonth);
                        int result2 = facultyDao.update(faculty);
                        System.out.println("Faculty Updated " + result2);
                        break;

                    case 4:
                        String facultyId;
                        String facultyName;

                        while (true) {
                            try {
                                System.out.print("Enter faculty id: ");
                                facultyId = input.nextLine();
                                if (!facultyId.matches("F\\d{5}")) {
                                    throw new IncludingFiveDigitsException("Invalid faculty id! Must be started with 'F' with followed by 5-digits...");
                                } else {
                                    while (true) {
                                        try {
                                            System.out.print("Enter faculty name: ");
                                            facultyName = input.nextLine();
                                            if (facultyName.matches(".*\\d.*")) {
                                                throw new InvalidFacultyNameException("Invalid faculty name! Not include any number...");
                                            } else {
                                                break;
                                            }
                                        } catch (InvalidFacultyNameException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    }
                                    break;
                                }
                            } catch (IncludingFiveDigitsException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        faculty.setfId(facultyId);
                        faculty.setFacultyName(facultyName);
                        int result3 = facultyDao.delete(facultyId, facultyName);
                        System.out.println("Faculty Deleted " + result3);
                        break;

                    default:
                        System.out.println("Invalid Choice! Try Again...");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }
}

//PreparedStatementCallback; bad SQL grammar [update faculty set faculty_name=?, email_id=?, room_number=?, which_month=? where fid=?];
//nested exception is java.sql.SQLSyntaxErrorException: Table 'spring_faculty.faculty' doesn't exist    in update time.

