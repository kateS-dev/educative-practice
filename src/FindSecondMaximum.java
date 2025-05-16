import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindSecondMaximum {
    public static int findSecondMaximum(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return -1;
        }
        Arrays.sort(nums);
        int res = nums[len-1];
        for (int i = len-2; i >= 0; i--) {
            int sec = nums[i];
            if (sec < res) {
                return sec;
            }
        }
        return nums[len-2];
    }

    public static void main(String[] args) {
//        int[] inputs = {-2, -3, -4, -5};
        int[] inputs = {100,600,600};
        int res = findSecondMaximum(inputs);
        System.out.println(res);
    }
}
