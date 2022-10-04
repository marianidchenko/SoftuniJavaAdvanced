package Box;

import java.util.ArrayList;
import java.util.List;

public class Box <T>{
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T value) {
        values.add(value);
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
