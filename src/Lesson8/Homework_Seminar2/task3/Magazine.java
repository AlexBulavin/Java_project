package Lesson8.Homework_Seminar2.task3;

public class Magazine extends AbstractBook implements I_Displayable, I_Borrowable, I_Searchable, I_Reservable, I_Updatable {
    String MAGAZINE_WORD = "Журнал '";
    private String title;
    private String author;
    private boolean available;
   
    public String getTitle(){
        return title;
    };

    public void setTitle(){
        this.title = title;

    };

    public String getAuthor(){
        return author;
    };

    public void setAuthor(){
        this.author = author;
    };

    public boolean isAvailable(){
        return available;
    };

    public void setAvailable(boolean available) {
        this.available = available;
    };

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
            System.out.println(MAGAZINE_WORD + title + "' успешно взят в аренду.");
        } else {
            System.out.println(MAGAZINE_WORD + title + "' недоступен для аренды.");
        }
    }

    @Override
    public void returnBook() {
        if (!available) {
            available = true;
            System.out.println(MAGAZINE_WORD + title + "' успешно возвращен.");
        } else {
            System.out.println(MAGAZINE_WORD + title + "' уже доступен.");
        }
    }

    @Override
    public boolean search(String keyword) {
        return title.contains(keyword) || author.contains(keyword);
    }

    @Override
    public void reserve() {
        System.out.println("Резервирование журнала '" + title + "'.");
        // Реализация резервирования журнала
    }

    @Override
    public void cancelReservation() {
        System.out.println("Отмена резервирования журнала '" + title + "'.");
        // Реализация отмены резервирования журнала
    }

    @Override
    public void updateInfo(String title, String author) {
        this.title = title;
        this.author = author;
        System.out.println("Информация о журнале обновлена: " + title + " (" + author + ")");
    }

    // @Override
    // void setTitle() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'setTitle'");
    // }

    // @Override
    // void setAuthor() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'setAuthor'");
    // }

    @Override
    void setAvailable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAvailable'");
    }
}
