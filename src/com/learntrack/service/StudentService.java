package com.learntrack.service;
import java.util.ArrayList;
import java.util.List;
import com.learntrack.entity.Student;


public class StudentService {

    private static List<Student> Students = new ArrayList<>();

    public void addNewStudent(Student s)
    {
        Students.add(s);
    }

    public List<Student> viewAllStudents()
    {
        return Students;
    }

    public Student searchStudentById(int searchId)
    {
        for(Student s : Students)
        {
            if(s.getId() == searchId)
            {
                return s;
            }
        }
        return null;
    }

    public boolean updateStudent(int id)
    {
        Student s = searchStudentById(id);
        if(s == null)
        {
            return false;
        }
        else
        {
            s.setActivityStatus();
        }
        return true;
    }
}
