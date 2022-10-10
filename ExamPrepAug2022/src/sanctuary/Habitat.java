package sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    int capacity;
    List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<Elephant>(capacity);
    }

    public void add(Elephant e) {
        if (data.size() < capacity) {
            data.add(e);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        return data.stream()
                .filter(e -> e.getRetiredFrom().equals(retiredFrom))
                .findFirst()
                .orElse(null);
    }

    public Elephant getOldestElephant() {
        return data.stream().max(Comparator.comparingInt(Elephant::getAge)).orElse(null);
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:\n");
        for (Elephant e : data) sb.append(String.format("%s came from: %s\n", e.getName(), e.getRetiredFrom()));
        return sb.toString();
    }
}
