package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    // Add the missing implementation to this class
    String address;
    List<Book> books;

    public Library(String address){
        this.address = address;
        this.books = new ArrayList<>();

    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public static void printOpeningHours(){
        System.out.print("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress(){
        System.out.println(address);
    }

    public void printAvailableBooks(){
        if(books == null || books.size() == 0){
            System.out.print("No book in catalog");
            return;
        }
        books.stream().forEach(book -> {
            if (!book.isBorrowed()) {
                System.out.println(book.getTitle());
            }
        });
    }
    public void borrowBook(String bookName){
        for(Book book : books){
            if(book.getTitle().equals(bookName)){
                if(book.isBorrowed()) {
                    System.out.println("Sorry, this book is already borrowed");
                    return;
                }else{
                    System.out.println("You successfully borrowed" + bookName);
                    book.borrowed();
                    return;
                }
            }
        }
        System.out.println("Sorry, this book is not in our catalog.");
    }

    public void returnBook(String bookName){
        for (Book book : books) {
            if(book.getTitle().equals(bookName)){
                book.returned();
                System.out.println("You successfully returned" + bookName);
            }
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}