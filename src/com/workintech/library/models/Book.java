package com.workintech.library.models;

import java.util.Objects;

public class Book {
    private int book_id;
    private Author author;
    private String title;

    private Status status;
    private Category category;
    private Member borrower;

    public Book(int book_id, Author author, String title, Status status, Category category) {
        this.book_id = book_id;
        this.author = author;
        this.title = title;
        this.status = status;
        this.category = category;
        this.borrower=null;
        author.addBook(this);

    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Member getBorrower() {
        return borrower;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_id == book.book_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id);
    }


    @Override
    public String toString() {

            return "Book{" +
                    "book_id=" + book_id +
                    ", author=" + author +
                    ", title='" + title + '\'' +
                    ", status=" + status +
                    ", category=" + category +
                    ", borrower=" + borrower +
                    '}';


    }
}
