package com.learntrack.entity;

public class Person
{
    private int Id;
    private String firstName;
    private String lastName;
    private String email;

    public Person()  //default constructor
    {

    }

    public Person(int Id, String firstName, String lastName, String email) //Parameterized Constructor
    {
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //getters
    public int getId()
    {
        return this.Id;
    }
    public String getFirstName()
    {
        return this.firstName;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public String getEmail()
    {
        return this.email;
    }

    //DisplayInfo
    public void displayInfo()
    {
        System.out.println("Person[\n Id: " + this.getId() + ", First Name: " + this.getFirstName() +
                ", Last Name: " + this.getLastName() + ", Email: " + this.getEmail() + "]\n");
    }
}
