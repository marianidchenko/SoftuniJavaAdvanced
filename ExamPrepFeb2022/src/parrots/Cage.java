package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    String name;
    int capacity;
    List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<Parrot>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        parrot.setAvailable(false);
        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> list = data.stream().filter(p -> p.getSpecies().equals(species)).collect(Collectors.toList());
        for (Parrot parrot : list) {
            parrot.setAvailable(false);
        }
        return list;
    }

    public int count() { return data.size();}

    public String report() {
        String result = String.format("Parrots available at %s:\n", name);
        List<Parrot> parrots = data.stream().filter(p -> p.isAvailable()).collect(Collectors.toList());
        for (Parrot parrot : parrots) {
            result += parrot.toString() +"\n";
        }
        return result.trim();
    }
}
