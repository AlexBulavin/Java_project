package IntermediateEvaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop implements IToyModel, IToyPresenter {

    private List<Toy> toys;
    private List<Toy> prizeToys;
    private IToyView view;

    public ToyShop(IToyView view) {
        this.toys = new ArrayList<>();
        this.prizeToys = new ArrayList<>();
        this.view = view;
    }

    // Реализация методов интерфейса IToyModel
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
    public List<Toy> getToys() {
        return toys;
    }

    @Override
    public void removePrizeToy(Toy toy) {
        prizeToys.remove(toy);
    }

    // Реализация методов интерфейса IToyPresenter
    @Override
    public void performRaffle() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();

        Random random = new Random();
        double randomWeight = random.nextDouble() * totalWeight;

        for (Toy toy : toys) {
            randomWeight -= toy.getWeight();
            if (randomWeight <= 0) {
                prizeToys.add(toy);
                toy.setWeight(0); // Убираем игрушку из розыгрыша
                break;
            }
        }

        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.get(prizeToys.size() - 1);
            view.showCongratulationsMessage(prizeToy.getName());
        } else {
            view.showSorryMessage();
        }
    
    }

    @Override
    public Toy getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            return prizeToys.get(prizeToys.size() - 1); // Возвращаем последнюю призовую игрушку из списка
        }
        return null; // Возвращаем null, если список призовых игрушек пустой
    }

    @Override
    public List<Toy> getPrizeToys() {
        return prizeToys;
    }

    @Override
    public void addNewToy(int id, String name, int quantity, double weight) {
        toys.add(new Toy(id, name, quantity, weight));
    }
}


