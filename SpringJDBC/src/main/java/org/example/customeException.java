package org.example;

class IncludingFiveDigitsException extends Exception {
    public IncludingFiveDigitsException(String message) {
        super(message);
    }
}

class InvalidFacultyNameException extends Exception {
    public InvalidFacultyNameException(String message) {
        super(message);
    }
}

class InvalidEmailIdException extends Exception {
    public InvalidEmailIdException(String message) {
        super(message);
    }
}

class InvalidRoomNumberWithThreeDigits extends Exception {
    InvalidRoomNumberWithThreeDigits(String message) {
        super(message);
    }
}
