package IntermediateEvaluation;

public interface IToyView extends ToyShop.IView {

    /**
     * Метод очистки консоли терминала
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    void showPrizeToy(Toy toy);

    void showDialog();
}

