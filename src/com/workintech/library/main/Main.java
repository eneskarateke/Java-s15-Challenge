package com.workintech.library.main;

import com.workintech.library.models.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Category novelCategory = Category.NOVEL;
        Category fantasyCategory = Category.FANTASY;
        Category romanceCategory = Category.ROMANCE;

        Book book1 = new Book(1, "Author 1", "Book Title 1", Status.AVAILABLE, novelCategory);
        Book book2 = new Book(2, "Author 2", "Book Title 2", Status.AVAILABLE, fantasyCategory);
        Book book3 = new Book(3, "Author 3", "Book Title 3", Status.AVAILABLE, romanceCategory);
        Book book4 = new Book(1, "Author 1", "Book Title 1", Status.AVAILABLE, novelCategory);
        Book book5 = new Book(2, "Author 2", "Book Title 2", Status.AVAILABLE, fantasyCategory);
        Book book6 = new Book(4, "Author 3", "Book Title 4", Status.AVAILABLE, romanceCategory);

        Book book7 = new Book(5, "Author 3", "Book Title 5", Status.AVAILABLE, novelCategory);
        Book book8 = new Book(6, "Author 4", "Book Title 6", Status.AVAILABLE, fantasyCategory);
        Book book9 = new Book(7, "Author 5", "Book Title 8", Status.AVAILABLE, romanceCategory);



//        System.out.println(book1);
//        System.out.println(book2);
//        System.out.println(book3);

        // Creating a library
        Map<Integer,Book> libraryBooks = new HashMap<>();

        // Adding books to the library
        libraryBooks.put(book1.getBook_id(), book1);
        libraryBooks.put(book2.getBook_id(), book2);
        libraryBooks.put(book3.getBook_id(), book3);

        Library library = new Library(libraryBooks);  // Create a Library instance

//Aynı kitaptan birden fazla kopya olabileceği için map.
        Map<Integer,Book> booksForAuthor1 = new HashMap<>();

        booksForAuthor1.put(1,book1);
        booksForAuthor1.put(2,book2);
        booksForAuthor1.put(3,book3);
        booksForAuthor1.put(4,book3);

        Author author = new Author("author 1",booksForAuthor1);

        System.out.println("Author: \n" + author);
        System.out.println("***************************************");


        System.out.println("Book1: "+ book1 + "\n");


        Member enes = new Member("Enes", Role.READER, 1, 5, "Member Address", "123-456-7890");
        Member dogancan = new Member("Dogancan", Role.READER, 2, 5, "Member Address", "123-456-78900");

        System.out.println("After initializitaion of members: \n");

        System.out.println(enes);
        System.out.println(dogancan);
        // Creating a librarian
        Librarian librarian = new Librarian("Librarian Name", "1234");

        // Issuing a book to the member
        librarian.issueBook(enes, book2);
        System.out.println("Book2: " + book2);
        librarian.issueBook(enes, book2);

        librarian.issueBook(dogancan, book2);
        librarian.issueBook(dogancan, book3);




        System.out.println("After issuing books to members: \n");

        // Printing the member's information
        System.out.println("Member Information:");
        System.out.println(enes);
        System.out.println(dogancan);

        System.out.println("**********************************");


        // Printing the author's information
        System.out.println("\nAuthor Information:");
        System.out.println(author);

        // Printing the library's books by category
        System.out.println("\nBooks in Fantasy Category:");
        System.out.println(library.getBooksByCategory(Category.FANTASY));

        // Printing the library's books by author
        System.out.println("\nBooks by Author 'Author 1':");
        System.out.println(library.getBooksByAuthor("Author 1"));

        // Deleting a book from the library
        library.deleteBook(book3.getBook_id(), book3);

        // Printing the updated library information
        System.out.println("\nLibrary Information:");
        System.out.println(library);
    }
}
