package IntermediateEvaluation;

public class ConsoleToyView implements IToyView {
    @Override
    public void showCongratulationsMessage(String toyName) {
        System.out.println("Поздравляю, вы выиграли " + toyName + ".");
    }

    @Override
    public void showSorryMessage() {
        System.out.println("К сожалению в этот раз не повезло с призом. Приходите ещё, с этим же или новыми чеками о покупке товара, и, возможно, Вы выиграете главный приз - автомобиль.");
    }
}

