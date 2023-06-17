package Lesson11.Homework.Task5_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserDataView implements I_UserDataView {
    private Scanner scanner;

    public UserDataView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String showRegistrationForm() {
        System.out.println("=== Регистрация ===");
        // Ввод и проверка пользовательских данных
        String name = "";
        while (true) {
            System.out.print("Введите имя (только буквы): ");
            name = scanner.nextLine();
            if (name.matches("[a-zA-Z]+")) {
                break; // Выходим из цикла, если имя состоит только из букв
            } else {
                System.out.println("Некорректное имя. Введите только буквы.");
            }
        }
        System.out.print("Введите логин: ");
        String username = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        // Возвращаем введенные пользователем данные
        String userData = name + "," + username + "," + password;
        System.out.println("Введенные пользовательские данные: " + userData);
        return userData;

    }

    @Override
    public String showLoginForm() {
        System.out.println("=== Вход ===");
        // Ввод и проверка пользовательских данных
        System.out.print("Введите логин: ");
        String username = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        // Возвращаем введенные пользователем данные
        String userData = username + "," + password;
        System.out.println("Введенные логин и пароль: " + userData);
        return userData;
    }

    @Override
    public String showChangePasswordForm() {
        System.out.println("=== Изменение пароля ===");
        // Ввод и проверка пользовательских данных
        System.out.print("Введите текущий пароль: ");
        String currentPassword = scanner.nextLine();

        System.out.print("Введите новый пароль: ");
        String newPassword = scanner.nextLine();

        // Возвращаем введенные пользователем данные
        String passwordData = currentPassword + "," + newPassword;
        System.out.println("Введенные данные: " + passwordData);
        return passwordData;
    }

    @Override
    public void showAllUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.csv"))) {
            // Read and display all users
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    String name = values[0];
                    String username = values[1];
                    String password = values[2];

                    System.out.println("Name: " + name);
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
