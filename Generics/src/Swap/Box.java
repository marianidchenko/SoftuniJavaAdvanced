package Swap;

import java.util.ArrayList;
import java.util.List;

public class Box<T>{
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T value) {
        values.add(value);
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

    public static <T> void swap(List<T> list, int x, int y) {
        T first = list.get(x);
        T second = list.get(y);
        list.set(y, first);
        list.set(x, second);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s: %s%n",value.getClass().getName(), value.toString()));
        }
        return sb.toString();
    }
}
