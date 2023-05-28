package Lesson6.Homework_Seminar1.task3;

public class Main {
    public static void main(String[] args) {
        Lesson6.task1.clearScreen();

        Library library = new Library();

        Book book1 = new Book("Название книги 1", "Автор 1");
        Book book2 = new Book("Название книги 2", "Автор 2");
        Book book3 = new Book("Название книги 3", "Автор 1");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayAvailableBooks();

        System.out.println("Удаление книги:");
        library.removeBook(book2);
        library.displayAvailableBooks();

        System.out.println("Поиск книг автора 'Автор 1':");
        library.searchByAuthor("Автор 1");

        System.out.println();
    }
}
