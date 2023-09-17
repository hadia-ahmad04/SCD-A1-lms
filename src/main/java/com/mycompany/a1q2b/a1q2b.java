/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.a1q2b;

import java.io.*;
  
import java.util.*;

import java.util.Scanner;

 

class Book {

    private int id;

    private String title;

    private String author;

 

    public Book(int ID, String t, String a) {

        id = ID;

        title = t;

        author = a;

    }

    public int getId() {

        return id;

    }

 

    public String getTitle() {

        return title;

    }

 

    public String getAuthor() {

        return author;

    }

 

    public void setTitle(String title) {

        this.title = title;

    }

 

    public void setAuthor(String author) {

        this.author = author;

    }

 

    @Override

    public String toString() {

        return "Book [ID=" + id + ", Title=" + title + ", Author=" + author + "]";

    }

}

 

class Library {

    private List<Book> books;

 

    public Library() {

        this.books = new ArrayList<>();

    }

 

    public void addBook(Book book) {

        books.add(book);

    }

 

    public void editBook(int id, String title, String author) {

       for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            if (book.getId() == id) {

                book.setTitle(title);

                book.setAuthor(author);

                return;

            }

        }

        System.out.println("Book with ID " + id + " not found.");

    }

 

    public void deleteBook(int id) {

        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {

            Book book = iterator.next();

            if (book.getId() == id) {

                iterator.remove();

                return;

            }

        }

        System.out.println("Book with ID " + id + " not found.");

    }

 

    public Book getBookById(int id) {

        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            if (book.getId() == id) {

                return book;

            }

        }

        return null;

    }

 

    public List<Book> getAllBooks() {

        return books;

    }

 

    public void loadBooksFromFile(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length >= 3) {

                    int id = Integer.parseInt(parts[0].trim());

                    String title = parts[1].trim();

                    String author = parts[2].trim();

 

                    Book book = new Book(id, title, author);

                    addBook(book);

                }

            }

            System.out.println("Books loaded successfully from " + fileName);

        } catch (IOException e) {

            System.err.println("Error loading books from file: " + e.getMessage());

        }

    }

}

 

public class a1q2b {

    public static void main(String[] args) {

        Library library = new Library();
        library.loadBooksFromFile("data.txt");

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

 

                    Book newBook = new Book(id, title, author);

                    library.addBook(newBook);

                    System.out.println("Book added successfully.");

                    break;

                case 2:

                    System.out.print("Enter Book ID to edit: ");

                    int editId = scanner.nextInt();

                    scanner.nextLine();

                    Book bookToEdit = library.getBookById(editId);

                    if (bookToEdit != null) {

                        System.out.print("Enter new Book Title: ");

                        String newTitle = scanner.nextLine();

                        System.out.print("Enter new Book Author: ");

                        String newAuthor = scanner.nextLine();

                        library.editBook(editId, newTitle, newAuthor);

                        System.out.println("Book edited successfully.");

                    } else {

                        System.out.println("Book with ID " + editId + " not found.");

                    }

                    break;

                case 3:

                    System.out.print("Enter Book ID to delete: ");

                    int deleteId = scanner.nextInt();

                    scanner.nextLine();

                    Book bookToDelete = library.getBookById(deleteId);

                    if (bookToDelete != null) {

                        library.deleteBook(deleteId);

                        System.out.println("Book deleted successfully.");

                    } else {

                        System.out.println("Book with ID " + deleteId + " not found.");

                    }

                    break;

                case 4:
                    System.out.println("Book Details:");
                    for (Book bookToView : library.getAllBooks()) 
                    {
                        System.out.println(bookToView);  
                    } 

                    break;

                case 5:

                    System.out.print("Enter Book ID to view: ");

                    int viewId = scanner.nextInt();

                    scanner.nextLine();

 

                    Book bookToView = library.getBookById(viewId);

                    if (bookToView != null) {

                        System.out.println("Book Details:");

                        System.out.println(bookToView);

                    } else {

                        System.out.println("Book with ID " + viewId + " not found.");

                    }

                    break;

                case 6:

                    System.out.print("Enter the file name to load books from: ");

                    String fileName = scanner.nextLine();

                    library.loadBooksFromFile(fileName);

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