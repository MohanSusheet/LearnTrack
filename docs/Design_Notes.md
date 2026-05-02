# Design Notes – LearnTrack Project

## 1. Why I used ArrayList instead of Array

In this project, I used `ArrayList` instead of arrays to store Students, Courses, and Enrollments.

The main reason is that `ArrayList` is dynamic in size, whereas arrays have a fixed size. In a system like LearnTrack, the number of students, courses, and enrollments is not known in advance and can grow over time. Using arrays would require manually resizing them, which makes the code more complex and less efficient.

`ArrayList` provides built-in methods like `add()`, `remove()`, and `size()` which make data handling easier and more readable. It also allows storing objects directly and iterating easily using loops.

Therefore, `ArrayList` was chosen because it simplifies implementation and is more suitable for dynamic data storage.

---

## 2. Where I used static members and why

I used static members mainly in the `IdGenerator` utility class.

Example:
- `studentIdCounter`
- `courseIdCounter`
- `enrollmentIdCounter`
- Methods like `getNextStudentId()`, `getNextCourseId()`, etc.

These are declared as `static` because:
- ID generation should be shared across the entire application
- There should be only one counter per entity type
- Static members allow access without creating an object of the class

This ensures that IDs are unique and sequential throughout the program.

I also used a static `Scanner` object in the `Main` class to handle user input. This avoids creating multiple Scanner instances and keeps input handling centralized.

---

## 3. Where I used inheritance and what I gained from it

I implemented inheritance by creating a base class `Person` and extending it into `Student`.

### Structure:
- `Person` (base class)
    - Fields: id, firstName, lastName, email
- `Student` extends `Person`
    - Additional field: batch, active status

### Benefits gained:

1. **Code Reusability**  
   Common fields like id, name, and email are defined once in the `Person` class and reused in `Student`. This avoids duplication.

2. **Cleaner Design**  
   The relationship between entities becomes clearer. A student is a type of person, which matches real-world modeling.

3. **Extensibility**  
   It becomes easy to add more types like `Trainer` in the future by extending the `Person` class.

4. **Polymorphism (Basic Level)**  
   Methods like `displayInfo()` is defined in `Person` and overridden in `Student`, allowing different behavior and helped in achieving runtime polymorphism.
   Also, use of classes `Student`, `Course`, `Enrollment` have a default as well as parameterized constructor displaying concept of constructor overloading and depicting compile time polymorphism. 

Overall, inheritance helped make the code more organized, reusable, and closer to real-world object-oriented design.