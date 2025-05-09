import java.util.Arrays;

public class FindTwoNumbersThatAddUpToK {
    /*
        Statement#
        Given an array of integers, nums, and an integer target, k, find two numbers
        in the array that sum up to the target k.

        There is exactly one solution for each input, and each element of the array
        can only be used once in the solution. The order of the returned elements does not matter.
    */

    public static int[] findSum(int[] arr, int n) {
        int[] ret = new int[2];
        for(int i = 0; i < arr.length; i++) {
           ret[0] = arr[i];
           int target = n - ret[0];
           for (int j = i+1; j < arr.length; j++) {
               if (target == arr[j]) {
                   ret[1] = target;
                   return ret;
               }
           }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 8, 4, 9};
        int n = 17;
        int[] res = findSum(arr, n);
        System.out.println(Arrays.toString(res));
    }
}
