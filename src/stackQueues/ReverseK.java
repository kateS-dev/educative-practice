package stackQueues;

public class ReverseK {
    public static MyQueue<Integer> reverseK(MyQueue<Integer> queue, int k) {
        MyStack<Integer> tmp = new MyStack<>();
        MyQueue<Integer> res = new MyQueue<>();
        if (k == 0) {
            return queue;
        }
        while (k != 0) {
            tmp.push(queue.dequeue());
            k--;
        }

        while (!tmp.isEmpty()) {
            res.enqueue(tmp.pop());
        }

        while (!queue.isEmpty()) {
            res.enqueue(queue.dequeue());
        }

        return res;
    }

    public static void printQueue(MyQueue<Integer> input) {
        int len = input.size();
        String output = "";

        for (int i = 0; i < len; i++) {
            Integer j = input.dequeue();
            output = output + "=>" + j;
        }

        System.out.println(output);
    }

    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<>();
        Integer[] input = {1,2,3,4,5};

        for (int i = 0; i < input.length; i++) {
            mq.enqueue(input[i]);
        }

        MyQueue<Integer> output = reverseK(mq, 3);
        printQueue(output);
    }
}
