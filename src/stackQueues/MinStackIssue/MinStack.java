package stackQueues.MinStackIssue;

import java.util.ArrayList;
import java.util.List;

class MinStack {
    int maxSize;
    int miniValue;
    MyStack<Integer> ms;

    //constructor
    public MinStack(int maxSize) {
        this.maxSize = maxSize;
        this.miniValue = Integer.MAX_VALUE;
        this.ms = new MyStack<>(maxSize);
    }

    //removes and returns value from stack
    public Integer pop() {
        Integer value = ms.pop();
        if (this.miniValue == value) {
            // need to reset the minivalue
            MyStack<Integer> copy = deepCopy(this.ms);
            this.miniValue = Integer.MAX_VALUE;
            while (!copy.isEmpty()) {
                int updated = copy.pop();
                if (this.miniValue > updated) {
                    this.miniValue = updated;
                }
            }
        }
        return value;
    }
    //pushes value into the stack
    public void push(Integer value) {
        ms.push(value);
        if (this.miniValue > value) {
            this.miniValue = value;
        }
    }

    //returns minimum value in O(1)
    public int min() {
        return this.miniValue;
    }

    private MyStack<Integer> deepCopy(MyStack<Integer> original) {
        MyStack<Integer> copy = new MyStack<>(this.maxSize);
        List<Integer> tempList = new ArrayList<>();

        while (!original.isEmpty()) {
            tempList.add(original.pop());
        }

        for (int i = tempList.size()-1; i >= 0; i--) {
            int val = tempList.get(i);
            original.push(val);
            copy.push(val);
        }

        return copy;
    }

    public static void main(String[] args) {

    }
}