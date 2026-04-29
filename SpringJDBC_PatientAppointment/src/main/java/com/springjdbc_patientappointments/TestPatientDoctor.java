package com.springjdbc_patientappointments;

import com.springjdbc_patientappointments.dao.AppointmentDao;
import com.springjdbc_patientappointments.dao.DoctorsDao;
import com.springjdbc_patientappointments.dao.PatientsDao;
import com.springjdbc_patientappointments.entities.Doctors;
import com.springjdbc_patientappointments.entities.Patients;
import com.springjdbc_patientappointments.entities.Appointments;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class TestPatientDoctor {
    enum Gender {
        Male, Female, Other
    }
    enum Specialization {
        Cardiologist, Dermatologist, Neurologist, Pediatrician, Orthopedic, Gynecologist, Ophthalmologist, Psychiatrist
    }
    public static void main(String[] args) throws InterruptedException, InvalidDoctorGenderException, InvalidAppointmentIdException {
        Scanner input = new Scanner(System.in);

        System.out.println("Program is Started....");

        ApplicationContext context1 = new ClassPathXmlApplicationContext("patients.xml");
        ApplicationContext context2 = new ClassPathXmlApplicationContext("doctors.xml");
        ApplicationContext context3 = new ClassPathXmlApplicationContext("appointment.xml");
        PatientsDao patientsDao = context1.getBean("patientDao", PatientsDao.class);
        DoctorsDao doctorsDao = context2.getBean("doctorDao", DoctorsDao.class);
        AppointmentDao appointmentDao = context3.getBean("appointmentDao", AppointmentDao.class);

        Patients patients = new Patients();
        Doctors doctors = new Doctors();
        Appointments appointments = new Appointments();

        String patientId;
        String patientName;
        String patientGender;
        int patientAge;
        String patientAddress;

        while (true) {
            System.out.println();
            System.out.println("1. Patients");
            System.out.println("2. Doctors");
            System.out.println("3. Appointments");
            System.out.print("Choice any Option: ");
            if (input.hasNextInt()) {
                int mainChoice = input.nextInt();
                input.nextLine();
                while (true) {
                    switch (mainChoice) {
                        case 1:
                            System.out.println();
                            System.out.println();
                            System.out.println("1. Insert Patient");
                            System.out.println("2. View Particular Patient");
                            System.out.println("3. Update Patient");
                            System.out.println("4. Delete Patients");
                            System.out.println("0. Exit");
                            System.out.print("Choice any Option: ");
                            if (input.hasNextInt()) {
                                int secondChoice = input.nextInt();
                                input.nextLine();
                                switch (secondChoice) {
                                    case 1:
                                        System.out.println();
                                        System.out.println("  Inserting the data of patient");
                                        System.out.println("-----------------------------------");
                                        while (true) {
                                            try {
                                                System.out.print("Enter patient Id: ");
                                                patientId = input.nextLine();
                                                if (!patientId.matches("P\\d{3}")) {
                                                    throw new InvalidPatientIdException("Invalid Patient Id! Patient Id have start with 'P' as followed by 3 digits unique number...");
                                                } else {
                                                    while (true) {
                                                        try {
                                                            System.out.print("Enter patient name: ");
                                                            patientName = input.nextLine();
                                                            if ((patientName.matches(".*\\d.*")) && (!patientName.matches("[a-zA-Z]"))) {
                                                                throw new InvalidPatientNameException("Invalid Patient Name! Patient Name have not any number and special character...");
                                                            } else {
                                                                while (true) {
                                                                    System.out.print("Enter patient gender: ");
                                                                    patientGender = input.nextLine();
                                                                    try {
                                                                        Gender gender = Gender.valueOf(patientGender);
                                                                        while (true) {
                                                                            System.out.print("Enter patient age: ");
                                                                            if (input.hasNextInt()) {
                                                                                patientAge = input.nextInt();
                                                                                input.nextLine();
                                                                                while (true) {
                                                                                    try {
                                                                                        System.out.print("Enter patient address: ");
                                                                                        patientAddress = input.nextLine();
                                                                                        if (patientAddress.matches(".*\\d.*")) {
                                                                                            throw new InvalidPatientAddressException("Invalid Patient Address! Try Again (Not be include any number and special character)...");
                                                                                        } else {
                                                                                            break;
                                                                                        }
                                                                                    } catch (InvalidPatientAddressException e) {
                                                                                        System.out.println(e.getMessage());
                                                                                    }
                                                                                }
                                                                                break;
                                                                            } else {
                                                                                System.out.println("Invalid patient age! Must be Number...");
                                                                                input.next();
                                                                            }
                                                                        }
                                                                        break;
                                                                    }
                                                                    catch (IllegalArgumentException e) {
                                                                        System.out.println("Invalid gender! Must be in form of 'Male', 'Female' & 'Other'...");
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                        } catch (InvalidPatientNameException e) {
                                                            System.out.println(e.getMessage());
                                                        }
                                                    }
                                                    break;
                                                }
                                            } catch (InvalidPatientIdException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }

                                        patients.setPatientId(patientId);
                                        patients.setPatientName(patientName);
                                        patients.setPatientGender(patientGender);
                                        patients.setPatientAge(String.valueOf(patientAge));
                                        patients.setPatientAddress(patientAddress);
                                        int result = patientsDao.insert(patients);
                                        System.out.println("Patients Inserted Successfully! " + result);
                                        break;

                                    case 2:
                                        while (true) {
                                            try {
                                                System.out.print("Enter patient id: ");
                                                patientId = input.nextLine();
                                                if (!patientId.matches("P\\d{3}")) {
                                                    throw new InvalidPatientIdException("Invalid Patient Id! Patient Id must have start with 'P' with foloowed by 3 digits unique number...");
                                                } else {
                                                    while (true) {
                                                        try {
                                                            System.out.print("Enter patient name: ");
                                                            patientName = input.nextLine();
                                                            if ((!patientName.matches("[a-zA-Z] ")) && (patientName.matches(".*\\d.*"))) {
                                                                throw new InvalidPatientNameException("Invalid Patient Name! Patient name have not include any number and special character...");
                                                            } else {
                                                                break;
                                                            }
                                                        } catch (InvalidPatientNameException e) {
                                                            System.out.println(e.getMessage());
                                                        }
                                                    }
                                                    break;
                                                }
                                            } catch (InvalidPatientIdException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }

                                        Patients patients1 = patientsDao.viewPatient(patientId, patientName);
                                        System.out.println("Patient retrieve successfully! " + patients1);
                                        break;

                                    case 3:
                                        while (true) {
                                            try {
                                                System.out.print("Enter patient id: ");
                                                patientId = input.nextLine();
                                                if (!patientId.matches("P\\d{3}")) {
                                                    throw new InvalidPatientIdException("Invalid Patient Id! Patient Id must have start with 'P' with followed by 3 digits unique number...");
                                                } else {
                                                    while (true) {
                                                        try {
                                                            System.out.print("Enter patient name: ");
                                                            patientName = input.nextLine();
                                                            if ((!patientName.matches("[a-zA-Z] ")) && (patientName.matches(".*\\d.*"))) {
                                                                throw new InvalidPatientNameException("Invalid Patient Name! Patient name have not include any number and special character...");
                                                            } else {
                                                                break;
                                                            }
                                                        } catch (InvalidPatientNameException e) {
                                                            System.out.println(e.getMessage());
                                                        }
                                                    }
                                                    break;
                                                }
                                            } catch (InvalidPatientIdException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }

                                        patients.setPatientId(patientId);
                                        patients.setPatientName(patientName);
                                        int patients2 = patientsDao.delete(patientId, patientName);
                                        System.out.println("Patient Deleted Successfully! " + patients2);
                                        break;

                                    case 4:
                                        String updatePatientName;
                                        String updatePatientGender;
                                        int updatePatientAge;
                                        String updatePatientAddress;

                                        while (true) {
                                            try {
                                                System.out.print("Enter patient Id: ");
                                                patientId = input.nextLine();
                                                if (!patientId.matches("P\\d{3}")) {
                                                    throw new InvalidPatientIdException("Invalid Patient Id! Patient Id have start with 'P' as followed by 3 digits unique number...");
                                                } else {
                                                    while (true) {
                                                        try {
                                                            System.out.print("Enter update patient name: ");
                                                            updatePatientName = input.nextLine();
                                                            if ((updatePatientName.matches(".*\\d.*")) && (!updatePatientName.matches("[a-zA-Z]"))) {
                                                                throw new InvalidPatientNameException("Invalid Patient Name! Patient Name have not any number and special character...");
                                                            } else {
                                                                while (true) {
                                                                    System.out.print("Enter update patient gender: ");
                                                                    updatePatientGender = input.nextLine();
                                                                    try {
                                                                        Gender gender = Gender.valueOf(updatePatientGender);
                                                                        while (true) {
                                                                            System.out.print("Enter update patient age: ");
                                                                            if (input.hasNextInt()) {
                                                                                updatePatientAge = input.nextInt();
                                                                                input.nextLine();
                                                                                while (true) {
                                                                                    try {
                                                                                        System.out.print("Enter update patient address: ");
                                                                                        updatePatientAddress = input.nextLine();
                                                                                        if (updatePatientAddress.matches(".*\\d.*")) {
                                                                                            throw new InvalidPatientAddressException("Invalid Patient Address! Try Again (Not be include any number and special character)...");
                                                                                        } else {
                                                                                            break;
                                                                                        }
                                                                                    } catch (InvalidPatientAddressException e) {
                                                                                        System.out.println(e.getMessage());
                                                                                    }
                                                                                }
                                                                                break;
                                                                            } else {
                                                                                System.out.println("Invalid patient age! Must be Number...");
                                                                                input.next();
                                                                            }
                                                                        }
                                                                        break;
                                                                    }
                                                                    catch (IllegalArgumentException e) {
                                                                        System.out.println("Invalid gender! Must be in form of 'Male', 'Female' & 'Other'...");
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                        } catch (InvalidPatientNameException e) {
                                                            System.out.println(e.getMessage());
                                                        }
                                                    }
                                                    break;
                                                }
                                            } catch (InvalidPatientIdException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }

                                        patients.setPatientId(patientId);
                                        patients.setPatientName(updatePatientName);
                                        patients.setPatientGender(updatePatientGender);
                                        patients.setPatientAge(String.valueOf(updatePatientAge));
                                        patients.setPatientAddress(updatePatientAddress);
                                        int updateResult = patientsDao.update(patients);
                                        System.out.println("Patient Update Successfully! " + updateResult);
                                        break;

                                    case 0:
                                        System.out.print("Exiting System");
                                        int i = 5;
                                        while (i != 0) {
                                            System.out.print(".");
                                            Thread.sleep(400);
                                            i--;
                                        }
                                        System.out.println();
                                        break;
                                    default:
                                        System.out.println("Invalid Choice! Try Again...");
                                }
                                if (secondChoice == 0) {
                                    break;
                                }
                            } else {
                                System.out.println("Invalid Second Choice! Try Again...");
                                input.next();
                            }
                            break;
                        case 2:
                            String doctorId;
                            String doctorName;

                            while (true) {
                                System.out.println();
                                System.out.println();
                                System.out.println("1. View Particular Doctor");
                                System.out.println("2. Update Doctor");
                                System.out.println("3. Delete Doctor");
                                System.out.println("0. Exit");
                                System.out.print("Choice any option: ");
                                if (input.hasNextInt()) {
                                    int doctorChoice = input.nextInt();
                                    input.nextLine();
                                    switch (doctorChoice) {
                                        case 1:
                                            while (true) {
                                                try {
                                                    System.out.print("Enter doctor id: ");
                                                    doctorId = input.nextLine();
                                                    if (!doctorId.matches("D\\d{3}")) {
                                                        throw new InvalidDoctorIdException("Invalid Doctor Id! Doctor Id must have start with 'D' with followed by 3 unique digits numbers..");
                                                    } else {
                                                        while (true) {
                                                            try {
                                                                System.out.print("Enter doctor name: ");
                                                                doctorName = input.nextLine();
                                                                if ((doctorName.matches("[a-zA-z ]")) && (!doctorName.matches(".*\\d.*"))) {
                                                                    throw new InvalidDoctorNameException("Invalid Doctor Name! Doctor name have not include any number and special character...");
                                                                } else {
                                                                    break;
                                                                }
                                                            } catch (InvalidDoctorNameException e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        }
                                                        break;
                                                    }
                                                } catch (InvalidDoctorIdException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            }

                                            Doctors doctorResult = doctorsDao.viewDoctors(doctorId, doctorName);
                                            System.out.println("Doctor Retrieve Successfully! \n" + doctorResult);
                                            break;

                                        case 2:
                                            String updateDoctorName;
                                            String updateDoctorGender;
                                            String updateSpecialization;

                                            while (true) {
                                                try {
                                                    System.out.print("Enter doctor id: ");
                                                    doctorId = input.nextLine();
                                                    if (!doctorId.matches("D\\d{3}")) {
                                                        throw new InvalidDoctorIdException("Invalid Doctor Id! Doctor Id must have start with 'D' with followed by 3 digits unique numbers...");
                                                    } else {
                                                        while (true) {
                                                            try {
                                                                System.out.print("Enter update doctor name: ");
                                                                updateDoctorName = input.nextLine();
                                                                if ((!updateDoctorName.matches("[a-zA-Z ]")) && (updateDoctorName.matches(".*\\d.*"))) {
                                                                    throw new InvalidDoctorNameException("Invalid Doctor Name! Doctor name have not include any number ans special character...");
                                                                } else {
                                                                    while (true) {
                                                                        try {
                                                                            System.out.print("Enter update doctor gender: ");
                                                                            updateDoctorGender = input.nextLine();
                                                                            if (updateDoctorGender.matches(".*\\d.*")) {
                                                                                throw new InvalidDoctorGenderException("Invalid Doctor Gender! Doctor Gender have male, female, other NOT any numbers...");
                                                                            } else {
                                                                                while (true) {
                                                                                    System.out.print("Enter update patient specialization: ");
                                                                                    updateSpecialization = input.nextLine();
                                                                                    try {
                                                                                        Specialization specialization = Specialization.valueOf(updateSpecialization);
                                                                                        break;
                                                                                    } catch (IllegalArgumentException e) {
                                                                                        System.out.println("Invalid Specialization! Must be in form of Cardiologist, Dermatologist, Neurologist, Pediatrician, Orthopedic, Gynecologist, Ophthalmologist, Psychiatrist...");
                                                                                    }
                                                                                }
                                                                                break;
                                                                            }
                                                                        } catch (InvalidDoctorGenderException e) {
                                                                            System.out.println(e.getMessage());
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                            } catch (InvalidDoctorNameException e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        }
                                                        break;
                                                    }
                                                } catch (InvalidDoctorIdException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            }

                                            doctors.setDoctorId(doctorId);
                                            doctors.setDoctorName(updateDoctorName);
                                            doctors.setDoctorGender(updateDoctorGender);
                                            doctors.setDoctorSpecialization(updateSpecialization);
                                            int updateResult = doctorsDao.update(doctors);
                                            System.out.println("Doctors Updates Successfully! " + updateResult);
                                            break;

                                        case 3:
                                            String deleteDoctorId;
                                            String deleteDoctorName;

                                            while (true) {
                                                try {
                                                    System.out.print("Enter doctor id: ");
                                                    deleteDoctorId = input.nextLine();
                                                    if (!deleteDoctorId.matches("D\\d{3}")) {
                                                        throw new InvalidDoctorIdException("Invalid Doctor Id! Doctor Id have must be start with 'D' with followed by 3 digits unique numbers...");
                                                    } else {
                                                        while (true) {
                                                            try {
                                                                System.out.print("Enter doctor name: ");
                                                                deleteDoctorName = input.nextLine();
                                                                if ((!deleteDoctorName.matches("[a-zA-Z ]")) && (deleteDoctorName.matches(".*\\d.*"))) {
                                                                    throw new InvalidDoctorNameException("Invalid Doctor Name! Doctor name start have not include any number and special character...");
                                                                } else {
                                                                    break;
                                                                }
                                                            } catch (InvalidDoctorNameException e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        }
                                                        break;
                                                    }
                                                } catch (InvalidDoctorIdException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            }

                                            doctors.setDoctorId(deleteDoctorId);
                                            doctors.setDoctorName(deleteDoctorName);
                                            int deleteResult = doctorsDao.delete(deleteDoctorId, deleteDoctorName);
                                            System.out.println("Doctor Deleted Successfully! " + deleteResult);
                                            break;
                                            
                                        case 0:
                                            System.out.print("Exiting System");
                                            int i = 5;
                                            while (i != 0) {
                                                System.out.print(".");
                                                Thread.sleep(400);
                                                i--;
                                            }
                                            System.out.println();
                                            break;

                                        default:
                                            System.out.println("Invalid Choice! Try Again...");
                                    }
                                    if (doctorChoice == 0) {
                                        break;
                                    }
                                } else {
                                    System.out.println("Invalid Doctor Choice! Try Again...");
                                    input.next();
                                }
                            }
                            break;

                        case 3:
                            String appointmentsId;
                            String appointPatientId;
                            String appointDoctorId;
                            String appointmentDateTime;

                            while (true) {
                                System.out.println();
                                System.out.println("1. Insert Appointments");
                                System.out.println("2. Delete Appointments");
                                System.out.println("3. View Appointments");
                                System.out.print("Choice any Option: ");
                                if (input.hasNext()) {
                                    int appointmentChoice = input.nextInt();
                                    input.nextLine();
                                    switch (appointmentChoice) {
                                        case 1:
                                            while (true) {
                                                try {
                                                    System.out.print("Enter Appointment Id: ");
                                                    appointmentsId = input.nextLine();
                                                    if (!appointmentsId.matches("A\\d{3}")) {
                                                        throw new InvalidAppointmentIdException("Invalid Appointments Id! Appointment Id must have start with 'A' as followed by 3 digits unique numbers... ");
                                                    } else {
                                                        while (true) {
                                                            try {
                                                                System.out.print("Enter Patient Id: ");
                                                                appointPatientId = input.nextLine();
                                                                if (!appointPatientId.matches("P\\d{3}")) {
                                                                    throw new InvalidAppointmentPatientIdException("Invalid Appointment-Patient Id! Appointment Id must have start with 'P' as followed by 3 digits unique numbers...");
                                                                } else {
                                                                    while (true) {
                                                                        try {
                                                                            System.out.print("Enter Doctor Id: ");
                                                                            appointDoctorId = input.nextLine();
                                                                            if (!appointDoctorId.matches("D\\d{3}")) {
                                                                                throw new InvalidAppointmentDoctorIdException("Invalid Appointment-Doctor Id! Appointment Id must have start with 'D' as followed by 3 digits unique numbers...");
                                                                            } else {
                                                                                while(true) {
                                                                                    try {
                                                                                        System.out.print("Enter Appointment Date Time: ");
                                                                                        appointmentDateTime = input.nextLine();
                                                                                        if (!appointmentDateTime.matches("^\\d{4}-\\d{2}-\\d{2}")) {
                                                                                            throw new InvalidAppointmentDateTimeException("Invalid Appointment Date Time! Formate of Date Time is (YYYY-MM-DD)...");
                                                                                        } else {
                                                                                            break;
                                                                                        }
                                                                                    } catch (InvalidAppointmentDateTimeException e) {
                                                                                        System.out.println(e.getMessage());
                                                                                    }
                                                                                }
                                                                                break;
                                                                            }
                                                                        } catch (InvalidAppointmentDoctorIdException e) {
                                                                            System.out.println(e.getMessage());
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                            } catch (InvalidAppointmentPatientIdException e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        }
                                                        break;
                                                    }
                                                } catch (InvalidAppointmentIdException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            }

                                            appointments.setAppointmentId(appointmentsId);
                                            appointments.setPatientId(appointPatientId);
                                            appointments.setDoctorId(appointDoctorId);
                                            appointments.setAppointmentDateTime(appointmentDateTime);
                                            int appointmentResult = appointmentDao.insert(appointments);
                                            System.out.println("Inserted Appointments Successfully! " + appointmentResult);
                                            break;

                                        case 2:
                                            String deleteAppointmentId;

                                            while(true) {
                                                try {
                                                    System.out.println();
                                                    System.out.print("Enter appointment id: ");
                                                    deleteAppointmentId = input.nextLine();
                                                    if (!deleteAppointmentId.matches("A\\d{3}")) {
                                                        throw new InvalidAppointmentIdException("Invalid Appointment Id! Appointment id must start with 'A' as followed by 3 digits unique numbers...");
                                                    } else {
                                                        break;
                                                    }
                                                } catch (InvalidAppointmentIdException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            }

                                            appointments.setAppointmentId(deleteAppointmentId);
                                            int deleteResult = appointmentDao.delete(deleteAppointmentId);
                                            System.out.println("Appointment Deleted Successfully! "+ deleteResult);
                                            break;

                                        case 3:
                                            String viewAppointmentId;
                                            String viewPatientId;

                                            while (true) {
                                                try {
                                                    System.out.print("Enter appointment id: ");
                                                    viewAppointmentId = input.nextLine();
                                                    if (!viewAppointmentId.matches("A\\d{3}")) {
                                                        throw new InvalidAppointmentIdException("Invalid Appointment Id! Appointment Id should be start with 'A' as followed by 3 digits unique numbers...");
                                                    } else {
                                                       while (true) {
                                                           try {
                                                               System.out.print("Enter patient name: ");
                                                               viewPatientId = input.nextLine();
                                                               if (!viewPatientId.matches("P\\d{3}")) {
                                                                   throw new InvalidAppointmentPatientIdException("Invalid Patient Id! Patient Id should be start with 'A' as followed by 3 digits unique numbers...");
                                                               } else {
                                                                   break;
                                                               }
                                                           } catch (InvalidAppointmentPatientIdException e) {
                                                               System.out.println(e.getMessage());
                                                           }
                                                       }
                                                       break;
                                                    }
                                                } catch (InvalidAppointmentIdException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            }

                                            Appointments viewAppointmentsResult = appointmentDao.viewAppointment(viewAppointmentId, viewPatientId);
                                            System.out.println("Retrieve Appointments Data Successfully!");
                                            System.out.println(viewAppointmentsResult);
                                            break;

                                        default:
                                            System.out.println("Invalid Choice! Try Again...");
                                    }
                                } else {
                                    System.out.println("Invalid Appointment Choice! Try Again...");
                                    input.next();
                                }
                            }

                        default:
                            System.out.println("Invalid Choice! Try Again...");
                    }
                }
            } else {
                System.out.println("Invalid Main Choice! Try Again...");
                input.next();
            }
        }
    }
}



//SELECT p.patient_id, p.patient_name,d.doctor_id, d.doctor_name, a.appointment_date_time FROM appointment_tb a
//JOIN patient_tb p ON a.patient_id = p.patient_id JOIN doctor_tb d ON a.doctor_id = d.doctor_id WHERE p.patient_id="P102";