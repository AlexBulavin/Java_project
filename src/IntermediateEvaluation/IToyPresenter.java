package IntermediateEvaluation;

public interface IToyPresenter {
    void onToyAdded(Toy toy);
    void onUpdateFrequency(int toyId, double newFrequency);
    void onPlayGame();
}

