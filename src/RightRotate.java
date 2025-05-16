import java.util.Arrays;

public class RightRotate {
    public static int[] rightRotate(int[] nums, int k) {
        int len = nums.length;
        k = len - k % len;
        int[] res = new int[len];
        if (k == 0) {
            return nums;
        }

        int j = 0;
        for (int i = k; i < len+k; i++) {
            int index = i;
            if (index >= len) {
                index = index-len;
            }
            res[j] = nums[index];
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = {-2,2,11,15,-3};
        int k = 8;
        int[] output = rightRotate(input, k);
        System.out.println(Arrays.toString(output));
    }
}
