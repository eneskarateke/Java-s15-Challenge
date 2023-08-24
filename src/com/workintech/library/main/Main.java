package com.workintech.library.main;

import com.workintech.library.models.*;

import java.util.*;

public class Main {


    private static boolean validateLibrarian(String name, String password, Librarian librarian) {
        return name.equals(librarian.getName()) && password.equals(librarian.getPassword());
    }


    public static void main(String[] args) {
        Category novelCategory = Category.NOVEL;
        Category fantasyCategory = Category.FANTASY;
        Category romanceCategory = Category.ROMANCE;

        Author ilber = new Author("İlber Ortaylı",1);
        Author dostoyevski = new Author("Dostoyevski",2);
        Author george = new Author("George Orwell",3);
        Author jack = new Author("Jack London",4);
        Author agatha = new Author("Agatha Christie",5);

        Map<Integer, Author> authors = new HashMap<>();
        authors.put(ilber.getAuthorId(),ilber);
        authors.put(dostoyevski.getAuthorId(), dostoyevski);
        authors.put(george.getAuthorId(),george);
        authors.put(jack.getAuthorId(), jack);
        authors.put(agatha.getAuthorId(), agatha);

        Book book1 = new Book(1, ilber, "İnsan Geleceğini Nasıl Kurar?", Status.AVAILABLE, novelCategory);
        Book book2 = new Book(2, dostoyevski, "Yeraltından Notlar", Status.AVAILABLE, fantasyCategory);
        Book book3 = new Book(3, george, "Hayvan Çiftliği", Status.AVAILABLE, romanceCategory);
        Book book4 = new Book(4, ilber, "Osmanlı'yı Yeniden Keşfetmek", Status.AVAILABLE, novelCategory);
        Book book5 = new Book(5, dostoyevski, "Yeraltından Notlar", Status.AVAILABLE, fantasyCategory);
        Book book6 = new Book(6, jack, "Beyaz Diş", Status.AVAILABLE, romanceCategory);
        Book book7 = new Book(7, agatha, "Fare Kapanı", Status.AVAILABLE, novelCategory);
        Book book8 = new Book(8, jack, "Kızıl Veba", Status.AVAILABLE, fantasyCategory);

        Map<Integer,Book> libraryBooks = new HashMap<>();
        libraryBooks.put(book1.getBook_id(), book1);
        libraryBooks.put(book2.getBook_id(), book2);
        libraryBooks.put(book3.getBook_id(), book3);
        libraryBooks.put(book4.getBook_id(), book4);
        libraryBooks.put(book5.getBook_id(), book5);
        libraryBooks.put(book6.getBook_id(), book6);
        libraryBooks.put(book7.getBook_id(), book7);
        libraryBooks.put(book8.getBook_id(), book8);

        Library library = new Library(libraryBooks);

        Member enes = new Member("Enes", Role.READER, 1,  "Member Address", "123-456-7890");
        Member dogancan = new Member("Dogancan", Role.READER, 2,  "Member Address", "123-456-78900");
        Map<Integer,Member> members = new HashMap<>();
        members.put(enes.getMember_id(),enes);
        members.put(dogancan.getMember_id(), dogancan);

        Librarian librarian = new Librarian("ali", "1234",library);

        boolean continueRunning = true;

        while(continueRunning) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Rolünüzü seçin:");
            System.out.println("1. Member / Reader");
            System.out.println("2. Librarian");
            System.out.print("Seçiminizi girin: ");
            int roleChoice = scanner.nextInt();
            scanner.nextLine();

            if (roleChoice == 1) {
                System.out.println("Rolünüz: Member / Reader");
                System.out.println("1. Kitaplara Bak");
                System.out.println("2. Kitap İade Et");
                System.out.println("3. Çıkış");
                System.out.print("Seçiminizi girin: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("1. Kategoriye Göre Kitaplara Bak");
                        System.out.println("2. Yazarına Göre Kitaplara Bak");
                        System.out.println("3. Tüm Kitaplara Bak");
                        System.out.print("Seçiminizi girin: ");
                        int subChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (subChoice == 1) {
                            System.out.println("Kategoriler: ");
                            for (Category category : Category.values()) {
                                System.out.println(category);
                            }
                            System.out.print("Bir kategori seçin: ");
                            String categoryChoice = scanner.nextLine();
                            Category selectedCategory = Category.valueOf(categoryChoice.toUpperCase());
                            library.getBooksByCategory(selectedCategory);
                            break;
                        } else if (subChoice == 2) {
                            System.out.println("Yazarlar: ");
                            for (Map.Entry<Integer, Author> entry : authors.entrySet()) {
                                System.out.println(entry.getKey() + ". " + entry.getValue().getName());
                            }
                            System.out.print("Bir yazar seçin (rakam): ");
                            int selectedAuthorIndex = scanner.nextInt();
                            scanner.nextLine();
                            Author selectedAuthor = authors.get(selectedAuthorIndex);
                            if (selectedAuthor != null) {
                                library.getBooksByAuthor(selectedAuthor);
                            } else {
                                System.out.println("Geçersiz yazar seçimi.");
                            }
                            break;
                        } else if (subChoice == 3) {
                            library.printBooks();
                            break;
                        }
                    case 2:
                        System.out.println("Kitap iade etme işlemi seçildi.");
                        System.out.println("Üyeler:");
                        int memberIndex = 1;
                        for (Member member : members.values()) {
                            System.out.println(memberIndex + ". " + member.getName());
                            memberIndex++;
                        }
                        System.out.print("İade işlemi yapmak istediğiniz üyenin numarasını seçin (rakam): ");
                        int memberChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (memberChoice >= 1 && memberChoice <= members.size()) {
                            Member selectedMember = members.get(memberChoice);
                            Set<Book> issuedBooks = selectedMember.getBooks_issued();
                            if (issuedBooks.isEmpty()) {
                                System.out.println("İade edilebilecek kitap bulunmuyor.");
                            } else {
                                System.out.println("İade edilebilecek kitaplar:");
                                int index = 1;
                                for (Book book : issuedBooks) {
                                    System.out.println(index + ". " + book.getTitle());
                                    index++;
                                }
                                System.out.print("İade etmek istediğiniz kitabın numarasını seçin (rakam): ");
                                int returnChoice = scanner.nextInt();
                                scanner.nextLine();

                                if (returnChoice >= 1 && returnChoice <= issuedBooks.size()) {
                                    Book selectedBook = new ArrayList<>(issuedBooks).get(returnChoice - 1);
                                    boolean isReturned = selectedMember.returnBook(selectedBook);

                                    if (isReturned) {
                                        System.out.println(selectedBook.getTitle() + " kitabı iade edildi.");
                                    } else {
                                        System.out.println("Kitap iade işlemi başarısız oldu.");
                                    }
                                } else {
                                    System.out.println("Geçersiz kitap seçimi.");
                                }
                            }
                        } else {
                            System.out.println("Geçersiz üye seçimi.");
                        }
                        break;
                    case 3:
                        System.out.println("Çıkış yapılıyor...");
                        continueRunning = false;
                }
            } if (roleChoice == 2) {
                System.out.println("Rolünüz: Librarian");
                System.out.print("Kullanıcı adı (name): ");
                String librarianName = scanner.nextLine();
                System.out.print("Şifre (password): ");
                String librarianPassword = scanner.nextLine();

                if (validateLibrarian(librarianName, librarianPassword, librarian)) {
                    System.out.println("1. Kitap Ekle");
                    System.out.println("2. Kitap Sil");
                    System.out.println("3. Kitap Güncelle");
                    System.out.println("4. Kitap Ödünç Ver");
                    System.out.println("5. Yazar Ekle");
                    System.out.println("6. Kitaplara Bak");
                    System.out.println("7. Çıkış");
                    System.out.print("Seçiminizi girin: ");
                    int librarianChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (librarianChoice) {
                        case 1:
                            System.out.print("Kitap ID: ");
                            int bookId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Yazar ID (rakam): ");
                            int authorId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Kitap Başlığı: ");
                            String title = scanner.nextLine();
                            System.out.print("Kitap Kategorisi (NOVEL, FANTASY, ROMANCE): ");
                            Category category = Category.valueOf(scanner.nextLine());
                            Book newBook = new Book(bookId, authors.get(authorId), title, Status.AVAILABLE, category);
                            library.addBook(newBook);
                            break;
                        case 2:
                            // Kitap silme
                            System.out.print("Kitap ID: ");
                            int book_id = scanner.nextInt();
                            scanner.nextLine();
                            library.deleteBook(book_id);
                            break;
                        case 3:
                            // Kitap bilgisi güncelleme
                            System.out.print(" Güncellemek istediğiniz kitap ID: ");
                            int book_Id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print(" Yeni Yazar ID (rakam): ");
                            int author_Id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Yeni Kitap Başlığı: ");
                            String titlee = scanner.nextLine();
                            System.out.print(" Yeni Kitap Kategorisi (NOVEL, FANTASY, ROMANCE): ");
                            Category categori = Category.valueOf(scanner.nextLine());
                            Book newBook1 = new Book(book_Id, authors.get(author_Id), titlee, Status.AVAILABLE, categori);
                            library.updateBook(book_Id,newBook1);
                            break;
                        case 4:
                            System.out.print("Üye ID (rakam): ");
                            int memberId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Kitap ID: ");
                            int book_ID = scanner.nextInt();
                            scanner.nextLine();

                            Member member = members.get(memberId);
                            Book book = libraryBooks.get(book_ID);
                            System.out.println(member.getName());
                            System.out.println(book.getTitle());


                            librarian.issueBook(member, book);
                            break;

                        case 5:
                            System.out.print("Yazar adı: ");
                            String authorName = scanner.nextLine();
                            System.out.print("Yazar id: ");
                            int authorID = scanner.nextInt();
                            Author newAuthor = new Author(authorName, authorID);
                            if(!authors.containsKey(authorID)) {
                                authors.put(newAuthor.getAuthorId(), newAuthor);
                            } else {
                                System.out.println("Bu id kullanılamaz");
                            }
                            System.out.println(authors.get(newAuthor.getAuthorId()));
                            break;
                        case 6:
                            System.out.println("1. Kategoriye Göre Kitaplara Bak");
                            System.out.println("2. Yazarına Göre Kitaplara Bak");
                            System.out.println("3. Tüm Kitaplara Bak");
                            System.out.print("Seçiminizi girin: ");
                            int subChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (subChoice == 1) {
                                System.out.println("Kategoriler: ");
                                for (Category kategori : Category.values()) {
                                    System.out.println(kategori);
                                }
                                System.out.print("Bir kategori seçin: ");
                                String categoryChoice = scanner.nextLine();
                                Category selectedCategory = Category.valueOf(categoryChoice.toUpperCase());
                                library.getBooksByCategory(selectedCategory);
                            } else if (subChoice == 2) {
                                System.out.println("Yazarlar: ");
                                for (Map.Entry<Integer, Author> entry : authors.entrySet()) {
                                    System.out.println(entry.getKey() + ". " + entry.getValue().getName());
                                }
                                System.out.print("Bir yazar seçin (rakam): ");
                                int selectedAuthorIndex = scanner.nextInt();
                                scanner.nextLine();

                                Author selectedAuthor = authors.get(selectedAuthorIndex);
                                if (selectedAuthor != null) {
                                    library.getBooksByAuthor(selectedAuthor);
                                } else {
                                    System.out.println("Geçersiz yazar seçimi.");
                                }
                            } else if (subChoice == 3) {
                                library.printBooks();
                            }
                            break;
                        case 7:
                            System.out.println("Çıkış yapılıyor...");
                            continueRunning = false;

                    }
                } else {
                    System.out.println("Geçersiz kullanıcı adı veya şifre.");

                }
                System.out.print("Devam mı?? (evet/hayır): ");
                String continueChoice = scanner.nextLine();

                if (continueChoice.equalsIgnoreCase("hayır")) {
                    System.out.println("Kapatılıyor........");
                    continueRunning = false;
                }
            }
        }


    } }
