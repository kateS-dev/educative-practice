package array;

import java.util.Arrays;

public class RearrangeArray {
    public static int[] rearrangeArray(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length;i++) {
            if (2*i < nums.length) {
                res[2*i] = nums[nums.length-1-i];
                if ((2*i)+1 < nums.length) {
                    res[(2*i)+1] = nums[i];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] input = {1,2,3,4,5,6,7,8};  //target result: 8,1,7,2,6,3,5,4
        int[] input = {2,4,6,8,10};  //target result: 10,2,8,4,6
        int[] output = rearrangeArray(input);
        System.out.println(Arrays.toString(output));
    }
}
