package CountMethod;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable>{
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

    public static <T extends Comparable> int compare(List<T> list, T element) {
        int result = 0;
        for (T value : list) {
            if (value.compareTo(element) > 0) {
                result += 1;
            }
        }
        return result;
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
