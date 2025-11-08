package tree;

import static tree.FindKthMax.buildBST;
import static tree.FindKthMax.printInOrder;

public class FindHeight {
    public static int findHeight(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    public static void main(String[] args) {
//        Integer[] arr = {23,21,24,null,22,null,null};
//        Integer[] arr = {3,1,5,null,2,null,null};
//        Integer[] arr = {3,1,4,null,null,null,10,null};
        Integer[] arr = {50,30,70,20,40,60,80,10,25,35,45,55,65,75,85};
        TreeNode root = buildBST(arr);
        printInOrder(root);

        int height = findHeight(root);
        System.out.println(" The height of BST is: " + height);
    }
}
