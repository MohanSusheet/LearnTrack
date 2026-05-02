package com.learntrack.service;

import com.learntrack.entity.Course;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseService
{
    private List<Course> Courses = new ArrayList<>();

    public void addNewCourse(Course course)
    {
        Courses.add(course);
    }

    public List<Course> viewAllCourses()
    {
        return Courses;
    }

    public Course searchCourseById(int id)
    {
        for(Course c: Courses)
        {
            if(c.getCourseId() == id)
            {
                return c;
            }
        }

        return null;
    }

    public boolean activateOrDeactivateCourse(int cId, int statusUpdate)
    {
        Course courseSearched = searchCourseById(cId);

        if(courseSearched == null)
        {
            return false;
        }
        boolean setActive = statusUpdate == 1 ? true : false;
        courseSearched.setIsActive(setActive);

        return true;
    }
}
