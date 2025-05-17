import java.util.Arrays;

public class Rearrange {
    public static void rearrange(int[] arr) {
        int i = 1;
        while (i < arr.length) {
            if (arr[i] < 0 && arr[i-1] >= 0) {
                int tmp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = tmp;

                if (i-1 > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {5, -2, 7, 3, 0, 8, 0, -6};
        rearrange(input);
        System.out.println(Arrays.toString(input));
    }
}
