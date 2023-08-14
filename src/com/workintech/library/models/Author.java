package com.workintech.library.models;

import java.util.Map;

public class Author extends Person{

    private Map<Integer, Book> bookMap;


    public Author(String name,Map<Integer, Book> bookMap) {
        super(name, Role.AUTHOR);
        this.bookMap=bookMap;
    }


    public Map<Integer, Book> getBookMap() {
        return bookMap;
    }

    public void setBookMap(Map<Integer, Book> bookMap) {
        this.bookMap = bookMap;
    }



    @Override
    public String toString() {
        return "Author{" +
                "bookMap=" + bookMap +
                '}';
    }
}
