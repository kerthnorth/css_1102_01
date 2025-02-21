import java.util.Scanner;

public class administrator_interface {
    private administration_management adminManager = new administration_management();
    private Student_data studentData = new Student_data(adminManager);
    private StudentUpdater studentUpdater = new StudentUpdater(adminManager);

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";

    public static void displayMenuScreen() {
        System.out.println("\n=== Student Records Menu ===");
        System.out.println("1. View student details");
        System.out.println("2. Update student information");
        System.out.println("3. Add new student");
        System.out.println("4. Exit");
    }

    public void userChoice() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenuScreen();
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println(RED + "Invalid input! Please enter a valid option." + RESET);
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentData.displayStudentData();
                    break;
                case 2:
                    studentUpdater.updateStudentInfo();
                    break;
                case 3:
                    adminManager.add_student();
                    break;
                case 4:
                    System.out.println("Thank you for using the system. Goodbye!");
                    return;
                default:
                    System.out.println(RED + "Invalid option. Please try again." + RESET);
            }
        }
    }
}
