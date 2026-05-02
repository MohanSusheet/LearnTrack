package com.learntrack.entity;

import com.learntrack.util.GenerateId;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Enrollment {
    private int id;
    private int courseId;
    private int studentId;
    private String enrollmentDate;
    private String status;

    //Default Constructor
    Enrollment()
    {

    }

    public Enrollment(int studentId, int courseId) {
        this.id = GenerateId.IdGenerator();
        this.studentId = studentId;
        this.courseId = courseId;
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.enrollmentDate= now.format(formatter);
        this.status = "ACTIVE";
    }
    public int getEnrollmentId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayInfo() {
        System.out.println("Enrollment ID: " + id +
                ", Student ID: " + studentId +
                ", Course ID: " + courseId +
                ", Date: " + enrollmentDate +
                ", Status: " + status);
    }
}
