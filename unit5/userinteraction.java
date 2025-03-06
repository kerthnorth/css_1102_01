package unit5;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class userinteraction {
    static Scanner sc = new Scanner(System.in);
    public static int totalStudents = 0;
    public HashMap<String, studentclass> Student_records = new HashMap<>();
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";

    public void add_student() {
        System.out.println(GREEN + "Please enter your student details:" + RESET);
        System.out.print("Please enter your name and surname: ");
        String name = sc.nextLine().trim();

        Random random = new Random();
        StringBuilder ID = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int digit = random.nextInt(10);
            ID.append(digit);
        }
        System.out.println(GREEN + "Hi, " + name + ", you have been assigned Student ID: " + ID + RESET);

        // Create a student instance
        studentclass student = new studentclass();
        student.setstudentname(name);
        student.setID(ID.toString());

        System.out.println("Enter your courses (type 'exit' or leave blank to finish): ");
        while (true) {
            System.out.print("Course name: ");
            String courseName = sc.nextLine().trim();
            if (courseName.isEmpty() || courseName.equalsIgnoreCase("exit")) {
                break;
            }
            Course course = new Course(courseName);
            student.enrollInCourse(course);
        }

        // Store student in HashMap
        Student_records.put(ID.toString(), student);
        totalStudents++;

        System.out.println(GREEN + "Student added successfully!" + RESET);
    }

    public void assign_grade(String studentID, String courseName, String grade) {
        studentclass student = Student_records.get(studentID);
        if (student != null) {
            Course course = new Course(courseName); // Temporary course object to find a match
            student.assignGrade(course, grade);
            System.out.println(GREEN + "Grade updated successfully!" + RESET);
        } else {
            System.out.println(RED + "Student not found!" + RESET);
        }
    }

    public HashMap<String, studentclass> getStudentRecords() {
        return Student_records;
    }
}
