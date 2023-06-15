package Lesson10.Seminar.Homework;

public class UserDataPresenter {
    private UserDataModel model;
    private UserDataView view;

    public UserDataPresenter(UserDataModel model, UserDataView view) {
        this.model = model;
        this.view = view;
    }

    public void registerUser() {
        String userData = view.showRegistrationForm();
        // Обработка введенных данных и вызов соответствующих методов модели
        // для выполнения операции регистрации
        // ...
        model.saveData(userData); // Сохранение данных пользователя
    }

    public void loginUser() {
        String userData = view.showLoginForm();
        // Обработка введенных данных и вызов соответствующих методов модели
        // для выполнения операции входа
        // ...
        
        // Извлечение имени и пароля
        String[] dataParts = userData.split(",");
        String name = dataParts[0];
        String password = dataParts[1];
        model.loadData(name, password); // Загрузка данных пользователя
    }

    public void changePassword() {
        String userData = view.showChangePasswordForm();
         
        // Обработка введенных данных и вызов соответствующих методов модели
        // для выполнения операции изменения пароля
        // ...
        model.saveData(userData); // Сохранение данных пользователя
    }

    public void showAllUsers(){
        view.showAllUsers();
    }

    public void clearScreen(){
        view.clearScreen();
    }
}

