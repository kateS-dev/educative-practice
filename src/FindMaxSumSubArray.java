public class FindMaxSumSubArray {
    public static int findMaxSumSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int res = Integer.MIN_VALUE;
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp = Math.max(nums[i], tmp+nums[i]);
            res = Math.max(res, tmp);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] input = {3,7,-8,-1,-2,11,-2};
//        int[] input = {-2,1,-3,4,-1,2,1,-5,4}; //expect is 6
        int[] input = {-10,2,9,4,-6,-3,1,2,4,-3,6}; //expect is 16
        int output = findMaxSumSubArray(input);
        System.out.println(output);
    }
}
