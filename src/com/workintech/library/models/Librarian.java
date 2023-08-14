package com.workintech.library.models;

public class Librarian extends Person {
    private String password;

    public Librarian(String name, String password) {
        super(name, Role.LIBRARIAN);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void issueBook(Member member, Book book) {
        if (canIssueBook(member) && canLendBook(book)) {

                book.setStatus(Status.BORROWED);
                book.setBorrower(member);
                updateMemberBill(member);
                System.out.println(book.getBook_id() +" id'li kitap " + member.getMember_id() + " id'li üye'ye" + " ödünç verildi.");
        } else if (member.hasIssuedBook(book)) {
            System.out.println("Aynı kitaptan iki farklı kopya alamazsınız.");

        } else if (!canIssueBook(member) && canLendBook(book)) {

            System.out.println("Kullanıcının kitap limitine ulaşıldı.");
        } else if (canIssueBook(member) && !canLendBook(book))  {
            System.out.println("Kitap başka bir üyede: " + book.getBorrower().getName() + " id: " + book.getBorrower().getMember_id());
        }
    }

    private boolean canIssueBook(Member member) {
        return member.getBooks_issued().size() <= member.getBook_limit();
    }

    private boolean canLendBook(Book book) {
        return book.getStatus() == Status.AVAILABLE;
    }

    private void updateMemberBill(Member member) {
        member.setBill(member.getBooks_issued().size() * 4.99);
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "password='" + password + '\'' +
                '}';
    }
}
