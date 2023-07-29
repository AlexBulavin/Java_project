package IntermediateEvaluation;

public class Main {
    public static void main(String[] args) {
        IToyModel model = new ToyModelImpl();
        IToyPresenter presenter = new ToyPresenterImpl(model);
        //Очищаем экран
        clearScreen();

        // Добавляем игрушки
        presenter.addNewToy(1, "Doll", 10, 30);
        presenter.addNewToy(2, "Car", 15, 20);
        presenter.addNewToy(3, "Puzzle", 20, 10);

        // Моделируем розыгрыш
        presenter.performRaffle();

        // Получаем призовую игрушку и выводим информацию
        Toy prizeToy = presenter.getPrizeToy();
        if (prizeToy != null) {
            System.out.println("Поздравляю! Вы выиграли " + prizeToy.getName() + ".");
        } else {
            System.out.println("Не расстраивайтесь, в этот раз Вы не выиграли. Приходите с этим же чеком и участвуйте в следующем розыгрыше.");
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

