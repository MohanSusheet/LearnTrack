package com.learntrack.entity;

import com.learntrack.util.GenerateId;

public class Student extends Person
{
    private int batch;
    private boolean isActive;

    public Student()
    {
        //
    }

    public Student(String firstName, String lastName, String email, int batch)
    {
        super(GenerateId.generateStudentId(), firstName, lastName, email);
        this.batch = batch;
        this.isActive = true;
    }

    public void setActivityStatus()
    {
        this.isActive = false;
    }


    @Override
    public void displayInfo()
    {
        System.out.println("Student[\n Id: " + this.getId() + ", First Name: " + this.getFirstName() +
                ", Last Name: " + this.getLastName() + ", Email: " + this.getEmail() + "]\n");
    }
}
