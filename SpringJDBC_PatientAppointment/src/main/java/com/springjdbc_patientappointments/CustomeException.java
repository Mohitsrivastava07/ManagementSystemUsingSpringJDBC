package com.springjdbc_patientappointments;

class InvalidPatientIdException extends Exception {
    InvalidPatientIdException(String message) {
        super(message);
    }
}

class InvalidPatientNameException extends Exception {
    InvalidPatientNameException(String message) {
        super(message);
    }
}

class InvalidPatientAddressException extends Exception {
    InvalidPatientAddressException(String message) {
        super(message);
    }
}

class InvalidDoctorIdException extends Exception {
    InvalidDoctorIdException(String message) {
        super(message);
    }
}

class InvalidDoctorNameException extends Exception {
    InvalidDoctorNameException(String message) {
        super(message);
    }
}

class InvalidDoctorGenderException extends Exception {
    InvalidDoctorGenderException(String message) {
        super(message);
    }
}

class InvalidAppointmentIdException extends Exception {
    InvalidAppointmentIdException(String message) {
        super(message);
    }
}

class InvalidAppointmentPatientIdException extends Exception {
    InvalidAppointmentPatientIdException(String message) {
        super(message);
    }
}

class InvalidAppointmentDoctorIdException extends Exception {
    InvalidAppointmentDoctorIdException(String message) {
        super(message);
    }
}

class InvalidAppointmentDateTimeException extends Exception {
    InvalidAppointmentDateTimeException(String message) {
        super(message);
    }
}