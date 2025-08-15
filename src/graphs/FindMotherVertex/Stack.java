package graphs.FindMotherVertex;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> stackList;
    private int stackSize;

    public Stack() {
        stackList = new ArrayList<>();
        stackSize = 0;
    }

    public boolean isEmpty() {
        return stackSize == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null; // or throw an exception
        }
        return stackList.get(stackSize - 1);
    }

    public int size() {
        return stackSize;
    }

    public void push(T value) {
        stackList.add(value);
        stackSize++;
    }

    public T pop() {
        if (isEmpty()) {
            return null; // or throw an exception
        }
        T top = stackList.remove(stackSize - 1);
        stackSize--;
        return top;
    }
}
