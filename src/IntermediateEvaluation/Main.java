package IntermediateEvaluation;

public class Main {
    public static void main(String[] args) {
        IToyModel model = new ToyModelImpl();
        IToyView view = new ConsoleToyView();
        ToyPresenterImpl presenter = new ToyPresenterImpl(model, view);

        // Очищаем экран
        clearScreen();

        // Добавляем игрушки
        presenter.addNewToy(1, "Куклу", 10, 30);
        presenter.addNewToy(2, "Машину", 15, 20);
        presenter.addNewToy(3, "Паззл", 20, 10);

        // Моделируем розыгрыш
        presenter.performRaffle();

        // Записываем призовую игрушку в файл
        presenter.writePrizeToyToFile("prize_toy.txt");

    }

    /**
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
