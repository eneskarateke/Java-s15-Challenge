package com.workintech.library.models;

import java.util.*;

public class Member extends Person{

    private int member_id;
    private int book_limit;

    private String address;
    private String phone_number;

    private Set<Book> books_issued;

    private double bill;


    public Member(String name, Role role, int member_id,
                  String address, String phone_number){
        super(name, role);
        this.member_id = member_id;
        this.book_limit = 5;
        this.address = address;
        this.phone_number = phone_number;
        this.books_issued=new HashSet<>();
        this.bill =0;
    }


    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getBook_limit() {
        return book_limit;
    }

    public void setBook_limit(int book_limit) {
        this.book_limit = book_limit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Set<Book> getBooks_issued() {
        return books_issued;
    }

    public void setBooks_issued(Set<Book> books_issued) {
        this.books_issued = books_issued;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }



    public boolean returnBook(Book book) {
        if (hasIssuedBook(book)) {
            removeIssuedBook(book);
            book.setBorrower(null);
            book.setStatus(Status.AVAILABLE);


            return true;
        }
        return false;
    }


    protected boolean hasIssuedBook(Book book) {
        return books_issued.contains(book);
    }

    protected void removeIssuedBook(Book book) {
        books_issued.remove(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return member_id == member.member_id && Objects.equals(phone_number, member.phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member_id, phone_number);
    }

    @Override
    public String toString() {
        return "Member{" +
                "member_id=" + member_id +
                ", book_limit=" + book_limit +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", books_issued=" + books_issued +
                ", bill=" + bill +
                '}';
    }
}
