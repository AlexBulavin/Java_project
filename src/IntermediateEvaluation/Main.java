package IntermediateEvaluation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IToyModel model = new ToyModelImpl();
        IToyView view = new ConsoleToyView();
        ToyPresenterImpl presenter = new ToyPresenterImpl(model, view);

        // Очищаем экран
        clearScreen();

        // Читаем данные из файла с исходными игрушками и добавляем их в призовые
        // игрушки, если файл не пустой
        if (!checkSourceToysFileIsEmpty()) {
            try (BufferedReader reader = new BufferedReader(new FileReader("source_toys.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int quantity = Integer.parseInt(data[2].trim());
                    double weight = Double.parseDouble(data[3].trim());
                    presenter.addNewToy(id, name, quantity, weight);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Если файл пустой, добавляем пять разных игрушек с русскоязычными названиями и
            // склонениями
            presenter.addNewToy(1, "Куклу", 10, 30);
            presenter.addNewToy(2, "Машину", 15, 20);
            presenter.addNewToy(3, "Паззл", 20, 10);
            presenter.addNewToy(4, "Мяч", 5, 25);
            presenter.addNewToy(5, "Конструктор", 8, 15);
        }

        // Scanner scanner = new Scanner(System.in);
        while (true) {
            view.showMainMenu(); // Отображаем главное меню
            int choice = view.getUserChoice(); // Получаем выбор пользователя
            
            switch (choice) {
                case 1:
                    // Моделируем розыгрыш
                    presenter.performRaffle();
                    // Записываем призовую игрушку в файл
                    presenter.writePrizeToyToFile("prize_toy.txt");
                    break;
                case 2:
                    // Выводим список имеющихся призов
                    List<Toy> prizeToys = presenter.getPrizeToys();
                    showPrizeToysList(prizeToys);
                    break;
                case 3:
                    // Выводим список состоявшихся розыгрышей
                    List<RaffleResult> raffleResults = presenter.getRaffleResults();
                    view.showRaffleResults(raffleResults);
                    break;
                case 0:
                    // Выход из программы
                    view.closeScanner(); // Закрываем Scanner
                    System.out.println("Выход из программы. До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }

    }

    private static void showPrizeToysList(List<Toy> prizeToys) {
        if (prizeToys.isEmpty()) {
            System.out.println("Список призовых игрушек пуст.");
        } else {
            System.out.println("Список призовых игрушек:");
            for (Toy toy : prizeToys) {
                System.out.println(toy.getName() + " (Количество: " + toy.getQuantity() + ")");
            }
        }
    }

    /**
     * * Метод для проверки, пустой ли файл source_toys.txt
     */
    private static boolean checkSourceToysFileIsEmpty() {
        try (BufferedReader reader = new BufferedReader(new FileReader("source_toys.txt"))) {
            return reader.readLine() == null;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
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
