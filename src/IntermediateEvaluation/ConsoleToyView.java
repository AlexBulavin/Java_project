package IntermediateEvaluation;

import java.util.List;
import java.util.Scanner;

public class ConsoleToyView implements IToyView {
    private Scanner scanner;

    public ConsoleToyView() {
        scanner = new Scanner(System.in);
    }
    
    @Override
    public void showCongratulationsMessage(String toyName) {
        System.out.println("Поздравляю, вы выиграли " + toyName + ".");
    }

    @Override
    public void showSorryMessage() {
        System.out.println(
                "К сожалению в этот раз не повезло с призом. Приходите ещё, с этим же или новыми чеками о покупке товара, и, возможно, Вы выиграете главный приз - автомобиль.");
    }

    @Override
    public void showPrizeToysList(List<Toy> prizeToys) {
        if (prizeToys.isEmpty()) {
            System.out.println("Список призовых игрушек пуст.");
        } else {
            System.out.println("Список призовых игрушек:");
            for (Toy toy : prizeToys) {
                System.out.println(toy.getName() + " (Количество: " + toy.getQuantity() + ")");
            }
        }
    }

    @Override
    public void showMainMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Участвовать в розыгрыше");
        System.out.println("2. Вывести список имеющихся призов");
        System.out.println("3. Вывести список состоявшихся розыгрышей");
        System.out.println("0. Выход");
    }

    @Override
    public int getUserChoice() {
        return scanner.nextInt();
    }

    @Override
    public void showRaffleResults(List<RaffleResult> raffleResults) {
        if (raffleResults.isEmpty()) {
            System.out.println("Список состоявшихся розыгрышей пуст.");
        } else {
            System.out.println("Список состоявшихся розыгрышей:");
            for (RaffleResult result : raffleResults) {
                System.out.println("Дата и время: " + result.getDateTime());
                System.out.println("Название приза: " + result.getPrizeName());
                System.out.println("Номер чека победителя: " + result.getReceiptNumber());
                System.out.println();
            }
        }
    }

    // Метод для закрытия Scanner
    @Override
    public void closeScanner() {
        scanner.close();
    }

}
