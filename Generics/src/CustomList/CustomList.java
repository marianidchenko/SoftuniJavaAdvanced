package CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable>{
    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public void remove(int index) {
        this.values.remove(index);
    }

    public boolean contains(T element) {
        return this.values.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstItem = this.values.get(firstIndex);
        T secondItem = this.values.get(secondIndex);

        this.values.set(secondIndex, firstItem);
        this.values.set(firstIndex, secondItem);
    }

    public int countGreaterThan(T element) {
        return (int) this.values.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T max() {
        return this.values.stream().max(T::compareTo).get();
    }

    public T min() {
        return this.values.stream().min(T::compareTo).get();
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < this.values.size(); i++) {
            output.append(this.values.get(i)).append("\n");
        }
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }
}
