package Lesson7.Homework_Seminar2.task3;

public interface I_Const_Extended extends I_Const {

    Book book6 = new Book("Михайловский замок", "Фёдор Сологуб");
    Book book7 = new Book("Белая гвардия", "Михаил Булгаков");
    Book book8 = new Book("Анна Каренина", "Лев Толстой");
    Book book9 = new Book("Мёртвые души", "Николай Гоголь");
    Book book10 = new Book("Братья Карамазовы", "Фёдор Достоевский");
    Book book11 = new Book("Герой нашего времени", "Михаил Лермонтов");
    Book book12 = new Book("Евгений Онегин", "Александр Пушкин");
    Book book13 = new Book("Война и мир", "Лев Толстой");
    Book book14 = new Book("Золотой телёнок", "Илья Ильф и Евгений Петров");
    Book book15 = new Book("Мастер и Маргарита", "Михаил Булгаков");
    Book book16 = new Book("Преступление и наказание", "Фёдор Достоевский");
    Book book17 = new Book("Тихий Дон", "Михаил Шолохов");
    Book book18 = new Book("Собачье сердце", "Михаил Булгаков");
    Book book19 = new Book("Доктор Живаго", "Борис Пастернак");
    Book book20 = new Book("Мы", "Евгений Замятин");
    Book book21 = new Book("Сказки", "Ytbpdtcnty");

    default String getAuthorUnknown() {
        return "Авторство неизвестно";
    }
}
