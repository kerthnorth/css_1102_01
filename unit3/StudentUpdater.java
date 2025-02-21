import java.util.Scanner;

public class StudentUpdater {
    private administration_management adminManager;
    private static final Scanner sc = new Scanner(System.in);

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";

    public StudentUpdater(administration_management adminManager) {
        this.adminManager = adminManager;
    }

    public void updateStudentInfo() {
        if (adminManager.Student_records.isEmpty()) {
            System.out.println(RED + "No student records available to update." + RESET);
            return;
        }

        System.out.println(YELLOW + "List of students:" + RESET);
        int index = 1;
        for (String studentInfo : adminManager.Student_records.keySet()) {
            System.out.println(index + ". " + studentInfo);
            index++;
        }

        System.out.print(GREEN + "Enter the student name and surname to update: " + RESET);
        String name = sc.nextLine().trim();

        boolean found = false;
        String targetKey = null;

        index = 1;
        for (String studentInfo : adminManager.Student_records.keySet()) {
            if (studentInfo.contains("Student name: " + name)) {
                System.out.println(BLUE + index + ". Current Student Information: " + studentInfo + RESET);
                targetKey = studentInfo;
                found = true;
                break;
            }
            index++;
        }

        if (!found) {
            System.out.println(RED + "Student '" + name + "' not found in the system." + RESET);
            return;
        }

        System.out.print(YELLOW + "Enter new age (numeric): " + RESET);
        while (!sc.hasNextInt()) {
            System.out.println(RED + "Invalid input. Please enter a valid number for age." + RESET);
            sc.next();
        }
        String newAge = String.valueOf(sc.nextInt());
        sc.nextLine();

        System.out.print(YELLOW + "Enter new grade (A-F): " + RESET);
        String newGrade = sc.nextLine().trim().toUpperCase();
        while (!newGrade.matches("[A-F]")) {
            System.out.println(RED + "Invalid input. Please enter a grade between A-F." + RESET);
            newGrade = sc.nextLine().trim().toUpperCase();
        }

        String[] details = targetKey.split(", ");
        String studentNumber = details[1];

        String updatedStudentInfo = "Student name: " + name + ", " + studentNumber + ", Student Age: " + newAge + ", Student Grade: " + newGrade;

        adminManager.Student_records.remove(targetKey);
        adminManager.Student_records.put(updatedStudentInfo, newGrade);

        System.out.println(GREEN + "Student information updated successfully!" + RESET);
    }
}
