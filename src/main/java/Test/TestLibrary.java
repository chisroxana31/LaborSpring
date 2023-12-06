package Test;

import Domain.*;
import Patterns.EventsFactory;
import Patterns.LibraryObserver;
import Patterns.LibraryPolicy;
import Patterns.SimpleLibraryPolicy;
import org.testng.Assert;


import java.util.List;
import static org.testng.AssertJUnit.*;

public class TestLibrary {

//    public static void testLibrarian() {
//
//        Librarian.reset();
//        Librarian librarian = Librarian.getInstance("John Doe");
//        Librarian librarian2 = Librarian.getInstance("Jane");
//
//        String name = librarian.getName();
//        String name2 = librarian2.getName();
//        System.out.println("Librarian Name: " + name);
//        System.out.println("Librarian Name: " + name2);
//        Assert.assertEquals(librarian.getName(), librarian2.getName());
//    }
//
//    public static void testLibrary() {
//        // Create a Library instance
//        Librarian librarian = Librarian.getInstance("John Doe");
//        Library library = new Library(librarian);
//
//        // Create a simple library observer for testing
//        LibraryObserver testObserver = new LibraryObserver() {
//            @Override
//            public void update(Library library) {
//                System.out.println("Library updated!");
//            }
//        };
//
//        // Add the observer to the library
//        library.addObserver(testObserver);
//
//        // Add a book to the library and check if the observer is notified
//        Book book1 = new Book();
//        book1.setTitle("123");
//        Book book2 = new Book();
//        book2.setTitle("321");
//        library.addBook(book1);
//        library.addBook(book2);
//
//        // Add a customer to the library
////        library.addCustomer(new Customer("TestCustomer"));
//
//        // Get the list of books in the library
//        List<Book> books = library.getBooks();
//
//        // Print the list of books
//        System.out.println("Books in the library:");
//        for (Book book : books) {
//            System.out.println(book.getTitle());
//        }
//    }
//
//    public static void testFactory() {
//        // Create a book event
//        Events bookEvent = EventsFactory.createEvent("Book", "BookEvent");
//        System.out.println("Created event type: " + bookEvent.getName());
//
//        // Create another type of event
//        Events otherEvent = EventsFactory.createEvent("Other", "OtherEvent");
//        System.out.println("Created event type: " + otherEvent.getName());
//
//        // Try to create an unsupported event type
//        try {
//            Events unsupportedEvent = EventsFactory.createEvent("Unsupported", "UnsupportedEvent");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//    public static void LibraryTest(){
//            // Create instances for testing
//            Customer customer = new Customer("John Cena",1);
//            Book book = new Book();
//            book.setTitle("Test Title");
//
//            // Create a test library policy
//            SimpleLibraryPolicy testLibraryPolicy = new SimpleLibraryPolicy();
//
//            // Create a Library instance with the test library policy
//            Librarian librarian = Librarian.getInstance("test");
//            Library library = new Library(librarian);
//            library.setLibraryPolicy(testLibraryPolicy);
//
//            // Call the borrowBook method
//            library.borrowBook(customer, book);
//        }
    }
