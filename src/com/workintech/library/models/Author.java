package com.workintech.library.models;

import java.util.*;

public class Author extends Person{

    private Set<Book> bookList;


    public Author(String name) {
        super(name, Role.AUTHOR);
        this.bookList=new HashSet<>();
    }


    public Set<Book> getBookList() {
        return bookList;
    }

    public void setBookList(Set<Book> bookList) {
        this.bookList = bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public String toString() {
        return "Author{" +
               "Name: " + super.getName()  + "\n" +
                " bookList=" + bookList +
                '}';
    }
}
