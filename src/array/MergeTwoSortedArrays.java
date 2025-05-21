package array;
import java.util.ArrayList;

public class MergeTwoSortedArrays {
    public static ArrayList<Integer> mergeArrays(ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums1.isEmpty()) {
            return nums2;
        }

        if (nums2.isEmpty()) {
            return nums1;
        }

        int i = 0;
        int j = 0;
        while(i < nums1.size() && j < nums2.size()) {
            if (nums1.get(i) <= nums2.get(j)) {
                res.add(nums1.get(i));
                i++;
            } else if (nums1.get(i) > nums2.get(j)) {
                res.add(nums2.get(j));
                j++;
            }
        }

        if (i < nums1.size()) {
            res.addAll(nums1.subList(i, nums1.size()));
        }

        if (j < nums2.size()) {
            res.addAll(nums2.subList(j, nums2.size()));
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(-1);
        a1.add(3);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(-1);
        a2.add(-1);
        a2.add(0);
        a2.add(0);
        a2.add(1);
        a2.add(2);

        ArrayList<Integer> a3 = mergeArrays(a1, a2);
        System.out.println(a3);
    }
}
