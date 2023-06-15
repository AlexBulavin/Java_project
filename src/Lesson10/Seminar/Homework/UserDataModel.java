package Lesson10.Seminar.Homework;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class UserDataModel {
    private String name;
    private String username;
    private String password;

    // Конструктор и геттеры/сеттеры для полей name, username и password
    public UserDataModel(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Методы для сохранения и загрузки данных пользователя
    public void saveData(String userData) {
        try (FileWriter writer = new FileWriter("users.csv")) {
            // Записываем данные пользователя в формате CSV
            writer.write(userData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData(String name, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3 && values[0].equals(name) && values[2].equals(password)) {
                    setName(values[0]);
                    setUsername(values[1]);
                    setPassword(values[2]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
