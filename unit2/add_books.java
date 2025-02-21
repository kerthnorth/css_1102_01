

import java.util.HashMap;
import java.util.Scanner;
// Prompt the user to enter the book title, author, and quantity.
// If the book already exists in the library, update the quantity.
// If the book is new, add it to the library.
public class add_books {
    public HashMap<String, String> dictionary = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

/**
 * Guides the user through adding a book to the library.
 * Prompts the user to enter the book title, author, and quantity.
 * If the user inputs 'exit', the process terminates.
 * Stores the book information in the dictionary with the title as the key
 * and the author and quantity as the associated value.
 */

    public void addBook() {
        System.out.println("This screen will guide you through adding a book!");

        while (true) {
            System.out.print(GREEN + "Enter the book title (or type 'exit' to quit): ");
            String title = sc.nextLine();

            if (title.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print(GREEN + "Enter the book's author: ");
            String author = sc.nextLine();

            System.out.print(GREEN + "Enter the quantity of the book: ");
            String quantity = sc.nextLine();

            dictionary.put(title, "Author: " + author + ", Quantity: " + quantity);
            System.out.println("Book added successfully!\n");
        }
    }

    public HashMap<String, String> getDictionary() {
        return dictionary;
    }
}
