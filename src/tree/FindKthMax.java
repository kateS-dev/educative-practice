package tree;

public class FindKthMax {
   /*
        [23,21,24,null,22,null,null] , 3
        [15, 10, 20, 8, 12, 16, 25], 3
   */

    static int count = 0;
    static int result = Integer.MAX_VALUE;

    private static void findUtils(TreeNode<Integer> root, int k) {
        if (root == null || count >= k) {
            return;
        }

        findUtils(root.right, k);
        count++;
        if (count == k) {
            result = root.data;
            return;
        }
        findUtils(root.left, k);

    }

    public static int findKthMax(TreeNode<Integer> root, int k) {
        count = 0;
        result = Integer.MAX_VALUE;

        findUtils(root, k);
        return result;
    }

    public static TreeNode insert(TreeNode<Integer> root, Integer val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val != null && val < root.data) {
            root.left = insert(root.left, val);
        } else if (val != null && val > root.data){
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static TreeNode buildBST(Integer[] arr) {
        TreeNode<Integer> root = null;
        for (Integer val : arr) {
            root = insert(root, val);
        }
        return root;
    }

    public static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {23,21,24,null,22,null,null};
        TreeNode root = buildBST(arr);
        printInOrder(root);

        int s = findKthMax(root, 3);
        System.out.println("\n3rd maximum value: " + s);
    }
}
