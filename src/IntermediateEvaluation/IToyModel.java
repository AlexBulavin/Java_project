package IntermediateEvaluation;

import java.util.List;

public interface IToyModel {
    void addToy(int id, String name, int quantity, double weight);
    void updateToyWeight(int id, double weight);
    List<Toy> getToys();
    List<Toy> getPrizeToys();
    void removePrizeToy(Toy toy);
}


