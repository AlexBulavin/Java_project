package Lesson7.Homework_Seminar2.task3;

interface Displayable {
    void displayInfo();
}

interface Borrowable {
    void borrow();
    void returnBook();
}

interface Searchable {
    boolean search(String keyword);
}

interface Reservable {
    void reserve();
    void cancelReservation();
}

interface Updatable {
    void updateInfo(String title, String author);
}

public class Book implements Displayable, Borrowable, Searchable, Reservable, Updatable {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public void displayInfo() {
        System.out.println("Название: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Доступность: " + (available ? "Да" : "Нет"));
    }

    
    public void displayInfo(Boolean author) {
        System.out.println("Название: " + title);
        System.out.println("Доступность: " + (available ? "Да" : "Нет"));
    }

    @Override
    public void borrow() {
        if (available) {
            available = false;
            System.out.println("Книга '" + title + "' успешно взята в аренду.");
        } else {
            System.out.println("Книга '" + title + "' недоступна для аренды.");
        }
    }

    @Override
    public void returnBook() {
        if (!available) {
            available = true;
            System.out.println("Книга '" + title + "' успешно возвращена.");
        } else {
            System.out.println("Книга '" + title + "' уже доступна.");
        }
    }

    @Override
    public boolean search(String keyword) {
        return title.contains(keyword) || author.contains(keyword);
    }

    @Override
    public void reserve() {
        System.out.println("Резервирование книги '" + title + "'.");
        // Реализация резервирования книги
    }

    @Override
    public void cancelReservation() {
        System.out.println("Отмена резервирования книги '" + title + "'.");
        // Реализация отмены резервирования книги
    }

    @Override
    public void updateInfo(String title, String author) {
        this.title = title;
        this.author = author;
        System.out.println("Информация о книге обновлена: " + title + " (" + author + ")");
    }
}