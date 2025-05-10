import java.util.Arrays;

public class FindProduct {

    /*You’re given an integer array, nums. Return a resultant
    array product so that product[i] is equal to the product
    of all the elements of nums except nums[i].

    Write an algorithm that runs in O(n) time without using
    the division operation.*/

    public static int[] findProduct(int arr[]) {
        int len = arr.length;
        int[] preRes = new int[len];
        int tmp = 1;

        preRes[0] = 1;
        for (int i = 1; i < len; i++) {
            tmp = tmp * arr[i-1];
            preRes[i] = tmp;
        }

        tmp = 1;
        for (int j = len - 1; j >= 0; j--) {
            preRes[j] = preRes[j] * tmp;
            tmp = tmp * arr[j];
        }

        return preRes;
    }

    public static void main(String[] args) {
        int[] input = {1, -3, 5, 7, -11};
        int[] output = findProduct(input);
        System.out.println(Arrays.toString(output));
    }
}
