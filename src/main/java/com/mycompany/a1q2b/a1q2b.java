//package com.mycompany.a1q2b;

import java.io.*;
  
import java.util.*;

import java.util.Scanner;

interface Configuration {
    void displayInfo();
    double calculateCost();   //pt g
}

 
abstract class Item implements Configuration {
    protected int id;
    protected String title;
    protected int pCount;

    

    public Item(int id, String title) {
        this.id = id;
        this.title = title;
        this.pCount=0;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public abstract String toString();
    
    @Override
    public void displayInfo() {
        System.out.println("Item Info: ID: " + id + ", Title: " + title);
    }

    public int getPopularityCount() {
        return pCount;
    }

    public void incrementPopularityCount() {
        pCount++;
    }

}

class ItemComparator implements Comparator<Item>{
    @Override
    public int compare(Item item1,Item item2){
        if(item1.pCount==item2.pCount)
            return 0;
        else if(item1.pCount>item2.pCount)
            return -1;
        else
            return 1;
    }
}

class Book extends Item {

//    private int id;

//    private String title;

    private String author;
    private double cost;

    public Book(int id, String title, String a) {

//        id = ID;
//
//        title = t;
        super(id,title);
        author = a;

    }

    public int getId() {

        return id;

    }
//
// 
//
    public String getTitle() {

        return title;

    }

 

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

        return "Book [ID:" + id + ", Title:" + title + ", Author:" + author + "]";

    }
    
    @Override
    public void displayInfo() {
        System.out.println("Book Info: /n ID: " + id + ", Title: " + title + ", Author: " + author);
    }
    
    
    @Override
    public double calculateCost() {
        double cost = getCost();  
        double gst = 0.2 * cost;
        double publisherCharges = 200.0; 
        return cost + gst + publisherCharges;
    }
    
    private double getCost() {
        return cost;
    }

}



class Magazine extends Item {
    private List<String> authors;
    private String publisher;
    private String publicationDate;
    private double cost;

    public Magazine(int id, String title, List<String> authors, String publisher, String pDate) {
        super(id, title);
        this.authors = authors;
        this.publisher = publisher;
        publicationDate = pDate;
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
        return "Magazine [ID:" + getId() + ", Title:" + getTitle() + ", Authors:" + authors + ", Publisher:" + publisher + ", Date:" + publicationDate + "]";
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Magazine Info: /n ID: " + id + ", Title: " + title + ", Authors: " + authors + ", Publisher: " + publisher + ", Date: " + publicationDate);
    }
    
    @Override
    public double calculateCost() {
        double cost = getCost() * getPopularityCount();
        return cost;
    }
    
     private double getCost() {
        return cost;
    }
}

class Newspaper extends Item {
    private String pubComp;
    private String publicationDate;
    private double cost;

    public Newspaper(int id, String title, String pCompany, String pDate) {
        super(id, title);
        pubComp = pCompany;
        publicationDate = pDate;
    }

    public String getPublisherCompany() {
        return pubComp;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return "Newspaper [ID:" + getId() + ", Title:" + getTitle() + ", Publisher Company:" + pubComp + ", Date=" + publicationDate + "]";
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Newspaper Info: /n ID: " + id + ", Title: " + title + ", Publisher Company: " + pubComp + ", Date: " + publicationDate);
    }
    
    public double calculateCost() {
        double cost = 10 + 5 + (getCost() * getPopularityCount());
        return cost;
    }

