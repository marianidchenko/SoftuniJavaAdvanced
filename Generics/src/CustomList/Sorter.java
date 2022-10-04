package CustomList;

import java.util.List;

public class Sorter {
    public static <T extends Comparable> void sort(CustomList<String> list) {
        List<String> sortedCollection = list.getValues();
        sortedCollection.sort(Comparable::compareTo);
        list.setValues(sortedCollection);
    }
}