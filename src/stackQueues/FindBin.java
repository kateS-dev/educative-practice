package stackQueues;

import java.util.Arrays;

public class FindBin {
//    public static String[] findBin(int n) {
//        MyQueue<String> result = new MyQueue<>();
//        for (int i = 1; i <= n; i++) {
//            String item = Integer.toBinaryString(i);
//            result.enqueue(item);
//        }
//
//        String[] res = new String[result.size()];
//        int i = 0;
//        while (!result.isEmpty()) {
//            res[i] = result.dequeue();
//            i++;
//        }
//        return res;
//    }
//
    // method 2

    public static String[] findBin(int n) {
        String[] result = new String[n];
        MyQueue <String> queue = new MyQueue <String> ();

        // Start with '1' in the queue
        queue.enqueue("1");

        // Loop to generate binary numbers up to 'n'
        for (int i = 0; i < n; i++) {
            // Dequeue the front element of the queue
            result[i] = queue.dequeue();

            // Generate new binary numbers by appending '0' and '1' to the dequeued number
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";

            // Enqueue the new binary numbers back into the queue
            queue.enqueue(s1);
            queue.enqueue(s2);
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        String[] res = findBin(n);
        System.out.println(Arrays.toString(res));
    }
}
