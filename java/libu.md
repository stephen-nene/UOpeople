Here's a **Java program** that implements the **basic library system** as required. It allows users to **add books, borrow books, return books, and exit** while maintaining the book inventory.

---

### **Java Code: Basic Library System**
```java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }
}

public class LibrarySystem {
    private static final Map<String, Book> library = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());  // Handle invalid input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> addBook();
                case 2 -> borrowBook();
                case 3 -> returnBook();
                case 4 -> {
                    System.out.println("Exiting Library System. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option! Please choose a valid option.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine().trim();
        System.out.print("Enter quantity: ");

        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine());
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Quantity must be a number.");
            return;
        }

        if (library.containsKey(title)) {
            library.get(title).quantity += quantity;
            System.out.println("Book quantity updated successfully.");
        } else {
            library.put(title, new Book(title, author, quantity));
            System.out.println("Book added successfully.");
        }
    }

    private static void borrowBook() {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine().trim();
        if (!library.containsKey(title)) {
            System.out.println("Book not found in library.");
            return;
        }

        System.out.print("Enter quantity to borrow: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine());
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Quantity must be a number.");
            return;
        }

        Book book = library.get(title);
        if (book.quantity >= quantity) {
            book.quantity -= quantity;
            System.out.println("Successfully borrowed " + quantity + " copies of \"" + title + "\".");
        } else {
            System.out.println("Insufficient copies available. Only " + book.quantity + " left.");
        }
    }

    private static void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine().trim();
        if (!library.containsKey(title)) {
            System.out.println("This book is not from our library.");
            return;
        }

        System.out.print("Enter quantity to return: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine());
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Quantity must be a number.");
            return;
        }

        library.get(title).quantity += quantity;
        System.out.println("Successfully returned " + quantity + " copies of \"" + title + "\".");
    }
}
```
---

## **Explanation of the Program**
1. **Data Structure Used**  
   - A **HashMap (`library`)** is used to store books.  
   - The **key** is the book **title**, and the **value** is a `Book` object containing the **title, author, and quantity**.  

2. **Features Implemented**  
   - **Add Books**  
     - If the book already exists, its **quantity is updated**.  
     - If it's a new book, it's **added to the library**.  
   - **Borrow Books**  
     - Checks if the book **exists**.  
     - Checks if the **requested quantity** is available before borrowing.  
   - **Return Books**  
     - Ensures the book exists before **updating the quantity**.  
   - **Exit Option**  
     - Allows the user to **exit the system** safely.  

3. **Error Handling**  
   - **Invalid inputs** (e.g., entering a string instead of a number) are handled with `try-catch`.  
   - **Negative or zero values** for quantity are not allowed.  
   - **Case trimming (`trim()`)** is used to avoid input issues with spaces.  

---

## **Example Output & Screenshots**

**Adding a Book:**
```
Enter book title: The Great Gatsby
Enter author name: F. Scott Fitzgerald
Enter quantity: 5
Book added successfully.
```

**Borrowing a Book:**
```
Enter book title to borrow: The Great Gatsby
Enter quantity to borrow: 2
Successfully borrowed 2 copies of "The Great Gatsby".
```

**Returning a Book:**
```
Enter book title to return: The Great Gatsby
Enter quantity to return: 2
Successfully returned 2 copies of "The Great Gatsby".
```

**Invalid Input Handling:**
```
Enter quantity: ABC
Invalid input. Quantity must be a number.
```

---

## **Submission Instructions**
- **Save the Java program** in a `.java` file (e.g., `LibrarySystem.java`).  
- **Take screenshots** of sample runs showing different operations.  
- **Create a Word/PDF file** containing:  
  - **Program Code**
  - **Explanation**
  - **Screenshots of execution output**  
- **Submit the Word/PDF file as required.**  

Let me know if you need any modifications! 🚀