package stackQueues.NextGreaterElement;

import java.util.Arrays;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
           MyStack<Integer> tmp = new MyStack<>();
           for (int j = i+1; j < arr.length; j++) {
               if (arr[j] > arr[i]) {
                   if (!tmp.isEmpty() && tmp.peek() < arr[j]) {
                       tmp.pop();
                   }
                   tmp.push(arr[j]);
                   break;
               }
           }
           result[i] = tmp.isEmpty() ? -1 : tmp.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {0,1,2,4,6,11,11,14,17};
        //1,2,4,6,11,14,14,17,-1
        int[] output = nextGreaterElement(input);
        System.out.println(Arrays.toString(output));
    }
}
