package Lesson10.Seminar.Homework;

public class UserManagementApp {
    public static void main(String[] args) {
        // Создание экземпляров Model, View и Presenter
        UserDataModel model = new UserDataModel("TestName", "TestUserName", "TestPassword");
        UserDataView view = new UserDataView();
        UserDataPresenter presenter = new UserDataPresenter(model, view);

        presenter.clearScreen();
        // Установка связи между Model, View и Presenter
        // (например, передача ссылки на Model и View в конструктор Presenter)

        // Пример выполнения операции регистрации
        presenter.registerUser();

        // Пример выполнения операции входа
        presenter.loginUser();

        // Пример выполнения операции изменения пароля
        presenter.changePassword();

        //Отображаем всех пользователей
        presenter.showAllUsers();
    }
}
