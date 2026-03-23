package services;

import entities.Book;
import entities.Loan;
import entities.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "name")
public class Biblioteca {

    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private Map<String, Book> catalog;
    private Map<String, User> users;
    private Map<User, HashSet<Loan>> loans;

    public Biblioteca(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.catalog = new HashMap<>();
        this.users = new HashMap<>();
        this.loans = new TreeMap<>(Comparator.comparing(User::getLastName).thenComparing(User::getName));
    }

    public void addBook(Book book) {
        this.catalog.put(book.getIsbn(), book); //key-value
    }

    public void addUser(User user) {
        this.users.put(user.getDni(), user); //key-value
    }


}
