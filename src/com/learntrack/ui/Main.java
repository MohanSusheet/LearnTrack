package com.learntrack.ui;

import java.util.*;
import com.learntrack.entity.*;
import com.learntrack.service.*;
import com.learntrack.util.InputValidator;

public class Main
{
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();


        System.out.println("==================== Welcome to LearnTrack ================== \n Please choose an option from the menu below :");

        int choice;

        do
        {
            System.out.println("Press '1' for Student Management");
            System.out.println("Press '2' for Course Management");
            System.out.println("Press '3' for Enrollment Management");
            System.out.println("Press '4' to Exit");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1 : displayStudentManagementOptions(studentService);
                    break;
                case 2 :
                    displayCourseManagementOptions(courseService);
                    break;
                case 3 : displayEnrollmentManagementOptions(studentService, courseService, enrollmentService);
                    break;
            }

            System.out.println();
            System.out.println();
        }while(choice != 4);

    }


    public static void displayStudentManagementOptions(StudentService studentService)
    {
        System.out.println("--------------Student Management System-----------\n Please select one from the below options: ");
        int option;

        do
        {
            System.out.println("Press '1' to add a new Student.");
            System.out.println("Press '2' view all Students.");
            System.out.println("Press '3' Search student by ID.");
            System.out.println("Press '4' to Deactivate a Student.");
            System.out.println("Press '5' to Exit.");

            option = sc.nextInt();
            sc.nextLine();

            try
            {
                switch(option)
                {
                    case 1 :
                        System.out.println("Enter First Name:");
                        String firstName = sc.nextLine();
                        InputValidator.validateName(firstName);

                        System.out.println("Enter Last Name:");
                        String lastName = sc.nextLine();
                        InputValidator.validateName(lastName);

                        System.out.println("Enter Email:");
                        String email = sc.nextLine();
                        InputValidator.validateEmail(email);

                        System.out.println("Enter Batch:");
                        int batch = sc.nextInt();
                        sc.nextLine();
                        InputValidator.validateBatch(batch);

                        Student s = new Student(firstName, lastName, email, batch);
                        studentService.addNewStudent(s);
                        System.out.println("New Student added to system successfully.");
                        break;

                    case 2 :
                        List<Student> studentsList = studentService.viewAllStudents();
                        if(studentsList.isEmpty())
                        {
                            System.out.println("Student list is empty. No student present in the system.");
                        }
                        else
                        {
                            for(Student student: studentsList)
                            {
                                student.displayInfo();
                            }
                        }
                        break;
                    case 3 :
                        System.out.println("Enter the Student Id to search for the student.");
                        int searchId = sc.nextInt(); sc.nextLine();
                        Student stu = studentService.searchStudentById(searchId);
                        if(stu == null)
                        {
                            System.out.println("Student with id: " + searchId + " not found in the system.");
                        }
                        else
                        {
                            stu.displayInfo();
                        }
                        break;
                    case 4 :
                        System.out.println("Enter the Student Id for the student to be updated.");
                        int sId = sc.nextInt(); sc.nextLine();
                        boolean status = studentService.updateStudent(sId);
                        if(status)
                        {
                            System.out.println("Student with Id: " + sId + "updated successfully.");
                        }
                        else
                        {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 5 : System.out.println("Exiting Student Management System...");
                        break;
                    default : System.out.println("Enter a valid choice of action.");
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

        }while(option != 5);
    }

    public static void displayCourseManagementOptions(CourseService courseService)
    {
        System.out.println("--------------Course Management System-----------\n Please select one from the below options: ");
        int option;

        try
        {
            do
            {
                System.out.println("Press '1' to add a new course.");
                System.out.println("Press '2' view all courses.");
                System.out.println("Press '3' to Activate/Deactivate a course.");
                System.out.println("Press '4' to Exit.");

                option = sc.nextInt();
                sc.nextLine();

                switch(option)
                {
                    case 1 :
                        String courseName, courseDescription;
                        int durationInWeeks;
                        System.out.println("Enter the Course Name to be added : ");
                        courseName = sc.nextLine();
                        InputValidator.validateString(courseName, "Course Name");

                        System.out.println("Enter course description of student : ");
                        courseDescription = sc.nextLine();
                        InputValidator.validateString(courseDescription, "Course Description");

                        System.out.println("Enter duration of the course (in weeks) : ");
                        durationInWeeks = sc.nextInt(); sc.nextLine();
                        InputValidator.validateCourseDuration(durationInWeeks);

                        Course c = new Course(courseName, courseDescription, durationInWeeks);
                        courseService.addNewCourse(c);
                        System.out.println("New Course added to system successfully.");
                        break;
                    case 2 :
                        List<Course> coursesList = courseService.viewAllCourses();
                        if(coursesList.isEmpty())
                        {
                            System.out.println("No courses found in the system.");
                        }
                        else
                        {
                            for(Course course: coursesList)
                            {
                                System.out.println(course);
                            }
                        }
                        break;
                    case 3 :
                        System.out.println("Enter the Course Id to be updated.");
                        int cId = sc.nextInt(); sc.nextLine();
                        System.out.println("Enter the action to be taken.\n Press '1' to activate the course.\n Press '2' to deactivate.");
                        int statusUpdate = sc.nextInt(); sc.nextLine();
                        boolean success = courseService.activateOrDeactivateCourse(cId, statusUpdate);
                        if(success)
                        {
                            System.out.println("Course Status has been updated successfully for course Id : " + cId + ".");
                        }
                        else
                        {
                            System.out.println("Course with Id : " + cId + " not found in the system.");
                        }
                        break;
                    case 4 : System.out.println("Exiting Course Management System...");
                        break;
                    default : System.out.println("Enter a valid choice of action.");
                }

            }while(option != 4);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public static void displayEnrollmentManagementOptions(StudentService studentService, CourseService courseService, EnrollmentService enrollmentService)
    {
        System.out.println("--------------Enrollment Management System-----------\n Please select one from the below options: ");
        int option;

        try
        {
            do
            {
                System.out.println("Press '1' to enroll a student in a course.");
                System.out.println("Press '2' to view enrollments for a student.");
                System.out.println("Press '3' to mark enrollment as completed/cancelled");
                System.out.println("Press '4' to Exit.");

                option = sc.nextInt();
                sc.nextLine();

                switch(option)
                {
                    case 1 :
                        System.out.println("Enter Student ID:");
                        int studentId = sc.nextInt();

                        System.out.println("Enter Course ID:");
                        int courseId = sc.nextInt();
                        sc.nextLine();

                        if (studentService.searchStudentById(studentId) == null)
                        {
                            System.out.println("Invalid Student ID");
                        }
                        else if (courseService.searchCourseById(courseId) == null)
                        {
                            System.out.println("Invalid Course ID");
                        }
                        else
                        {
                            Enrollment e = new Enrollment(studentId, courseId);
                            enrollmentService.enrollStudent(e);
                            System.out.println("Enrollment successful.");
                        }
                        break;
                    case 2 :
                        System.out.println("Enter Student ID:");
                        int sid = sc.nextInt();
                        sc.nextLine();

                        List<Enrollment> list = enrollmentService.getEnrollmentsByStudentId(sid);

                        if (list.isEmpty()) {
                            System.out.println("No enrollments found for given student id.");
                        }
                        else
                        {
                            for (Enrollment e : list) {
                                e.displayInfo();
                            }
                        }
                        break;
                    case 3 :
                        System.out.println("Enter Enrollment Id:");
                        int eid = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter Status (ACTIVE / COMPLETED / CANCELLED):");
                        String status = sc.nextLine();

                        if (enrollmentService.updateEnrollmentStatus(eid, status))
                        {
                            System.out.println("Status updated.");
                        }
                        else
                        {
                            System.out.println("Enrollment not found.");
                        }
                        break;
                    case 4 : System.out.println("Exiting Enrollment Management System...");
                        break;
                    default : System.out.println("Enter a valid choice of action.");
                }

            }while(option != 4);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
