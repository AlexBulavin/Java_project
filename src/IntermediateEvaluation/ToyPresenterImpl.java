package IntermediateEvaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyPresenterImpl implements IToyPresenter {
    private IToyModel model;
    private List<Toy> prizeToys;

    public ToyPresenterImpl(IToyModel model) {
        this.model = model;
        this.prizeToys = new ArrayList<>();
    }

    @Override
    public void addNewToy(int id, String name, int quantity, double weight) {
        model.addToy(id, name, quantity, weight);
    }

    @Override
    public void updateToyWeight(int id, double weight) {
        model.updateToyWeight(id, weight);
    }

    @Override
    public void performRaffle() {
        List<Toy> toys = model.getToys();
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();

        Random random = new Random();
        double randomWeight = random.nextDouble() * totalWeight;

        for (Toy toy : toys) {
            randomWeight -= toy.getWeight();
            if (randomWeight <= 0) {
                prizeToys.add(toy);
                model.updateToyWeight(toy.getId(), 0); // Убираем игрушку из розыгрыша
                break;
            }
        }
    }

    @Override
    public Toy getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.remove(0); // Получаем первую игрушку из списка призовых
            // Записываем игрушку в текстовый файл (это можно сделать по вашим требованиям)
            return prizeToy;
        }
        return null; // Если список призовых пуст, возвращаем null
    }
}

