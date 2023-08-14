package com.workintech.library.models;

import java.util.*;

public class Library implements LibraryInterface {
    private Map<Integer,Book> books;

    public Library(Map<Integer, Book> books) {
        this.books = books;
    }


    public Map<Integer, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Integer, Book> books) {
        this.books = books;
    }
    public boolean bookExists(Book book) {
        return books.containsValue(book);
    }
    public void printBooks() {

        for (Book book: books.values()
             ) {
            System.out.println("Book id:" + book.getBook_id() + "\n"
                    + "Author:" + book.getAuthor() + "\n"
                    +"Title: " + book.getTitle() +  "\n");
        };
    }

    public void addBook(int id,Book book){

        books.put(id,book);
    }

    public void updateBook(int id,Book book){
        books.put(id,book);

    }

    public void deleteBook(int id,Book book){
        books.remove(id,book);

    }

    public void getBooksByCategory(Category category) {

        try{
            for (Book book : books.values()) {
                if (book.getCategory() == category) {
                    System.out.println(book);            }
            }
        }  catch (Exception exception) {
            System.out.println("Kategoriye göre kitaplar getirilemedi..!");
        }
    }


    public void getBooksByAuthor(Author author) {

        try {
            for (Book book : author.getBookList()) {
                System.out.println(book);
            }


        } catch (Exception exception) {
            System.out.println("Yazara göre kitaplar getirilemedi..!");
        }
    }


    @Override
    public String toString() {
        return "Library{" + "\n" +
                "books=" + books +
                '}';
    }
}
