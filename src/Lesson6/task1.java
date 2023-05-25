package Lesson6;

import java.util.*;
import java.awt.Toolkit;

public class task1 {
    public static void main(String[] args) {
        clearScreen();
        Set<Notebook> notebooks = createNotebooks();

        Map<Integer, Object> filterCriteria = getFilterCriteria();
        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filterCriteria);
        int consoleWidth = getConsoleWidth();
            String text = "Подходящие ноутбуки";
            // Расчет количества пробелов перед текстом
            int spacesCount = (consoleWidth - text.length()) / 2;

            // Форматирование строки с пробелами
            String formattedText = formatTextWithSpaces(text, spacesCount);

            // Вывод центрированного текста
            System.out.println();
            System.out.println(ConsoleColors.BLUE_BACKGROUND + formattedText + ConsoleColors.RESET + "\n");
        int string_counter = 1;
        for (Notebook notebook : filteredNotebooks) {

            System.out.println(string_counter % 2 == 0 ? ConsoleColors.WHITE_BACKGROUND + ConsoleColors.BLACK + notebook + ConsoleColors.RESET : notebook);
        }
    }

    // Метод очистки консоли терминала
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Создание множества ноутбуков
    private static Set<Notebook> createNotebooks() {
        Set<Notebook> notebooks = new HashSet<>();

        notebooks.add(new Notebook(4, 128, "Windows 7", "Black", "HP", 15.6, "HDD"));
        notebooks.add(new Notebook(16, 1024, "Windows 10", "Silver", "Dell", 13.3, "SSD"));
        notebooks.add(new Notebook(8, 256, "Ubuntu 20.04", "Red", "Lenovo", 14.0, "M.2"));
        notebooks.add(new Notebook(16, 512, "Windows 10", "White", "ASUS", 17.3, "SSD"));
        notebooks.add(new Notebook(32, 1024, "macOS Monterey v2.16.5", "Black", "Apple", 16.0, "M.2"));
        notebooks.add(new Notebook(8, 512, "Windows 10", "Black", "HP", 15.6, "HDD"));
        notebooks.add(new Notebook(16, 1024, "Windows 11", "Silver", "Dell", 13.3, "SSD"));
        notebooks.add(new Notebook(4, 256, "Ubuntu 18", "Red", "Lenovo", 14.0, "M.2"));
        notebooks.add(new Notebook(16, 512, "Windows 10", "White", "ASUS", 17.3, "SSD"));
        notebooks.add(new Notebook(8, 512, "macOS Monterey v2.16.5", "Black", "Apple", 16.0, "SSD"));
        notebooks.add(new Notebook(32, 256, "Windows 11", "Gray", "Acer", 15.6, "SSD"));
        notebooks.add(new Notebook(16, 512, "Ubuntu 21.04", "Silver", "Lenovo", 13.3, "HDD"));
        notebooks.add(new Notebook(8, 512, "macOS Big Sur", "Space Gray", "Apple", 13.3, "SSD"));
        notebooks.add(new Notebook(16, 1024, "Windows 10", "Black", "HP", 15.6, "SSD"));
        notebooks.add(new Notebook(64, 256, "Ubuntu 20.04", "Blue", "Dell", 14.0, "M.2"));
        notebooks.add(new Notebook(16, 512, "Windows 11", "Silver", "ASUS", 17.3, "SSD"));
        notebooks.add(new Notebook(8, 512, "macOS Monterey v2.16.5", "Gold", "Apple", 16.0, "HDD"));
        notebooks.add(new Notebook(8, 256, "Windows 10", "Black", "Lenovo", 15.6, "SSD"));
        notebooks.add(new Notebook(16, 512, "Ubuntu 21.04", "Gray", "Acer", 14.0, "HDD"));
        notebooks.add(new Notebook(4, 512, "macOS Big Sur", "Silver", "Apple", 13.3, "SSD"));
        notebooks.add(new Notebook(16, 1024, "Windows 10", "Red", "HP", 15.6, "SSD"));
        notebooks.add(new Notebook(8, 256, "Ubuntu 20.04", "Black", "Dell", 14.0, "SSD"));
        notebooks.add(new Notebook(32, 512, "Windows 11", "Blue", "ASUS", 17.3, "SSD"));
        notebooks.add(new Notebook(8, 512, "macOS Monterey v2.16.5", "Silver", "Apple", 16.0, "HDD"));
        notebooks.add(new Notebook(64, 256, "Windows 10", "White", "Lenovo", 15.6, "SSD"));

        return notebooks;
    }

    // Получение критериев фильтрации от пользователя
    private static Map<Integer, Object> getFilterCriteria() {
        try (Scanner scanner = new Scanner(System.in)) {
            Map<Integer, Object> filterCriteria = new HashMap<>();
            // Получение ширины окна вывода
            int consoleWidth = getConsoleWidth();
            String text = "МИР НОУТБУКОВ";
            // Расчет количества пробелов перед текстом
            int spacesCount = (consoleWidth - text.length()) / 2;

            // Форматирование строки с пробелами
            String formattedText = formatTextWithSpaces(text, spacesCount);

            // Вывод центрированного текста
            System.out.println();
            System.out.println(ConsoleColors.BLUE_BACKGROUND + formattedText + ConsoleColors.RESET + "\n");
            System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                    "1 - ОЗУ\n" +
                    "2 - Объем ЖД\n" +
                    "3 - Операционная система\n" +
                    "4 - Цвет\n" +
                    "5 - Бренд\n" +
                    "6 - Размер экрана\n" +
                    "7 - тип ЖД\n");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем символ новой строки после считывания числа

            Object filterValue = "";
            switch (choice) {
                case 1:
                    System.out.println("Выберите требуемый объем ОЗУ:\n" +
                            "1 - 4ГБ\n" +
                            "2 - 8ГБ\n" +
                            "3 - 16ГБ\n" +
                            "4 - 32ГБ\n" +
                            "5 - 64ГБ\n");
                    int ram_choice = scanner.nextInt();
                    scanner.nextLine(); // Считываем символ новой строки после считывания числа
                    switch (ram_choice) {
                        case 1:
                            filterValue = 4;
                            break;
                        case 2:
                            filterValue = 8;
                            break;
                        case 3:
                            filterValue = 16;
                            break;
                        case 4:
                            filterValue = 32;
                            break;
                        case 5:
                            filterValue = 64;
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Выберите требуемый объем жесткого диска:" +
                            "1 - 128ГБ\n" +
                            "2 - 256ГБ\n" +
                            "3 - 512ГБ\n" +
                            "4 - 1024ГБ\n");
                    int hdd_choice = scanner.nextInt();
                    scanner.nextLine(); // Считываем символ новой строки после считывания числа
                    switch (hdd_choice) {
                        case 1:
                            filterValue = 128;
                            break;
                        case 2:
                            filterValue = 256;
                            break;
                        case 3:
                            filterValue = 512;
                            break;
                        case 4:
                            filterValue = 1024;
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Выберите операционную систему:" +
                            "1 - Windows 7\n" +
                            "2 - Windows 8\n" +
                            "3 - Windows 10\n" +
                            "4 - Windows 11\n" +
                            "5 - Ubuntu 20.04\n" +
                            "6 - Ubuntu 18\n" +
                            "8 - macOS Big Sur\n" +
                            "9 - macOS Monterey v2.16.5\n");
                    int os_choice = scanner.nextInt();
                    scanner.nextLine(); // Считываем символ новой строки после считывания числа
                    switch (os_choice) {
                        case 1:
                            filterValue = "Windows 7";
                            break;
                        case 2:
                            filterValue = "Windows 8";
                            break;
                        case 3:
                            filterValue = "Windows 10";
                            break;
                        case 4:
                            filterValue = "Windows 11";
                            break;
                        case 5:
                            filterValue = "Ubuntu 20.04";
                            break;
                        case 6:
                            filterValue = "Ubuntu 18";
                            break;
                        case 7:
                            filterValue = "macOS Big Sur";
                            break;
                        case 8:
                            filterValue = "macOS Monterey v2.16.5";
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Выберите цвет:" +
                            "1 - Black" +
                            "2 - Silver" +
                            "3 - Red" +
                            "4 - Grey" +
                            "5 - Space Grey" +
                            "6 - White" +
                            "7 - Blue" +
                            "8 - Gold");
                    int color_choice = scanner.nextInt();
                    scanner.nextLine(); // Считываем символ новой строки после считывания числа
                    switch (color_choice) {
                        case 1:
                            filterValue = "Black";
                            break;
                        case 2:
                            filterValue = "Silver";
                            break;
                        case 3:
                            filterValue = "Red";
                            break;
                        case 4:
                            filterValue = "Grey";
                            break;
                        case 5:
                            filterValue = "Space Grey";
                            break;
                        case 6:
                            filterValue = "White";
                            break;
                        case 7:
                            filterValue = "Blue";
                            break;
                        case 8:
                            filterValue = "Gold";
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Выберите бренд:" +
                            "1 - HP" +
                            "2 - DELL" +
                            "3 - Lenovo" +
                            "4 - Apple" +
                            "5 - Aser " +
                            "6 - ASUS");
                    int vendor_choice = scanner.nextInt();
                    scanner.nextLine(); // Считываем символ новой строки после считывания числа
                    switch (vendor_choice) {
                        case 1:
                            filterValue = "HP";
                            break;
                        case 2:
                            filterValue = "DELL";
                            break;
                        case 3:
                            filterValue = "Lenovo";
                            break;
                        case 4:
                            filterValue = "Apple";
                            break;
                        case 5:
                            filterValue = "Aser";
                            break;
                        case 6:
                            filterValue = "ASUS";
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Выберите размер экрана:" +
                            "1 - 13,3" +
                            "2 - 14,0" +
                            "3 - 15,6" +
                            "4 - 16,0" +
                            "5 - 17,3");
                    int screen_choice = scanner.nextInt();
                    scanner.nextLine(); // Считываем символ новой строки после считывания числа
                    switch (screen_choice) {
                        case 1:
                            filterValue = "13,3";
                            break;
                        case 2:
                            filterValue = "14,0";
                            break;
                        case 3:
                            filterValue = "15,6";
                            break;
                        case 4:
                            filterValue = "16,0";
                            break;
                        case 5:
                            filterValue = "17,3";
                            break;
                    }
                    break;
                case 7:
                    System.out.println("Выберите тип жёсткого диска:" +
                            "1 - HDD" +
                            "2 - SSD" +
                            "3 - M.2");
                    int disk_choice = scanner.nextInt();
                    scanner.nextLine(); // Считываем символ новой строки после считывания числа
                    switch (disk_choice) {
                        case 1:
                            filterValue = "HDD";
                            break;
                        case 2:
                            filterValue = "SSD";
                            break;
                        case 3:
                            filterValue = "M.2";
                            break;
                    }
                    break;
                default: {
                    System.out.println("Некорректный выбор критерия. Фильтрация не будет применена.");
                    return filterCriteria;
                }
            }
            filterCriteria.put(choice, filterValue);
            return filterCriteria;
        }
    }

    // Фильтрация ноутбуков на основе заданных критериев
    private static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<Integer, Object> filterCriteria) {
        Set<Notebook> filteredNotebooks = new HashSet<>();

        for (Notebook notebook : notebooks) {
            boolean meetsCriteria = false;

            for (Map.Entry<Integer, Object> entry : filterCriteria.entrySet()) {
                int choice = entry.getKey();
                Object filterValue = entry.getValue();

                switch (choice) {
                    case 1:
                        int ram = notebook.getRam();
                        if (ram == (int) filterValue) {
                            meetsCriteria = true;
                        }
                        break;
                    case 2:
                        int storage = notebook.getStorage();
                        if (storage == (int) filterValue) {
                            meetsCriteria = true;
                        }
                        break;
                    case 3:
                        String operatingSystem = notebook.getOperatingSystem();
                        if (operatingSystem.equalsIgnoreCase((String) filterValue)) {
                            meetsCriteria = true;
                        }
                        break;
                    case 4:
                        String color = notebook.getColor();
                        if (color.equalsIgnoreCase((String) filterValue)) {
                            meetsCriteria = false;
                        }
                        break;
                    case 5:
                        String brand = notebook.getBrand();
                        if (brand.equalsIgnoreCase((String) filterValue)) {
                            meetsCriteria = true;
                        }
                        break;
                    case 6:
                        Double screen_size = notebook.getScreenSize();
                        if (screen_size == filterValue) {
                            meetsCriteria = true;
                        }
                        break;
                    case 7:
                        String drive_type = notebook.getHardDriveType();
                        if (drive_type.equalsIgnoreCase((String) filterValue)) {
                            meetsCriteria = true;
                        }
                        break;
                    /*
                     * "1 - ОЗУ\n" +
                     * "2 - Объем ЖД\n" +
                     * "3 - Операционная система\n" +
                     * "4 - Цвет\n" +
                     * "5 - Бренд\n" +
                     * "6 - Размер экрана\n" +
                     * "7 - тип ЖД");
                     */
                    default:
                        meetsCriteria = false;
                        break;
                }
                if (!meetsCriteria) {
                    break; // Если ноутбук не соответствует хотя бы одному критерию, прекращаем проверку
                }
            }
            if (meetsCriteria) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;
    }

    public class ConsoleColors {
        // Цвета текста
        public static final String RESET = "\u001B[0m";
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String MAGENTA = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";

        // Цвета фона
        public static final String BLACK_BACKGROUND = "\u001B[40m";
        public static final String RED_BACKGROUND = "\u001B[41m";
        public static final String GREEN_BACKGROUND = "\u001B[42m";
        public static final String YELLOW_BACKGROUND = "\u001B[43m";
        public static final String BLUE_BACKGROUND = "\u001B[44m";
        public static final String MAGENTA_BACKGROUND = "\u001B[45m";
        public static final String CYAN_BACKGROUND = "\u001B[46m";
        public static final String WHITE_BACKGROUND = "\u001B[47m";
    }

    // Метод для получения ширины окна вывода
    private static int getConsoleWidth() {
        return Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    // Метод для форматирования текста с пробелами перед ним
    private static String formatTextWithSpaces(String text, int spacesCount) {
        StringBuilder formattedText = new StringBuilder();

        for (int i = 0; i < spacesCount; i++) {
            formattedText.append(" ");
        }

        formattedText.append(text);

        return formattedText.toString();
    }
}
