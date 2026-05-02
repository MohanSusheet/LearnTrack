package com.learntrack.entity;

import com.learntrack.util.GenerateId;

public class Course
{
    private int courseId;
    private String courseName;
    private String description;
    private int durationInWeeks;
    public boolean isActive;

    public Course()
    {
    }

    public Course(String courseName, String description, int durationInWeeks)
    {
        this.courseId = GenerateId.generateCourseId();
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.isActive = true;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", description='" + description + '\'' +
                ", durationInWeeks=" + durationInWeeks +
                ", isActive=" + isActive +
                '}';
    }
}