    private double getCost() {
        return cost;
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
     public void displayItemDetails(Item item) {
        if (item != null) {
            System.out.println("Item Details:");
            System.out.println(item);
        } else {
            System.out.println("Item not found.");
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
                    items.add(book);



           }}

           System.out.println("Books loaded successfully from " + fileName);

       } catch (IOException e) {

           System.err.println("Error loading books from file: " + e.getMessage());

       }

   }

}

 class Borrower {
    private int id;
    private List<Item> bItems;
    private String name;

    public Borrower(int id) {
        this.id = id;
        this.bItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Item> getBorrwedI() {
        return bItems;
    }

    public void borrowItem(Item item) {
        if (!bItems.contains(item)) {
            bItems.add(item);
            item.incrementPopularityCount();
        }
    }

    public void returnItem(Item item) {
        bItems.remove(item);
    }
    
    public double calculateTotalBorrowingCost() {
        double totalCost = 0.0;
        for (int i = 0; i < bItems.size(); i++) {
            Item item = bItems.get(i);
            totalCost += item.calculateCost();
        }
        return totalCost;
    }
}

public class a1q2b {

    public static void main(String[] args) {

        Library library = new Library();
        List<Borrower> borrowers = new ArrayList<>();
        library.loadBooksFromFile("data.txt");

        Scanner scanner = new Scanner(System.in);

 

        while (true) {

            System.out.println("Library Management System Menu:");

//            System.out.println("1. Add a book");
//
//            System.out.println("2. Edit a book by ID");
//
//            System.out.println("3. Delete a book by ID");
//
//            System.out.println("4. View all books");
//
//            System.out.println("5. View a book by ID");
//
//            System.out.println("6. Load books from a file");
//            
//            System.out.println("7. Borrow a book");
//            
//            System.out.println("8. Return a book");
//            
//            System.out.println("9. View Hot Picks");
//            
//            System.out.println("10. View Borrowers and Borrowed Items");
//
//            System.out.println("11. Exit");

              System.out.println("1. Hot Picks!");
              System.out.println("2. Borrow an item");
              System.out.println("3. Add Item");
              System.out.println("4. Edit Item");
              System.out.println("5. Delete Item");
              System.out.println("6. View All Items");
              System.out.println("7. View Item by ID");
              System.out.println("8. View Borrowers List");
              System.out.println("9. Exit");

            System.out.print("Enter your choice: ");

 

            int choice = scanner.nextInt();

            scanner.nextLine();

 

            switch (choice) {

                case 1:

//                    System.out.print("Enter Book ID: ");
//
//                    int id = scanner.nextInt();
//
//                    scanner.nextLine();
//
//                    System.out.println("Enter Book Title: ");
//
//                    String title = scanner.nextLine();
//
//                    System.out.println("Enter Book Author: ");
//
//                    String author = scanner.nextLine();
//
// 
//
//                    Item newItem = new Book(id, title, author);
//
//                    library.addItem(newItem);
//
//                    System.out.println("Item added successfully.");
//
//                    break;
                System.out.println("Hot Picks:");

                List<Item> hotPicks = new ArrayList<>(library.getAllItems());
                hotPicks.sort(new ItemComparator());

                
                for (int i = 0; i < hotPicks.size(); i++) {
                    Item hotPick = hotPicks.get(i);
                    hotPick.displayInfo(); 
                    System.out.println("Popularity Count: " + hotPick.getPopularityCount());
                    System.out.println();
                }
                break;
                
                
                case 2:

                    System.out.print("Enter Borrower ID: ");
                    
                int borrowerId = scanner.nextInt();
                scanner.nextLine(); 
                Borrower borrower = null;

                for (int i = 0; i < borrowers.size(); i++) {
                    var b = borrowers.get(i);
                    if (b.getId() == borrowerId) {
                        borrower = b;
                        break;
                    }
                }
                
                
                if (borrower == null) {
                    borrower = new Borrower(borrowerId);
                    borrowers.add(borrower);
                }

                System.out.print("Enter Item ID to borrow: ");
                
                
                int borrowItemId = scanner.nextInt();
                scanner.nextLine(); 
                Item borrowItem = library.getItemById(borrowItemId);

                if (borrowItem != null) {
                    borrower.borrowItem(borrowItem);
                    System.out.println("Item borrowed successfully.");
                } else {
                    System.out.println("Item with ID " + borrowItemId + " not found.");
                }
                break;

                case 3:

//                    System.out.print("Enter Book ID to delete: ");
//
//                    int deleteId = scanner.nextInt();
//
//                    scanner.nextLine();
//
////                    Book bookToDelete = library.deleteItem(deleteId);
//                     boolean deleteItem=library.deleteItem(deleteId);
//
//                    if (deleteItem) {
//
////                        library.deleteBook(deleteId);
//                         library.deleteItem(deleteId);
//
//                        System.out.println("Book deleted successfully.");
//
//                    } else {
//
//                        System.out.println("Book with ID " + deleteId + " not found.");
//
//                    }
//
//                    break;
                    
                    System.out.print("Enter Book ID: ");

                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Enter Item's Title: ");

                    String title = scanner.nextLine();

                    System.out.println("Enter Author: ");

                    String author = scanner.nextLine();

 

                    Item newItem = new Book(id, title, author);

                    library.addItem(newItem);

                    System.out.println("Item added successfully.");

                    break;
                    

                case 4:
//                    System.out.println("Book Details:");
//                    for (Item viewItem : library.getAllItems()) 
//                    {
//                        System.out.println(viewItem);  
//                    } 
//
//                    break;
                    
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

                case 5:

//                    System.out.print("Enter Book ID to view: ");
//
//                    int viewId = scanner.nextInt();
//
//                    scanner.nextLine();
//
// 
//
////                    Book bookToView = library.getBookById(viewId);
//                    Item IdView = library.getItemById(viewId);
//
//                    if (IdView != null) {
//
//                        System.out.println("Book Details:");
//
//                        System.out.println(IdView);
//
//                    } else {
//
//                        System.out.println("Book with ID " + viewId + " not found.");
//
//                    }
//
//                    break;

                    System.out.print("Enter Book ID to delete: ");

                    int deleteId = scanner.nextInt();

                    scanner.nextLine();

//                    Book bookToDelete = library.deleteItem(deleteId);
                     boolean deleteItem=library.deleteItem(deleteId);

                    if (deleteItem) {

//                        library.deleteBook(deleteId);
                         library.deleteItem(deleteId);

                        System.out.println("Item deleted successfully.");

                    } else {

                        System.out.println("Item with ID " + deleteId + " not found.");

                    }

                    break;

                case 6:

//                    System.out.print("Enter the file name to load books from: ");
//
//                    String fileName = scanner.nextLine();
//
//                    library.loadBooksFromFile(fileName);
                    

//                    break;
                    
                    System.out.println("Book Details:");
                    
                    
                List<Item> items = library.getAllItems();    
                for (int i = 0; i < items.size(); i++) {
                Item viewItem = items.get(i);
                    System.out.println(viewItem);
                }
                break;
                
                
                case 7:
                    
//                    System.out.print("Enter Borrower ID: ");
//                    int borrowerId = scanner.nextInt();
//                    scanner.nextLine();
//                    Borrower borrower = null;
//
//                    for (var b : borrowers) {
//                        if (b.getId() == borrowerId) {
//                            borrower = b;
//                            break;
//                        }
//                    }
//                    if (borrower == null) {
//                        borrower = new Borrower(borrowerId);
//                        borrowers.add(borrower);
//                    }
//
//                    System.out.print("Enter Item ID to borrow: ");
//                    int borrowItemId = scanner.nextInt();
//                    scanner.nextLine();
//                    Item borrowItem = library.getItemById(borrowItemId);
//
//                    if (borrowItem != null) {
//                        borrower.borrowItem(borrowItem);
//                        System.out.println("Item borrowed successfully.");
//                    } else {
//                        System.out.println("Item with ID " + borrowItemId + " not found.");
//                    }
//                    break;
                    
                    
                System.out.print("Enter Item ID to view: ");
                int viewId = scanner.nextInt();
                scanner.nextLine();

                Item viewItem = library.getItemById(viewId);
                library.displayItemDetails(viewItem); 
                break;

                case 8:
//                    System.out.print("Enter Borrower ID: ");
//                    int returnBorrowerId = scanner.nextInt();
//                    scanner.nextLine();
//
//                    System.out.print("Enter Item ID to return: ");
//                    int returnItemId = scanner.nextInt();
//                    scanner.nextLine();
//                    Item returnItem = library.getItemById(returnItemId);
//
//                    for (Borrower b : borrowers) {
//                        if (b.getId() == returnBorrowerId) {
//                            b.returnItem(returnItem);
//                            System.out.println("Item returned successfully.");
//                            break;
//                        }
//                    }
//                    break;
                    
                    System.out.println("Borrowers and Borrowed Items:");
                    for (int i = 0; i < borrowers.size(); i++) {
                        
                        Borrower b = borrowers.get(i);
                        System.out.println("Borrower ID: " + b.getId());
                        
                        List<Item> bItems = b.getBorrwedI();
                        if (bItems.isEmpty()) {
                            System.out.println("No items borrowed.");
                        } else {
                            System.out.println("Borrowed Items:");
                            for (Item borrowedItem : bItems) {
                                System.out.println(borrowedItem);
                            }
                        }
                        System.out.println();
                    }
                    break;

                    
                //case 9: 
//    // Hot Picks: Sort items by popularity count and display them
//                  System.out.println("Hot Picks (Sorted by Popularity Count):");
//    
//    // Sort the items by popularity count in descending order
//                  List<Item> hotPicks = new ArrayList<>(library.getAllItems());
//                  hotPicks.sort((item1, item2) -> Integer.compare(item2.getPopularityCount(), item1.getPopularityCount()));
//    
//    // Display the sorted items
//                  for (Item hotPick : hotPicks) {
//                      hotPick.displayInfo(); // Display item info using the Configuration interface
//                      System.out.println("Popularity Count: " + hotPick.getPopularityCount());
//                      System.out.println();
//    }
//    break;

                    
//                case 10:   
//                    System.out.println("Borrowers and Borrowed Items:");
//                    for (Borrower b : borrowers) {
//                        System.out.println("Borrower ID: " + b.getId());
//                        List<Item> bItems = b.getBorrwedI();
//                        if (bItems.isEmpty()) {
//                            System.out.println("No items borrowed.");
//                        } else {
//                            System.out.println("Borrowed Items:");
//                            for (Item borrowedItem : bItems) {
//                                System.out.println(borrowedItem);
//                            }
//                        }
//                        System.out.println();
//                    }
//                    break;
                    
                    
                case 9:

                    System.out.println("Exiting Library Management System");

                    scanner.close();

                    System.exit(0);

                default:

                    System.out.println("Invalid choice. Please enter a valid option.");

            }

        }
    }
}