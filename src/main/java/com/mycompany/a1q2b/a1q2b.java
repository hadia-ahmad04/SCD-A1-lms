package com.mycompany.a1q2b;

//package com.mycompany.a1q2b;

import java.io.*;
  
import java.util.*;

import java.util.Scanner;

 
abstract class Item {
    protected int id;
    protected String title;

    

    public Item(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public abstract String toString();
}


class Book extends Item {

//    private int id;
//
//    private String title;

    private String author;

    public Book(int id, String title, String a) {

//        id = ID;
//
//        title = t;
        super(id,title);
        author = a;

    }

//    public int getId() {
//
//        return id;
//
//    }
//
// 
//
//    public String getTitle() {
//
//        return title;
//
//    }

 

    public String getAuthor() {

        return author;

    }

 

//    public void setTitle(String title) {
//
//        this.title = title;
//
//    }

 

    public void setAuthor(String author) {

        this.author = author;

    }

 

    @Override

    public String toString() {

        return "Book [ID=" + id + ", Title=" + title + ", Author=" + author + "]";

    }

}
class Magazine extends Item {
    private List<String> authors;
    private String publisher;
    private String publicationDate;

    public Magazine(int id, String title, List<String> authors, String publisher, String publicationDate) {
        super(id, title);
        this.authors = authors;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return "Magazine [ID=" + getId() + ", Title=" + getTitle() + ", Authors=" + authors + ", Publisher=" + publisher + ", Date=" + publicationDate + "]";
    }
}

class Newspaper extends Item {
    private String publisherCompany;
    private String publicationDate;

    public Newspaper(int id, String title, String publisherCompany, String publicationDate) {
        super(id, title);
        this.publisherCompany = publisherCompany;
        this.publicationDate = publicationDate;
    }

    public String getPublisherCompany() {
        return publisherCompany;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return "Newspaper [ID=" + getId() + ", Title=" + getTitle() + ", Publisher Company=" + publisherCompany + ", Date=" + publicationDate + "]";
    }
}

 

class Library {

//    private List<Book> books;
      private List<Item> items;
 

    public Library() {

        this.items = new ArrayList<>();

    }

    public void addItem(Item item)
    {
        items.add(item);
    }

//    public void addBook(Book book) {
//
//        books.add(book);
//
//    }
     public Item getItemById(int id) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
     
     public List<Item> getAllItems() {
        return items;
    }

     
     public boolean deleteItem(int id) {
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
     
     public void displayItem(Item item) {
        System.out.println(item);
    }
}

 

//    public void editBook(int id, String title, String author) {
//
//       for (int i = 0; i < books.size(); i++) {
//
//            Book book = books.get(i);
//
//            if (book.getId() == id) {
//
//                book.setTitle(title);
//
//                book.setAuthor(author);
//
//                return;
//
//            }
//
//        }
//
//        System.out.println("Book with ID " + id + " not found.");
//
//    }

 

//    public void deleteBook(int id) {
//
//        Iterator<Book> iterator = books.iterator();
//
//        while (iterator.hasNext()) {
//
//            Book book = iterator.next();
//
//            if (book.getId() == id) {
//
//                iterator.remove();
//
//                return;
//
//            }
//
//        }
//
//        System.out.println("Book with ID " + id + " not found.");
//
//    }

 

//    public Book getBookById(int id) {
//
//        for (int i = 0; i < books.size(); i++) {
//
//            Book book = books.get(i);
//
//            if (book.getId() == id) {
//
//                return book;
//
//            }
//
//        }
//
//        return null;
//
//    }
//
// 
//
//    public List<Book> getAllBooks() {
//
//        return books;
//
//    }

 

//    public void loadBooksFromFile(String fileName) {
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//
//                String[] parts = line.split(",");
//
//                if (parts.length >= 3) {
//
//                    int id = Integer.parseInt(parts[0].trim());
//
//                    String title = parts[1].trim();
//
//                    String author = parts[2].trim();
//
// 
//
//                    Book book = new Book(id, title, author);
//
//                    addBook(book);
//
//                }
//
//            }
//
//            System.out.println("Books loaded successfully from " + fileName);
//
//        } catch (IOException e) {
//
//            System.err.println("Error loading books from file: " + e.getMessage());
//
//        }
//
//    }
//
//}

 

public class a1q2b {

    public static void main(String[] args) {

        Library library = new Library();
//        library.loadBooksFromFile("data.txt");

        Scanner scanner = new Scanner(System.in);

 

        while (true) {

            System.out.println("Library Management System Menu:");

            System.out.println("1. Add a book");

            System.out.println("2. Edit a book by ID");

            System.out.println("3. Delete a book by ID");

            System.out.println("4. View all books");

            System.out.println("5. View a book by ID");

            System.out.println("6. Load books from a file");

            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

 

            int choice = scanner.nextInt();

            scanner.nextLine();

 

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");

                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Enter Book Title: ");

                    String title = scanner.nextLine();

                    System.out.println("Enter Book Author: ");

                    String author = scanner.nextLine();

 

                    Item newItem = new Book(id, title, author);

                    library.addItem(newItem);

                    System.out.println("Item added successfully.");

                    break;

                case 2:

                    System.out.print("Enter Book ID to edit: ");

                    int editId = scanner.nextInt();

                    scanner.nextLine();

                    Item editItem = library.getItemById(editId);

                    if (editItem != null) {

                        System.out.print("Enter new Book Title: ");

                        String newTitle = scanner.nextLine();

                        System.out.print("Enter new Book Author: ");

                        String newAuthor = scanner.nextLine();

//                        library.editBook(editId, newTitle, newAuthor);

                        System.out.println("Book edited successfully.");

                    } else {

                        System.out.println("Book with ID " + editId + " not found.");

                    }

                    break;

                case 3:

                    System.out.print("Enter Book ID to delete: ");

                    int deleteId = scanner.nextInt();

                    scanner.nextLine();

//                    Book bookToDelete = library.deleteItem(deleteId);
                     boolean deleteItem=library.deleteItem(deleteId);

                    if (deleteItem) {

//                        library.deleteBook(deleteId);
                         library.deleteItem(deleteId);

                        System.out.println("Book deleted successfully.");

                    } else {

                        System.out.println("Book with ID " + deleteId + " not found.");

                    }

                    break;

                case 4:
                    System.out.println("Book Details:");
//                    for (Book bookToView : library.getAllBooks()) 
                    for (Item viewItem : library.getAllItems()) 
                    {
                        System.out.println(viewItem);  
                    } 

                    break;

                case 5:

                    System.out.print("Enter Book ID to view: ");

                    int viewId = scanner.nextInt();

                    scanner.nextLine();

 

//                    Book bookToView = library.getBookById(viewId);
                    Item IdView = library.getItemById(viewId);

                    if (IdView != null) {

                        System.out.println("Book Details:");

                        System.out.println(IdView);

                    } else {

                        System.out.println("Book with ID " + viewId + " not found.");

                    }

                    break;

                case 6:

                    System.out.print("Enter the file name to load books from: ");

                    String fileName = scanner.nextLine();

//                    library.loadBooksFromFile(fileName);
                    

                    break;

                case 7:

                    System.out.println("Exiting Library Management System. Goodbye!");

                    scanner.close();

                    System.exit(0);

                default:

                    System.out.println("Invalid choice. Please enter a valid option.");

            }

        }

    }

}
