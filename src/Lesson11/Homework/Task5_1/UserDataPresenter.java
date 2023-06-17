package Lesson11.Homework.Task5_1;

public class UserDataPresenter {
    private I_UserDataModel model;
    private I_UserDataView view;

    public UserDataPresenter(I_UserDataModel model, I_UserDataView view) {
        this.model = model;
        this.view = view;
    }

    public void registerUser() {
        String userData = view.showRegistrationForm();
        model.saveData(userData);
    }

    public void loginUser() {
        String userData = view.showLoginForm();
        String[] dataParts = userData.split(",");
        String name = dataParts[0];
        String password = dataParts[1];
        model.loadData(name, password);
    }

    public void changePassword() {
        String userData = view.showChangePasswordForm();
        model.saveData(userData);
    }

    public void showAllUsers() {
        view.showAllUsers();
    }

    public void clearScreen() {
        view.clearScreen();
    }
}
