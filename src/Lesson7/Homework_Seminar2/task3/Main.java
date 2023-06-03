package Lesson7.Homework_Seminar2.task3;

import java.lang.reflect.Field;

public class Main implements I_Const_Extended {

    public static void main(String[] args) {
        Library library = new Library();
        clearScreen();
        System.out.println("\n\n\n*************************** Our Java Library ******************************\n\n\n");
        Book[] books = new Book[21];

        Class<I_Const_Extended> constExtendedClass = I_Const_Extended.class;
        Field[] fields = constExtendedClass.getFields();

        for (int i = 0; i < fields.length; i++) {
            try {
                books[i] = (Book) fields[i].get(null);
                if (books[i].getAuthor() == "Ytbpdtcnty")
                    books[i].setAuthor("Авторство неизвестно");//Почему-то ошибка в таком коде books[i].getAuthorUnknown());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

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
