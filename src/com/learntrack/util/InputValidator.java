package com.learntrack.util;

import com.learntrack.exception.InvalidInputException;

public class InputValidator
{
    public static void validateName(String name) throws InvalidInputException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Name cannot be empty.");
        }
    }
    public static void validateEmail(String email) throws InvalidInputException {
        if (email == null || !email.contains("@")) {
            throw new InvalidInputException("Invalid email format.");
        }
    }

    public static void validateBatch(int batch) throws InvalidInputException {
        if (batch <= 0) {
            throw new InvalidInputException("Batch must be a positive number.");
        }
    }

    public static void validateId(int id) throws InvalidInputException {
        if (id <= 0) {
            throw new InvalidInputException("ID must be greater than 0.");
        }
    }

    public static void validateString(String value, String fieldName) throws InvalidInputException {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidInputException(fieldName + " cannot be empty.");
        }
    }

    public static void validateCourseDuration(int duration) throws InvalidInputException
    {
        if(duration <= 0)
        {
            throw new InvalidInputException("Course duration must be at least 1 week.");
        }
    }
}
