package Lesson11.Homework.Task5_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserDataModel implements I_UserDataModel {
    private String name;
    private String username;
    private String password;

    public UserDataModel(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    //Геттеры и сеттеры для name, username и password

    @Override
    public void saveData(String userData) {
        try (FileWriter writer = new FileWriter("users.csv")) {
            writer.write(userData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
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
