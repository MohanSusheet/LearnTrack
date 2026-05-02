# LearnTrack – Student & Course Management System

## Project Description

LearnTrack is a **console-based Java application** designed to manage:

- Students
- Courses
- Enrollments

The application allows users (admins) to:

- Add and manage students
- Create and manage courses
- Enroll students into courses
- Track enrollment status (ACTIVE / COMPLETED / CANCELLED)

This project is built using **Core Java concepts** such as:

- Object-Oriented Programming (Encapsulation, Inheritance, Polymorphism)
- Collections (`ArrayList`)
- Exception Handling
- Modular design using packages

---

## Project Structure

```text
com.learntrack
│
├── entity      → Data models (Student, Course, Enrollment, Person)
├── service     → Business logic
├── ui          → Console-based user interface (Main class)
├── util        → Utilities (ID generation, input validation)
├── exception   → Custom exceptions
```

---

## Features

### Student Management
- Add new student
- View all students
- Search student by ID
- Deactivate student

### Course Management
- Add new course
- View all courses
- Activate / Deactivate course

### Enrollment Management
- Enroll student in course
- View enrollments by student
- Update enrollment status

---

## Technologies Used

- Java (Core Java) [Version Java 8]
- IntelliJ IDEA (recommended IDE)
- JDK [openjdk 26]

---

## ▶ How to Compile and Run

### Using IntelliJ IDEA (Recommended)

1. Open IntelliJ IDEA
2. Click on **Open Project** and select your project folder
3. Navigate to: `src/com/learntrack/ui/Main.java`
4. Right-click on `Main.java`
5. Click **Run 'Main.main()'**

The console menu will appear, and you can interact with the system.

---

## How to Use the Application
Once the application starts, you will see a menu:

1. Student Management
2. Course Management
3. Enrollment Management
4. Exit

### Example Flow:
1. Add a student
2. Add a course
3. Enroll the student into the course
4. View enrollment details

## NOTES

This project is designed for learning Core Java fundamentals and follows clean coding practices like:

1. Separation of concerns (UI vs Service vs Entity)
2. Modular package structure
3. Readable and maintainable code