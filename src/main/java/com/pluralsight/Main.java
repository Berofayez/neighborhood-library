package com.pluralsight;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner userInput = new Scanner(System.in);

    static Book[] books = {
            new Book(1,"123","The 7 habits for highly effective people", false, ""),
            new Book(2,"123","The Atomic habits", false, ""),
            new Book(3,"123","Mindset", false, ""),
            new Book(4,"123","Think bigger", false, ""),
            new Book(5,"123","The Four Agreements", false, ""),
            new Book(6,"123","The Missing README ", false, ""),
            new Book(7,"123","Grit", false, ""),
            new Book(8,"123","Peak", false, ""),
            new Book(9,"123","Bounce", false, ""),
            new Book(10,"123","Can’t Hurt Me", false, ""),
            new Book(11,"123","The Mountain Is You", false, ""),
            new Book(12,"123","Clean Code", false, ""),
            new Book(13,"123","The Pragmatic Programmer", false, ""),
            new Book(14,"123","Soft skills", false, ""),
            new Book(15,"123","Start with Why", false, ""),
            new Book(16,"123","Deep Work", false, ""),
            new Book(17,"123","Tiny Habits", false, ""),
            new Book(18,"123","The Power of Habit", false, ""),
            new Book(19,"123","Outliers", false, ""),
            new Book(20,"123","Range", true, "")

    };

    static void main() {
        mainScreen();



    }

    static void mainScreen(){
        System.out.println("""
                Welcome to our library
                select an option:
                1) Show Available Books
                2) Show Checked Out Books
                3) Exit - closes out of the application
                """);
        String selectedOption = userInput.nextLine();

        switch (selectedOption){
            case "1":
                showAvailableBooks(books);
                break;
            case "2":
                showCheckedOutBooks(books);
                break;
            case "3":
                break;
        }


    }

     static void showAvailableBooks(Book[] books) {
        for(Book book : books){
            if(!book.isCheckedOut()) {
                System.out.println("Book id is " + book.getId() + ", book ISBN is " + book.getIsbn() + ", book title is " + book.getTitle());
            }
        }
        System.out.println("""
                select an option:
                    1) check out a book
                    3) Exit - go back to main screen
                """);
        String selectedOption = userInput.nextLine();
         switch (selectedOption){
             case "1":
                 System.out.println("enter the book id for check out");
                 int bookId = userInput.nextInt();
                 userInput.nextLine();
                 System.out.println("enter your name");
                 String name = userInput.nextLine();

                 for (Book book : books){
                     if(book.getId() == bookId){
                         book.checkOut(name);
                     }
                 }

                 break;
             case "2":
                 mainScreen();
         }
    }
    static void showCheckedOutBooks(Book[] books){
        for(Book book : books){
            if(book.isCheckedOut()) {
                System.out.println("Book id is " + book.getId() + ", book ISBN is " + book.getIsbn() + ", book title is " + book.getTitle() + " name " + book.getCheckedOutTo()
                );
            }
        }
        System.out.println("""
                select an option:
                    C) check in a book
                    X) Exit - go back to main screen
                """);
        String selectedOption = userInput.nextLine();
        switch (selectedOption){
            case "C":
                System.out.println("enter the id");
                int bookId = userInput.nextInt();
                checkInBook(books, bookId);
                break;
            case "X":
                mainScreen();
        }
    }

    static void checkInBook(Book[] books, int id){
        for (Book book : books){
            if(book.getId() == id){
                book.checkIn();
            }
        }
        mainScreen();

    }
}
