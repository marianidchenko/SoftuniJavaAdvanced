package StackIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Stack<T> implements Iterable<T> {
    ArrayList<T> stack = new ArrayList<T>();

    public void push(List<T> values) {
        Collections.reverse(values);
        stack.addAll(values);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.remove(0);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index;
            @Override
            public boolean hasNext() {
                return this.index < stack.size();
            }

            @Override
            public T next() {
                return stack.get(index++);
            }
        };
    }

    @Override
    public String toString() {
        if (stack.size() == 0) {
            return "No elements";
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (T value : stack) {
            sb.append(value.toString() + "\n");
        }
        for (T value : stack) {
            sb.append(value.toString() + "\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
