package com.workintech.library.models;

import java.util.*;

public class Library {
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
    public void addBook(int id,Book book){

        books.put(id,book);
    }

    public void updateBook(int id,Book book){
        books.put(id,book);

    }

    public void deleteBook(int id,Book book){
        books.remove(id,book);

    }

    public Set<Book> getBooksByCategory(Category category) {

        Set<Book> booksInCategory = new HashSet<>();

        for (Book book : books.values()) {
            if (book.getCategory() == category) {
                booksInCategory.add(book);
            }
        }

        return booksInCategory;
    }

    public Set<Book> getBooksByAuthor(String author) {

        try {
            Set<Book> booksByAuthor = new HashSet<>();

            for (Book book : books.values()) {
                if (book.getAuthor().equals(author)) {
                    booksByAuthor.add(book);
                }
            }

            return booksByAuthor;

        } catch (Exception exception) {
            System.out.println("System error.!");
            return null;
        }
    }


    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
