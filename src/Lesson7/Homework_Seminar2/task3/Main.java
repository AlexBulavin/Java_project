package Lesson7.Homework_Seminar2.task3;

public class Main implements I_Const{
    public static void main(String[] args) {
        Library library = new Library();

        Book[] books = {book1, book2, book3, book4, book5};

        for (Book book : books) {
            library.addBook(book);
        }

        library.displayAvailableBooks();

        book1.borrow();
        book2.borrow();

        library.displayAvailableBooks();
        Book temp_book = book2;
        library.removeBook(book2);
        System.out.println("Удаление книги: " + temp_book.getTitle() + " " + temp_book.getAuthor());
        
        library.displayAvailableBooks();

        library.searchByAuthor("Михаил Булгаков");
    }

    /**
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
