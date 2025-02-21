import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class administration_management {
    public HashMap<String, String> Student_records = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    public static int totalStudents = 0;

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";

    public void add_student() {
        System.out.println(GREEN + "Enter the required student details:" + RESET);

        System.out.print("Student Name and Surname: ");
        String name = sc.nextLine().trim();

        Random random = new Random();
        StringBuilder ID = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int digit = random.nextInt(5);
            ID.append(digit);
        }

        System.out.println(GREEN + "Assigned Student ID: " + ID + RESET);

        System.out.print("Student Age (numeric): ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Enter a numeric age.");
            sc.next();
        }
        String age = String.valueOf(sc.nextInt());
        sc.nextLine();

        System.out.print("Student Grade (A-F): ");
        String grade = sc.nextLine().trim().toUpperCase();
        while (!grade.matches("[A-F]")) {
            System.out.println("Invalid grade. Enter a grade between A-F.");
            grade = sc.nextLine().trim().toUpperCase();
        }

        String studentInfo = "Student name: " + name + ", Student number: " + ID + ", Student Age: " + age + ", Student Grade: " + grade;
        Student_records.put(studentInfo, grade);
        totalStudents++;

        System.out.println(GREEN + "Student added successfully!" + RESET);
    }

    public HashMap<String, String> getStudentRecords() {
        return Student_records;
    }
}
