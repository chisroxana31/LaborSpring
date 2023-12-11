package Domain;

import Patterns.LibraryObserver;
import Patterns.LibraryPolicy;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Library")
public class Library implements LibraryPolicy{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLibrary;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Customer> customers = new ArrayList<>();

    private LibraryPolicy libraryPolicy;

    private static Library instance;

    public Library() {
        //default constructor for JPA
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setLibrary(this);
    }
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setLibraryPolicy(LibraryPolicy libraryPolicy) {
        this.libraryPolicy = libraryPolicy;
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void borrowBook(Customer customer, Book book) {
        libraryPolicy.borrowBook(customer, book);
    }

    private List<LibraryObserver> observers = new ArrayList<>();

    public void addObserver(LibraryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LibraryObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (LibraryObserver observer : observers) {
            observer.update(this);
        }
    }
    public void printAllCustomers() {
        System.out.println("All Customers:");

        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }

    }
    public Book findBookByName(String bookNameForEvent) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookNameForEvent)) {
                return book;
            }
        }
        return null;
    }
    public Customer getCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }
}
