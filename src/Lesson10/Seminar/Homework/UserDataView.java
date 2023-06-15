package Lesson10.Seminar.Homework;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserDataView {
    private Scanner scanner;

    public UserDataView() {
        scanner = new Scanner(System.in);
    }

    // Отображение формы регистрации
    public String showRegistrationForm() {
        System.out.println("=== Регистрация ===");

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
        System.out.println("Введенные данные: " + userData);
        return userData;
    }

    // Отображение формы входа
    public String showLoginForm() {
        System.out.println("=== Вход ===");

        System.out.print("Введите логин: ");
        String username = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        // Возвращаем введенные пользователем данные
        String userData = username + "," + password;
        System.out.println("Введенные данные: " + userData);
        return userData;
    }

    // Отображение формы изменения пароля
    public String showChangePasswordForm() {
        System.out.println("=== Изменение пароля ===");

        System.out.print("Введите текущий пароль: ");
        String currentPassword = scanner.nextLine();

        System.out.print("Введите новый пароль: ");
        String newPassword = scanner.nextLine();

        // Возвращаем введенные пользователем данные
        String passwordData = currentPassword + "," + newPassword;
        System.out.println("Введенные данные: " + passwordData);
        return passwordData;
    }

    public void showAllUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.csv"))) {
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
    /**
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
