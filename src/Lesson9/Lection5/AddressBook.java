package Lesson9.Lection5;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public AddressBook() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.println("Введите имя контакта:");
        String name = scanner.nextLine();

        System.out.println("Введите номер телефона контакта:");
        String phoneNumber = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber);
        contacts.add(contact);

        System.out.println("Контакт успешно добавлен.");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Записная книжка пуста.");
        } else {
            System.out.println("Список контактов:");
            for (Contact contact : contacts) {
                System.out.println("Имя: " + contact.getName());
                System.out.println("Номер телефона: " + contact.getPhoneNumber());
                System.out.println("-----------------------");
            }
        }
    }

    public void deleteContact() {
        if (contacts.isEmpty()) {
            System.out.println("Записная книжка пуста.");
        } else {
            System.out.println("Введите имя контакта для удаления:");
            String name = scanner.nextLine();

            Contact foundContact = null;
            for (Contact contact : contacts) {
                if (contact.getName().equalsIgnoreCase(name)) {
                    foundContact = contact;
                    break;
                }
            }

            if (foundContact != null) {
                contacts.remove(foundContact);
                System.out.println("Контакт успешно удален.");
            } else {
                System.out.println("Контакт не найден.");
            }
        }
    }

    public void updateContact() {
        if (contacts.isEmpty()) {
            System.out.println("Записная книжка пуста.");
        } else {
            System.out.println("Введите имя контакта для обновления:");
            String name = scanner.nextLine();

            Contact foundContact = null;
            for (Contact contact : contacts) {
                if (contact.getName().equalsIgnoreCase(name)) {
                    foundContact = contact;
                    break;
                }
            }

            if (foundContact != null) {
                System.out.println("Введите новое имя контакта:");
                String newName = scanner.nextLine();

                System.out.println("Введите новый номер телефона контакта:");
                String newPhoneNumber = scanner.nextLine();

                foundContact.updateContact(newName, newPhoneNumber);
                System.out.println("Контакт успешно обновлен.");
            } else {
                System.out.println("Контакт не найден.");
            }
        }
    }

    public void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Создать контакт");
        System.out.println("2. Просмотреть контакты");
        System.out.println("3. Удалить контакт");
        System.out.println("4. Обновить контакт");
        System.out.println("5. Выйти");
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            displayMenu();

            System.out.println("Выберите опцию:");
            int option = scanner.nextInt();
            scanner.nextLine(); // Считываем перевод строки после ввода числа

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверная опция. Попробуйте еще раз.");
                    break;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.run();
    }
}