import java.util.Scanner;

// Prompt the user to enter the book title and the number of books to borrow.
// Check if the requested number of books is available in the library.
// If the books are available, update the quantity and display a success message.
// If not, display an error message.

public class borrow_books {
    static Scanner sc = new Scanner(System.in);
    private add_books library;
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";


    public borrow_books(add_books library) {
        this.library = library;
    }

    public void borrow() {
        System.out.println(GREEN + "This screen will walk you into borrowing a book!");

        System.out.println(YELLOW +"\nBooks in the library:");
        if (library.dictionary.isEmpty()) {
            System.out.println(RED + "No books are currently available in the library.");
            return;
        }

        for (String title : library.dictionary.keySet()) {
            System.out.println("Title: " + title + ", " + library.dictionary.get(title));
        }

        while (true) {
            System.out.print(GREEN + "\nEnter the book title (or type 'exit' to quit): ");
            String title = sc.nextLine();

            if (title.equalsIgnoreCase("exit")) {
                System.out.println(GREEN + "Thank you for using Unique Library. Goodbye!");
                break;
            }
            if (!library.dictionary.containsKey(title)) {
                System.out.println(RED + "Sorry, the book titled '" + title + "' is not available in the library.");
                continue;
            }

            System.out.print(GREEN + "Enter the quantity to borrow: ");
            String quantityToBorrow = sc.nextLine();

            String[] bookDetails = library.dictionary.get(title).split(", ");
            int availableQuantity = Integer.parseInt(bookDetails[1].split(": ")[1]);

            if (Integer.parseInt(quantityToBorrow) <= availableQuantity) {
                int newQuantity = availableQuantity - Integer.parseInt(quantityToBorrow);
                library.dictionary.put(title, bookDetails[0] + ", Quantity: " + newQuantity);

            System.out.println(GREEN + "Book borrowed successfully! Remaining quantity: " + newQuantity);
            } else {
                System.out.println(RED + "Sorry, not enough copies of '" + title + "' are available. Only " + availableQuantity + " copies remain.");
            }
        }
    }
}
