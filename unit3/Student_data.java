import java.util.Scanner;

public class Student_data {
    public administration_management studentRecord;
    static Scanner sc = new Scanner(System.in);

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";

    public Student_data(administration_management studentRecord) {
        this.studentRecord = studentRecord;
    }

    public void displayStudentData() {
        System.out.println(GREEN + "Welcome! Follow the instructions to access student data." + RESET);

        if (studentRecord.Student_records.isEmpty()) {
            System.out.println(RED + "No student data available." + RESET);
            return;
        }

        System.out.println(YELLOW + "List of students:" + RESET);

        int index = 1;
        for (String studentInfo : studentRecord.Student_records.keySet()) {
            System.out.println(index + ". " + studentInfo);
            index++;
        }

        while (true) {
            System.out.print(GREEN + "\nEnter student name and surname (or type 'exit' to quit): " + RESET);
            String name = sc.nextLine().trim();

            if (name.equalsIgnoreCase("exit")) {
                System.out.println(GREEN + "Goodbye!" + RESET);
                break;
            }

            boolean found = false;
            index = 1;
            for (String studentInfo : studentRecord.Student_records.keySet()) {
                if (studentInfo.contains("Student name: " + name)) {
                    System.out.println(BLUE + index + ". " + studentInfo + RESET);
                    found = true;
                    break;
                }
                index++;
            }

            if (!found) {
                System.out.println(RED + "Student '" + name + "' not found in the system." + RESET);
            }
        }
    }
}
