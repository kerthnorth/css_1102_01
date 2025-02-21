// File: clienthandler.java
import java.util.Scanner;

public class clienthandler {
    private add_books add_book = new add_books();
    private borrow_books borrow_book = new borrow_books(add_book);
    private return_books return_book = new return_books(add_book);

    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public static void displayoptions() {
        System.out.println(CYAN + "Welcome To the Unique Library! \n" + RESET);
        System.out.println(YELLOW + "Please select from the following options: \n" + RESET);
        System.out.println(BLUE + "1. Add Books" + RESET);
        System.out.println(BLUE + "2. Borrow Books" + RESET);
        System.out.println(BLUE + "3. Return Books" + RESET);
        System.out.println(BLUE + "4. Exit" + RESET);
    }

    public void user_choice() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayoptions();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    add_book.addBook();
                    break;
                case 2:
                    borrow_book.borrow();
                    break;
                case 3:
                    return_book.returnBook();
                    break;
                case 4:
                    System.out.println(GREEN + "Thank you for using Unique Library. Goodbye!");
                    return;
                default:
                    System.out.println(RED + "Invalid Option. Please try again.");
            }
        }
    }
}
