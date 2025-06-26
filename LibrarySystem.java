import java.util.*;

// Define Book class
class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;
    private String dueDate;

    // Constructor to initialize Book object
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false; // Initially not checked out
        this.dueDate = ""; // Initially no due date
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getDueDate() {
        return dueDate;
    }

    // Setter methods
    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}

// Define Patron class
class Patron {
    private String name;
    private String id;

    // Constructor to initialize Patron object
    public Patron(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

// Define Library class
class Library {
    private Map<String, Book> books; // Map to store books with title as key
    private List<Patron> patrons; // List to store patrons
    private Scanner scanner;

    // Constructor to initialize Library object
    public Library() {
        books = new HashMap<>(); // Initialize HashMap for books
        patrons = new ArrayList<>(); // Initialize ArrayList for patrons
        scanner = new Scanner(System.in); // Initialize Scanner for user input
    }

    // Method to add a book to the library
    public void addBook(String title, String author) {
        books.put(title, new Book(title, author)); // Add book to HashMap
        System.out.println("Book added successfully.");
    }

    // Method to remove a book from the library
    public void removeBook(String title) {
        if (books.containsKey(title)) {
            books.remove(title); // Remove book from HashMap if found
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Method to check out a book
    public void checkoutBook(String title, String patronId, String dueDate) {
        Book book = books.get(title);
        if (book != null && !book.isCheckedOut()) {
            book.setCheckedOut(true); // Set book as checked out
            book.setDueDate(dueDate); // Set due date
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Book not available for checkout.");
        }
    }

    // Method to check in a book
    public void checkinBook(String title) {
        Book book = books.get(title);
        if (book != null && book.isCheckedOut()) {
            book.setCheckedOut(false); // Set book as checked in
            book.setDueDate(""); // Clear due date
            System.out.println("Book checked in successfully.");
        } else {
            System.out.println("Book is not checked out.");
        }
    }

    // Method to add a patron to the library
    public void addPatron(String name, String id) {
        patrons.add(new Patron(name, id)); // Add patron to ArrayList
        System.out.println("Patron added successfully.");
    }

    // Method to search for author of  a book
    public void searchBook(String query) {
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query)) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                        ", Status: " + (book.isCheckedOut() ? "Checked out" : "Available"));
            }
        }
    }

    // Method for display all  books in the library
    public void displayBooks() {
        for (Book book : books.values()) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Status: " + (book.isCheckedOut() ? "Checked out" : "Available"));
        }
    }

    // Method to display 
    public void menu() {
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Checkout Book");
        System.out.println("4. Checkin Book");
        System.out.println("5. Add Patron");
        System.out.println("6. Search Book");
        System.out.println("7. Display Books");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }
}

// Main class to run the library management system
public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library(); // Create Library object
        Scanner scanner = new Scanner(System.in); // Create Scanner object for user input

        boolean running = true; // Flag to control loop
        while (running) {
            library.menu(); // Display menu
            int choice = scanner.nextInt(); // Get user choice
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: //  for a Add Book
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2: // Remove Book
                    System.out.print("Enter title: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBook(removeTitle);
                    break;
                case 3: // Checkout Book current location of book 
                    System.out.print("Enter title: ");
                    String checkoutTitle = scanner.nextLine();
                    System.out.print("Enter patron ID: ");
                    String patronId = scanner.nextLine();
                    System.out.print("Enter due date: ");
                    String dueDate = scanner.nextLine();
                    library.checkoutBook(checkoutTitle, patronId, dueDate);
                    break;
                case 4: // Checkin Book
                    System.out.print("Enter title: ");
                    String checkinTitle = scanner.nextLine();
                    library.checkinBook(checkinTitle);
                    break;
                case 5: // Add Patron
                    System.out.print("Enter patron name: ");
                    String patronName = scanner.nextLine();
                    System.out.print("Enter patron ID: ");
                    String patronIdAdd = scanner.nextLine();
                    library.addPatron(patronName, patronIdAdd);
                    break;
                case 6: // Search Book
                    System.out.print("Enter search query (title or author): ");
                    String query = scanner.nextLine();
                    library.searchBook(query);
                    break;
                case 7: // Display Books
                    library.displayBooks();
                    break;
                case 8: // Exit
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
}
}
}
