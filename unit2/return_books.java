import java.util.Scanner;

// Prompt the user to enter the book title and the number of books to return.
// Check if the books being returned belong to the library system.
// If they do, update the quantity and display a success message.
// If not, display an error message.
public class return_books {
    static Scanner sc = new Scanner(System.in);
    private add_books library;
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public return_books(add_books library) {
        this.library = library;
    }

    public void returnBook() {
        System.out.println(GREEN + "This screen will guide you into returning a book!");

        if (library.dictionary == null || library.dictionary.isEmpty()) {
            System.out.println(YELLOW + "No books in the library");
            return;
        }

        System.out.println(GREEN + "Books in the library:");
        for (String title : library.dictionary.keySet()) {
            System.out.println(BLUE + "Title: " + title + ", " + library.dictionary.get(title));
        }

        while (true) {
            System.out.print(GREEN + "Enter the book title to return (or type 'exit' to quit): ");
            String titleToReturn = sc.nextLine();

            if (titleToReturn.equalsIgnoreCase("exit")) {
                break;
            }

            if (!library.dictionary.containsKey(titleToReturn)) {
                System.out.println(RED + "Book not found in the library system. Please try again.");
                continue;
            }

            System.out.print(GREEN + "Enter the quantity of the book to return: ");
            try {
                int quantityToReturn = Integer.parseInt(sc.nextLine());

                if (quantityToReturn <= 0) {
                    System.out.println(RED + "Invalid quantity. Please enter a positive number.");
                    continue;
                }

                String[] bookDetails = library.dictionary.get(titleToReturn).split(", ");
                int currentQuantity = Integer.parseInt(bookDetails[1].split(": ")[1]);

                int updatedQuantity = currentQuantity + quantityToReturn;
                library.dictionary.put(titleToReturn, bookDetails[0] + ", Quantity: " + updatedQuantity);

                System.out.println(GREEN + "Book returned successfully!");
                System.out.println("Updated info: Title: " + titleToReturn + ", " + library.dictionary.get(titleToReturn));
            } catch (NumberFormatException e) {
                System.out.println(RED + "Invalid input for quantity. Please enter a valid number.");
            }
        }
    }
}
