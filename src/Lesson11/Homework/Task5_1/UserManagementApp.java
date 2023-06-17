package Lesson11.Homework.Task5_1;

public class UserManagementApp {
    public static void main(String[] args) {
        I_UserDataView view = new UserDataView();
        I_UserDataModel model = new UserDataModel("TestName", "TestUserName", "TestPassword");
        UserDataPresenter presenter = new UserDataPresenter(model, view);

        presenter.clearScreen();
        presenter.registerUser();
        presenter.loginUser();
        presenter.changePassword();
        presenter.showAllUsers();
    }
}
