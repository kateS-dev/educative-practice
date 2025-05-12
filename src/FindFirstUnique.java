import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstUnique {
    public static int findFirstUnique(int[] nums) {
        int result = nums[0];
        Map<Integer, Integer> frequent = new LinkedHashMap<>();

        for(int num : nums) {
            if (frequent.containsKey(num)) {
                frequent.remove(num);
            } else {
                frequent.put(num, 1);
            }

        }

        for(int num: frequent.keySet()) {
            if (frequent.get(num) == 1) {
                result = num;
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] input = {11,-11,22,33,-33,11};
//        int[] input = {88,88,77,-77,33,77};
        int[] input = {4};
        int output = findFirstUnique(input);
        System.out.println(output);
    }
}
