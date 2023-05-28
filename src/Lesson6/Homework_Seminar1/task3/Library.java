package Lesson6.Homework_Seminar1.task3;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> catalog;

    public Library() {
        catalog = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        catalog.add(book);
    }

    public void removeBook(Book book) {
        catalog.remove(book);
    }

    public void displayAvailableBooks() {
        System.out.println("Доступные книги в библиотеке:");
        for (Book book : catalog) {
            if (book.isAvailable()) {
                book.displayInfo();
                System.out.println("-------------------------");
            }
        }
    }

    public void searchByAuthor(String author) {
        System.out.println("Книги автора " + author + ":");
        for (Book book : catalog) {
            if (book.getAuthor().equals(author)) {
                book.displayInfo();
                System.out.println("-------------------------");
            }
        }
    }
}
