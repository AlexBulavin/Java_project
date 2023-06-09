package Lesson8.Homework_Seminar2.task3;

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

    public ArrayList<Book> getCatalog(){
        return catalog;
    }

    public void displayAvailableBooks() {
        System.out.println("Доступные книги в библиотеке:");
        int catalog_size = catalog.size();;
        int counter = 1;
        for (Book book : catalog) {
            if (book.isAvailable()) {
                System.out.print(counter + " / " + catalog_size + " ");
                book.displayInfo();
                System.out.println("-------------------------");
            }
            counter++;
        }
    }

    public void searchByAuthor(String author) {
        System.out.println("Поиск книг автора '" + author + "':");
        for (Book book : catalog) {
            if (book.getAuthor().equals(author)) {
                book.displayInfo(false);
                System.out.println("-------------------------");
            }
        }
    }
}
