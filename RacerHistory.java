import java.util.ArrayList;
import java.util.List;

public class RacerHistory {
    private List<Racer> snapshots;

    public RacerHistory() {
        this.snapshots = new ArrayList<>();
    }

    public void onRacerUpdate(Racer racer) {
        snapshots.add(racer.clone());
    }

    /**
     * Gets the state of the racer after a specific action number (history step).
     * @param actionIndex The index corresponding to the action number (0-based).
     * @return The Racer state at that point in history.
     * @throws IllegalArgumentException if the action index is invalid.
     */
    public Racer getActionSnapshot(int actionIndex) {
        if (actionIndex < 0 || actionIndex >= snapshots.size()) {
            throw new IllegalArgumentException("Invalid action index.");
        }
        return snapshots.get(actionIndex);
    }

    public int size() {
        return snapshots.size();
    }
}
