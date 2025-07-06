package stackQueues.QueueWithStackIssue;

public class QueueWithStack {
    private final MyStack<Integer> stackIn;
    private final MyStack<Integer> stackOut;

    public QueueWithStack(int maxSize) {
        this.stackIn = new MyStack<>(maxSize);
        this.stackOut = new MyStack<>(maxSize);
    }

    public void enqueue(int value) {
        stackIn.push(value);
    }

    public void sync() {
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }

    public int dequeue() {
        if (stackIn.isEmpty() && stackOut.isEmpty()) {
            return -1;
        }

        if (stackOut.isEmpty()) {
            sync();
        }

        int ret = stackOut.pop();

        return ret;
    }
}


