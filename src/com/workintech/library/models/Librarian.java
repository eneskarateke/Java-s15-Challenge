package com.workintech.library.models;

public class Librarian extends Person  {
    private String password;
    private LibraryInterface library;


    public Librarian(String name, String password,LibraryInterface library) {
        super(name, Role.LIBRARIAN);
        this.password = password;
        this.library = library;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void issueBook(Member member, Book book) {
        if (member == null || book == null) {
            System.out.println("Hata! Geçersiz üye veya kitap.");
            return;
        }

        if (!library.bookExists(book)) {
            System.out.println("Kitap kütüphanede bulunmuyor.");
            return;
        }

        if (!canIssueBook(member)) {
            System.out.println("Kullanıcının kitap limitine ulaşıldı.");
            return;
        }

        if (!canLendBook(book)) {
            System.out.println("Kitap başka bir üyede: " + book.getBorrower().getName() + " id: " + book.getBorrower().getMember_id());
            return;
        }

        if (member.hasIssuedBook(book)) {
            System.out.println("Aynı kitaptan ödünç alamazsınız.");
            return;
        }

        // All checks passed, issue the book
        book.setStatus(Status.BORROWED);
        book.setBorrower(member);
        member.getBooks_issued().add(book);
        updateMemberBill(member);

        System.out.println(book.getBook_id() + " id'li kitap " + member.getMember_id() + " id'li üye'ye ödünç verildi.");
    }



    private boolean canIssueBook(Member member) {
        return member.getBooks_issued().size() < member.getBook_limit();
    }

    private boolean canLendBook(Book book) {
        if (book.getStatus() == Status.AVAILABLE){
            return true;
        } else {
            System.out.println("Kitap başkasında " + book.getBorrower().getName());
            return false;
        }
    }


    protected void updateMemberBill(Member member) {
        member.setBill(member.getBooks_issued().size() * 4.99);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "password='" + password + '\'' +
                '}';
    }
}
