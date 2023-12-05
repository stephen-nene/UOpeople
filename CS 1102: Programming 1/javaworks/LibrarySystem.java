import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibrarySystem {
    private static final Map<String, Book> library = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Library System! 📚");

        // Add some dummy books to the library
        library.put("Harry Potter", new Book("Harry Potter", "J.K. Rowling", 5));
        library.put("The Hobbit", new Book("The Hobbit", "J.R.R. Tolkien", 3));
        library.put("To Kill a Mockingbird", new Book("To Kill a Mockingbird", "Harper Lee", 2));
        library.put("1984", new Book("1984", "George Orwell", 4));
        library.put("The Great Gatsby", new Book("The Great Gatsby", "F. Scott Fitzgerald", 1));

        while (true) {
            displayMenu();

            int choice = getChoice();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    System.out.println("Thank you for using the Library System! 📖 Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again. ❌");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu: ");
        System.out.println("1. Add Books 📕");
        System.out.println("2. Borrow Books 📚");
        System.out.println("3. Return Books ↩️");
        System.out.println("4. Exit 🚪");
    }

    private static int getChoice() {
        System.out.print("\nEnter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number. ❌");
            System.out.print("Enter your choice: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.next();

        System.out.print("Enter author: ");
        String author = scanner.next();

        System.out.print("Enter quantity: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number for quantity. ❌");
            System.out.print("Enter quantity: ");
            scanner.next();
        }
        int quantity = scanner.nextInt();

        Book book = new Book(title, author, quantity);

        if (library.containsKey(title)) {
            library.get(title).addQuantity(quantity);
            System.out.println("Book updated successfully! ✅");
        } else {
            library.put(title, book);
            System.out.println("Book added successfully! ✅");
        }
    }

    private static void borrowBook() {
        displayBooks();
        System.out.print("\nEnter the title of the book you want to borrow: \n");
        String title = scanner.next();

        if (library.containsKey(title)) {
            System.out.print("Enter the number of books you want to borrow: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number for quantity. ❌");
                System.out.print("Enter quantity: ");
                scanner.next();
            }
            int quantityToBorrow = scanner.nextInt();

            Book book = library.get(title);

            if (book.getQuantity() >= quantityToBorrow) {
                book.subtractQuantity(quantityToBorrow);
                System.out.println("Books borrowed successfully! ✅");
            } else {
                System.out.println("Not enough books available to borrow. ❌");
            }
        } else {
            System.out.println("Book not found in the library. ❌");
        }
    }

    private static void returnBook() {
        displayBooks();
        System.out.print("Enter the title of the book you want to return: ");
        String title = scanner.next();

        if (library.containsKey(title)) {
            System.out.print("Enter the number of books you want to return: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number for quantity. ❌");
                System.out.print("Enter quantity: ");
                scanner.next();
            }
            int quantityToReturn = scanner.nextInt();

            Book book = library.get(title);

            book.addQuantity(quantityToReturn);
            System.out.println("Books returned successfully! ✅");
        } else {
            System.out.println("Book not found in the library. ❌");
        }
    }

    private static void displayBooks() {
        System.out.println("\nAvailable Books in the Library: ");
        System.out.printf("%-20s | %-20s | %-10s\n", "Title", "Author", "Quantity");
        for (Book book : library.values()) {
            System.out.printf("%-20s | %-20s | %-10s\n", book.getTitle(), book.getAuthor(), book.getQuantity());
        }
    }
    
    

    private static class Book {
        private final String title;
        private final String author;
        private int quantity;

        public Book(String title, String author, int quantity) {
            this.title = title;
            this.author = author;
            this.quantity = quantity;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getQuantity() {
            return quantity;
        }

        public void addQuantity(int quantity) {
            this.quantity += quantity;
        }

        public void subtractQuantity(int quantity) {
            this.quantity -= quantity;
        }

        @Override
        public String toString() {
            return title + " by " + author + " - Quantity: " + quantity;
        }
    }
}
