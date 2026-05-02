package com.learntrack.util;

public class GenerateId {
    public static int studentIdCounter = 1;
    public static int courseIdCounter = 501;
    public static int enrollmentIdCounter = 1001;

    public static int generateStudentId()
    {
        return studentIdCounter++;
    }

    public static int generateCourseId()
    {
        return courseIdCounter++;
    }

    public static int IdGenerator()
    {
        return enrollmentIdCounter++;
    }
}