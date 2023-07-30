package IntermediateEvaluation;

import java.util.ArrayList;
import java.util.List;

public class ToyModelImpl implements IToyModel {
    private List<Toy> toys;
    private List<Toy> prizeToys;
    private List<RaffleResult> raffleResults; // Add this list for storing raffle results

    public ToyModelImpl() {
        this.toys = new ArrayList<>();
        this.prizeToys = new ArrayList<>();
        this.raffleResults = new ArrayList<>();
    }

    @Override
    public void addToy(int id, String name, int quantity, double weight) {
        toys.add(new Toy(id, name, quantity, weight));
    }

    @Override
    public void updateToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    @Override
    public List<RaffleResult> getRaffleResults() {
        return raffleResults;
    }

    @Override
    public List<Toy> getToys() {
        return toys;
    }

    @Override
    public List<Toy> getPrizeToys() {
        return prizeToys;
    }

    @Override
    public void removePrizeToy(Toy toy) {
        prizeToys.remove(toy);
    }

    private void addRaffleResult(boolean won, String prizeName) {
        RaffleResult raffleResult = new RaffleResult(won, null, prizeName, 0);
        raffleResults.add(raffleResult);
    }
}
