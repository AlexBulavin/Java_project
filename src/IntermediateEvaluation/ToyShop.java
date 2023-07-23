package IntermediateEvaluation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ToyShop implements IToyPresenter  {
    private List<Toy> toys = new ArrayList<>();
    private IView view;
    private IPresenter presenter;

    public interface IView {
        void showPrizeToy(Toy toy);
    }

    public interface IPresenter {
        void onToyAdded(Toy toy);
        void onUpdateFrequency(int toyId, double newFrequency);
        void onPlayGame();
    }

    public ToyShop(IToyView view) {
        this.view = view;
    }


    public void addToy(Toy toy) {
        toys.add(toy);
        presenter.onToyAdded(toy);
    }

    public void updateFrequency(int toyId, double newFrequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(newFrequency);
                presenter.onUpdateFrequency(toy.getId(), toy.getFrequency());
                break;
            }
        }
    }

    public void playGame() {
        List<Toy> prizeToys = new ArrayList<>();
        for (Toy toy : toys) {
            int quantity = toy.getQuantity();
            double frequency = toy.getFrequency();
            for (int i = 0; i < quantity; i++) {
                if (Math.random() < frequency / 100) {
                    prizeToys.add(toy);
                    toy.setQuantity(quantity - 1);
                    break;
                }
            }
        }

        if (!prizeToys.isEmpty()) {
            Toy firstPrizeToy = prizeToys.get(0);
            prizeToys.remove(0);
            savePrizeToy(firstPrizeToy);
            view.showPrizeToy(firstPrizeToy);
        }
    }

    private void savePrizeToy(Toy toy) {
        try {
            FileWriter writer = new FileWriter("prize_toys.txt", true);
            writer.write(toy.getName());
            writer.write(System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onToyAdded(Toy toy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onToyAdded'");
    }

    @Override
    public void onUpdateFrequency(int toyId, double newFrequency) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onUpdateFrequency'");
    }

    @Override
    public void onPlayGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onPlayGame'");
    }
}


