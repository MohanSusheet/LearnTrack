package com.learntrack.service;

import com.learntrack.entity.Enrollment;
import java.util.List;
import java.util.ArrayList;

public class EnrollmentService
{
    private List<Enrollment> Enrollments = new ArrayList<>();

    public void enrollStudent(Enrollment enrollment) {
        Enrollments.add(enrollment);
    }

    // Get all enrollments
    public List<Enrollment> getAllEnrollments() {
        return Enrollments;
    }

    // Get enrollments by student ID
    public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
        List<Enrollment> result = new ArrayList<>();

        for (Enrollment e : Enrollments) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }

        return result;
    }

    // Find enrollment by ID
    public Enrollment getEnrollmentById(int id){
        for (Enrollment e : Enrollments)
        {
            if (e.getEnrollmentId() == id)
            {
                return e;
            }
        }
        return null;
    }

    // Update status
    public boolean updateEnrollmentStatus(int enrollmentId, String status){
        Enrollment e = getEnrollmentById(enrollmentId);
        if(e == null)
        {
            return false;
        }
        e.setStatus(status);
        return true;
    }
}
