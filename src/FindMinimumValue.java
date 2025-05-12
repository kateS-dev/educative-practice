public class FindMinimumValue {

/*
    Given an array of integers, arr, find the minimum value from the array.
*/
    public static int findMinimum(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] input = {1,2,-3,-1,-2};
        int ret = findMinimum(input);
        System.out.println(ret);
    }
}
