package com.workintech.library.main;

import com.workintech.library.models.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Category novelCategory = Category.NOVEL;
        Category fantasyCategory = Category.FANTASY;
        Category romanceCategory = Category.ROMANCE;

        Author ilber = new Author("İlber Ortaylı");
        Author dostoyevski = new Author("Dostoyevski");
        Author george = new Author("George Orwell");
        Author jack = new Author("Jack London");
        Author agatha = new Author("Agatha Christie");
        Author rahmi = new Author("Hüseyin Rahmi Gürpınar");


        Book book1 = new Book(1, ilber, "İnsan Geleceğini Nasıl Kurar?", Status.AVAILABLE, novelCategory);
        Book book2 = new Book(2, dostoyevski, "Yeraltından Notlar", Status.AVAILABLE, fantasyCategory);
        Book book3 = new Book(3, george, "Hayvan Çiftliği", Status.AVAILABLE, romanceCategory);
        Book book4 = new Book(4, ilber, "Osmanlı'yı Yeniden Keşfetmek", Status.AVAILABLE, novelCategory);
        Book book5 = new Book(5, dostoyevski, "Yeraltından Notlar", Status.AVAILABLE, fantasyCategory);
        Book book6 = new Book(6, jack, "Beyaz Diş", Status.AVAILABLE, romanceCategory);
        Book book7 = new Book(7, agatha, "Fare Kapanı", Status.AVAILABLE, novelCategory);
        Book book8 = new Book(8, jack, "Kızıl Veba", Status.AVAILABLE, fantasyCategory);
        Book book9 = new Book(9, rahmi, "Cehennemlik", Status.AVAILABLE, romanceCategory);

        System.out.println("Books associated with Author 'İlber Ortaylı':");
        for (Book book : ilber.getBookList()) {
            System.out.println(book);
        }


        Map<Integer,Book> libraryBooks = new HashMap<>();
        libraryBooks.put(1, book1);
        libraryBooks.put(2, book2);
        libraryBooks.put(3, book3);
        libraryBooks.put(4, book4);
        libraryBooks.put(5, book5);
        libraryBooks.put(6, book6);
        libraryBooks.put(7, book7);
        libraryBooks.put(8, book8);


        Library library = new Library(libraryBooks);  // Create a Library instance

        System.out.println("""
                ****************  LIBRARY  *************""");
        library.printBooks();

        System.out.println("""
                ****************  AGATHA  *************""");
        library.getBooksByAuthor(agatha);


        System.out.println("""
                ****************  NOVELS  *************""");
        library.getBooksByCategory(Category.NOVEL);

        System.out.println("Library size: "+libraryBooks.size());



        System.out.println("***************************************");


        System.out.println("Book1: "+ book1 + "\n");


        Member enes = new Member("Enes", Role.READER, 1,  "Member Address", "123-456-7890");
        Member dogancan = new Member("Dogancan", Role.READER, 2,  "Member Address", "123-456-78900");

        System.out.println("After initializitaion of members: \n");

        System.out.println(enes);
        System.out.println(dogancan);

        // Creating a librarian
        Librarian librarian = new Librarian("Librarian Name", "1234",library);

        // Issuing a book to the member
        librarian.issueBook(enes, book2);
        System.out.println("Book2: " + book2);
        librarian.issueBook(enes, book2);

        librarian.issueBook(dogancan, book2);
        librarian.issueBook(dogancan, book3);
        librarian.issueBook(dogancan, book3);
        librarian.issueBook(dogancan, book5);
        librarian.issueBook(dogancan, book6);
        librarian.issueBook(dogancan, book7);
        librarian.issueBook(dogancan, book8);
        librarian.issueBook(dogancan, book9);








        System.out.println("After issuing books to members: \n");

        // Printing the member's information
        System.out.println("Member Information:");
        System.out.println(enes);
        System.out.println(dogancan);
        System.out.println(dogancan.getBooks_issued().size());

        System.out.println("**********************************");


//        // Printing the author's information
//        System.out.println("\nAuthor Information:");
//        System.out.println(author1);
//
//        // Printing the library's books by category
//        System.out.println("\nBooks in Fantasy Category:");
//        System.out.println(library.getBooksByCategory(Category.FANTASY));
//
//        // Printing the library's books by author
//        System.out.println("\nBooks by Author 'Author 1':");
//        System.out.println(library.getBooksByAuthor("Author 1"));
//
//        // Deleting a book from the library
//        library.deleteBook(book3.getBook_id(), book3);
//
//        // Printing the updated library information
//        System.out.println("\nLibrary Information:");
//        System.out.println(library);
    }
}
