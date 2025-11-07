package tree;

import java.util.ArrayList;
import java.util.List;

import static tree.FindKthMax.buildBST;
import static tree.FindKthMax.printInOrder;

/*
    [3,1,4,null,null,null,10,null] , 1
*/


public class FindAncestors {
    static List<Integer> ancestor = new ArrayList<>();

    private static boolean findAncestorUtils(TreeNode<Integer> root, int k) {
        if (root == null) {
            return false;
        }

        if (root.data == k) {
            return true;
        }

        if (findAncestorUtils(root.left, k) || findAncestorUtils(root.right, k)) {
            ancestor.add(root.data);
            return true;
        }

        return false;
    }

    public static List<Integer> findAncestors(TreeNode<Integer> root, int k) {
        ancestor = new ArrayList<>();

        findAncestorUtils(root, k);
        return ancestor;
    }

    public static void main(String[] args) {
        Integer[] arr = {3,1,4,null,null,null,10,null};
        TreeNode root = buildBST(arr);
        printInOrder(root);
        List<Integer> res = findAncestors(root, 1);
        System.out.println("Ancestors of 1: " + res);
    }
}
