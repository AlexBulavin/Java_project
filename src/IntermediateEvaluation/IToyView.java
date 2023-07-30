package IntermediateEvaluation;

import java.util.List;

public interface IToyView {
    void showSorryMessage();
    void showCongratulationsMessage(String toyName);
    void showPrizeToysList(List<Toy> prizeToys);
    void showRaffleResults(List<RaffleResult> raffleResults);
    int getUserChoice();
    void showMainMenu();
    void closeScanner();
}



