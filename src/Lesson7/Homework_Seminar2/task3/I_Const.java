package Lesson7.Homework_Seminar2.task3;

public interface I_Const {
    Book book1 = new Book("Мастер и Маргарита", "Михаил Булгаков");
    Book book2 = new Book("Преступление и наказание", "Фёдор Достоевский");
    Book book3 = new Book("Война и мир", "Лев Толстой");
    Book book4 = new Book("Анна Каренина", "Лев Толстой");
    Book book5 = new Book("1984", "Джордж Оруэлл");

    default String getAuthorUnknown(){
        return "Не известен";
    }
}
