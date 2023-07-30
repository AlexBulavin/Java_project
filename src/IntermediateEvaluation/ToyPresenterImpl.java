package IntermediateEvaluation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToyPresenterImpl implements IToyPresenter {
    private IToyModel model;
    private List<Toy> prizeToys;
    private IToyView view;

    public ToyPresenterImpl(IToyModel model, IToyView view) {
        this.model = model;
        this.view = view;
        this.prizeToys = model.getPrizeToys();
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

        double noPrizeChance = 0.5; // 50% шанс, что ничего не выпадет
        boolean won = false; // Флаг, указывающий, выиграл ли пользователь призовую игрушку

        if (randomWeight <= totalWeight * noPrizeChance) {
            view.showSorryMessage();
            return; // Ничего не выпадет
        }

        for (Toy toy : toys) {
            randomWeight -= toy.getWeight();
            if (randomWeight <= 0) {
                prizeToys.add(toy);
                model.updateToyWeight(toy.getId(), 0); // Убираем игрушку из розыгрыша
                won = true;
                break;
            }
        }

        if (won) {
            view.showCongratulationsMessage(prizeToys.get(prizeToys.size() - 1).getName());
        } else {
            view.showSorryMessage();
        }
    }

    @Override
    public Toy getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            return prizeToys.get(0); // Возвращаем первую призовую игрушку
        }
        return null; // Если список призовых пуст, возвращаем null
    }

    @Override
    public List<Toy> getPrizeToys() {
        return prizeToys;
    }

    // Метод для получения текущей даты и времени розыгрыша
    private String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    // Метод для записи призовой игрушки и даты розыгрыша в текстовый файл
    public void writePrizeToyToFile(String fileName) {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.remove(0); // Получаем первую игрушку из списка призовых
            String dateTime = getCurrentDateTime(); // Получаем текущую дату и время

            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write("Призовая игрушка: " + prizeToy.getName() + "\n");
                writer.write("Дата и время розыгрыша: " + dateTime + "\n");
                // Здесь можно добавить еще информации об игрушке, если нужно
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

