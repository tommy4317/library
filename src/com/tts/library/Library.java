package com.tts.library;

import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
    private String address;
    private ArrayList<Book> inventory = new ArrayList<>();

    public Library(String address) {
        this.address = address;
    }

    public void printAddress() {
        System.out.println(this.address);
    }

    public void printAvailableBooks() {
        if(inventory.size() == 0) System.out.println("No books in catalog.");

        for (Book book: inventory) {
            if(!book.isBorrowed()) System.out.println(book.getTitle());
        }
    }

    public void addBook(Book book){
        if(inventory.contains(book)){
            System.out.println("This library already has " + book.getTitle() + ". Please add a different book.");
        }else{
            inventory.add(book);
        }
    }

    public void borrowBook(String bookTitle){
        for (Book book: inventory) {
            if(book.getTitle().equals(bookTitle) && !book.isBorrowed()) {
                System.out.println("You successfully borrowed " + bookTitle);
                book.borrowed();
                break;
            }else if(book.getTitle().equals(bookTitle) && book.isBorrowed()){
                System.out.println("Sorry, this book is already being borrowed.");
            }else{
                continue;
            }
            System.out.println("Sorry, This Book is not in our catalog.");
        }
    }
    public void returnBook(String bookTitle){
        for (Book book: inventory) {
            if(book.getTitle().equals(bookTitle) && book.isBorrowed()) {
                System.out.println("You successfully returned  " + bookTitle);
                book.returned();
            }
        }
    }
    public static void printOpeningHours(){
        System.out.println("9AM - 5PM");
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
