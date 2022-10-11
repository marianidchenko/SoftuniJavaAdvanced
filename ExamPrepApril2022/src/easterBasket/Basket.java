package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    String material;
    int capacity;
    List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<Egg>();
    }

//    •	Method report() – returns a string in the following format (print the eggs in order of appearance):

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        return data.removeIf(e -> e.getColor().equals(color));
    }

    public Egg getStrongestEgg() {
        return data.stream().max(Comparator.comparingInt(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {
        return data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        String result = String.format("%s basket contains:\n", material);
        result += data.stream().map(Egg::toString).collect(Collectors.joining("\n"));
        return result;
    }
}
