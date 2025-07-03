package stackQueues;

import java.util.Arrays;
import java.util.EmptyStackException;

class TwoStacks < V > {
    private int arraySize;
    private V[] array;
    private int pointer1;
    private int pointer2;

    @SuppressWarnings("unchecked")
    public TwoStacks(int arraySize) {
        this.arraySize = arraySize;
        array = (V[]) new Object[arraySize]; //type casting Object[] to V[]
        pointer1 = 0;
        pointer2 = arraySize - 1;

    }

    //insert at top of first stack
    public void push1(V value) {
        if (pointer1 > pointer2) {
            throw new StackOverflowError();
        }
        array[pointer1++] = value;
    }

    //insert at top of second stack
    public void push2(V value) {
        if (pointer2 < pointer1) {
            throw new StackOverflowError();
        }
        array[pointer2--] = value;
    }

    //remove and return value from top of first stack
    public V pop1() {
        if (pointer1 == 0) {
            throw new EmptyStackException();
        }

        return array[--pointer1];
    }

    //remove and return value from top of second stack
    public V pop2() {
        if (pointer2 == arraySize-1) {
            throw new EmptyStackException();
        }
        return array[++pointer2];
    }

    @Override
    public String toString() {
        return "TwoStacks{" +
                "array=" + Arrays.toString(array) +
                ", pointer1=" + pointer1 +
                ", pointer2=" + pointer2 +
                '}';
    }

    public static void main(String[] args) {
        TwoStacks<Integer> ts = new TwoStacks<>(3);
        System.out.println("Initial: " + ts);
        ts.push1(1);
        System.out.println("After push1(1): " + ts);
        ts.push2(2);
        System.out.println("After push2(2): " + ts);
        ts.pop1();
        System.out.println("After pop1(): " + ts);
        ts.pop2();
        System.out.println("After pop2(): " + ts);
    }
}
