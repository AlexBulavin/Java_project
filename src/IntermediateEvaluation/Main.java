package IntermediateEvaluation;

public class Main {
    public static void main(String[] args) {
        IToyModel model = new ToyModelImpl();
        IToyPresenter presenter = new ToyPresenterImpl(model);

        // Добавляем игрушки
        presenter.addNewToy(1, "Doll", 10, 30);
        presenter.addNewToy(2, "Car", 15, 20);
        presenter.addNewToy(3, "Puzzle", 20, 10);

        // Моделируем розыгрыш
        presenter.performRaffle();

        // Получаем призовую игрушку и выводим информацию
        Toy prizeToy = presenter.getPrizeToy();
        if (prizeToy != null) {
            System.out.println("Congratulations! You won a " + prizeToy.getName() + ".");
        } else {
            System.out.println("No prize available.");
        }
    }
}

