package com.workintech.library.models;

import java.util.*;

public class Author extends Person{

    private Set<Book> bookList;
    private int authorId;


    public Author(String name, int authorId) {
        super(name, Role.AUTHOR);
        this.bookList = new HashSet<>();
        this.authorId = authorId;
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

    public int getAuthorId() {
        return authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId == author.authorId && Objects.equals(bookList, author.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookList, authorId);
    }

    @Override
    public String toString() {
        return
                super.toString();

    }
}
