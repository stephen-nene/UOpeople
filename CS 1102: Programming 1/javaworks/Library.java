import textio.TextIO;

public class Library {

    public static void main(String[] args) {
        // Initialize the library database
        LibraryDatabase library = new LibraryDatabase();
        addDefaultBooks(library);


        int choice;

        do {
            // Display the menu
            displayMenu();

            // Prompt the user for choice
            System.out.println("\nPlease enter your choice, oh great wizard.🧙🏽‍♂️\n");
            choice = TextIO.getInt();

            // Switch on user's choice
            switch (choice) {
                case 1:
                    library.addBooks();
                    break;
                case 2:
                    library.borrowBooks();
                    break;
                case 3:
                    library.returnBooks();
                    break;
                case 4:
                    library.listAllBooks();
                    break;
                case 5:
                    System.out.println("Exiting the library. Goodbye, wizard! 👋🧙🏽‍♂️");
                    break;
                default:
                    System.out.println("Invalid input! Please choose a valid option. 🔮");
            }

        } while (choice != 5);
    }

    // Display the menu options
    private static void displayMenu() {
        System.out.println("\nLibrary System Menu 🏰");
        System.out.println("1. Add Books 📚");
        System.out.println("2. Borrow Books 🤲");
        System.out.println("3. Return Books 🔄");
        System.out.println("4. List All Books 📖");
        System.out.println("5. Exit 🚪");
    }

        // Helper method to add default books to the library
        private static void addDefaultBooks(LibraryDatabase library) {
            // Adding some default books for demo purposes
            library.addBook(1,"The Great Gatsby", "F. Scott Fitzgerald", 5);
            library.addBook(2,"To Kill a Mockingbird", "Harper Lee", 8);
            library.addBook(3,"1984", "George Orwell", 10);
            library.addBook(4,"Pride and Prejudice", "Jane Austen", 7);
            library.addBook(5,"The Catcher in the Rye", "J.D. Salinger", 6);
            // Add more books as needed
        }
}

class LibraryDatabase {
    // Database to store books
    private Book[] books;
    private int numberOfBooks;

    // Constructor to initialize the library database
    public LibraryDatabase() {
        this.books = new Book[100]; // Assume a maximum of 100 books for simplicity
        this.numberOfBooks = 0;
        
    }

    public void addBook(int id,String title, String author, int quantity) {
    // Check if the book already exists
    for (int i = 0; i < numberOfBooks; i++) {
        if (books[i].title.equals(title) && books[i].author.equals(author)) {
            books[i].quantity += quantity; // Update quantity if the book exists
            System.out.println("Book added successfully! 📚");
            return;
        }
    }

    // Add a new book if it doesn't exist
    books[numberOfBooks] = new Book(id,title, author, quantity);
    numberOfBooks++;
}
// Class variable to track the last used book ID
private static int lastBookId = 1;

// Method to add books to the library
public void addBooks() {
    System.out.println("Please enter the book title💾");
    String title = TextIO.getln();TextIO.getln();
    System.out.println("Please enter the author💾");
    String author = TextIO.getln();TextIO.getln();
    System.out.println("Please enter the quantity💾");
    int quantity = TextIO.getInt();

    // Check if the book already exists
    for (int i = 0; i < numberOfBooks; i++) {
        if (books[i].title.equals(title) && books[i].author.equals(author)) {
            books[i].quantity += quantity; // Update quantity if the book exists
            System.out.println("Book updated successfully! 📚");
            return;
        }
    }

    // Add a new book if it doesn't exist
    books[numberOfBooks] = new Book(lastBookId++, title, author, quantity);
    numberOfBooks++;
    System.out.println("New book added to the library! 📚");
}


    // Method to borrow books from the library
    public void borrowBooks() {
        listAllBooks();
        System.out.println("\nPlease select a book to borrow💰");

        // Display books with IDs
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println(books[i] + ". " + books[i].title + " by " + books[i].author + " (Available: " + books[i].quantity + ")");
        }

        int selectedId = TextIO.getInt();

        System.out.println("Please enter the number of books to borrow💰\n");
        int quantityToBorrow = TextIO.getInt();

        // Check if the requested number of books is available
        for (int i = 0; i < numberOfBooks; i++) {
            if (books[i].id == selectedId && books[i].quantity >= quantityToBorrow) {
                books[i].quantity -= quantityToBorrow; // Update quantity if books are available
                System.out.println("Books borrowed successfully! 🤲");
                return;
            }
        }

        // Display an error message if books are not available
        System.out.println("Error: Requested books not available! 🚫");
    }


    // Method to return books to the library
    public void returnBooks() {
        System.out.println("Please enter the book title to return🔄");
        String title = TextIO.getln();
        System.out.println("Please enter the number of books to return🔄");
        int quantityToReturn = TextIO.getInt();

        // Check if the books being returned belong to the library system
        for (int i = 0; i < numberOfBooks; i++) {
            if (books[i].title.equals(title)) {
                books[i].quantity += quantityToReturn; // Update quantity if books belong to the library
                System.out.println("Books returned successfully! 🔄");
                return;
            }
        }

        // Display an error message if books do not belong to the library system
        System.out.println("Error: Returned books do not belong to the library! 🚫");
    }

    // Method to list all books in the library
    public void listAllBooks() {
        System.out.println("\nList of All Books 📖");
        System.out.printf("%-3s%-25s%-25s%-10s\n", "ID", "Title", "Author", "Quantity");
        System.out.println("-----------------------------------------");

        for (int i = 0; i < numberOfBooks; i++) {
            System.out.printf("%-3d%-25s%-25s%-10d\n", i + 1, books[i].title, books[i].author, books[i].quantity);
        }
    }

    // Inner class to represent a Book
    private static class Book {
        int id;
        String title;
        String author;
        int quantity;

        // Constructor to create a Book
        public Book(int id, String title, String author, int quantity) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.quantity = quantity;
        }
    }
}
