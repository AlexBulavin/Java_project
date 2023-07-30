package IntermediateEvaluation;

import java.util.List;

public interface IToyPresenter {
    void addNewToy(int id, String name, int quantity, double weight);
    void updateToyWeight(int id, double weight);
    void performRaffle();
    Toy getPrizeToy();
    List<Toy> getPrizeToys();
}



