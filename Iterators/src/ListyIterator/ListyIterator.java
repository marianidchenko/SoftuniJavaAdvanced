package ListyIterator;

import java.util.List;

public class ListyIterator {
    private static final int START_INDEX = 0;
    private List<String> data;
    private int index;

    public ListyIterator(List<String> data) {
        this.data = data;
        this.index = START_INDEX;
    }

    public boolean move() {
        if (this.index < this.data.size() -1) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index < this.data.size()-1;
    }

    public void printAll() {
        System.out.println(String.join(" ", this.data));
    }

    @Override
    public String toString() {
        try {
            return this.data.get(this.index);
        } catch (Exception e) {
            throw new IndexOutOfBoundsException("Invalid Operation!");
        }
    }
}
