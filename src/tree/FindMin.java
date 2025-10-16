package tree;

// Definiton of a binary tree node class
class TreeNode<T> {
     T data;
     TreeNode<T> left;
     TreeNode<T> right;

     TreeNode(T data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
}

public class FindMin {
    public static int findMin(TreeNode<Integer> root) {
        TreeNode<Integer> tmp = root;
        while (tmp.left != null) {
            tmp = tmp.left;
        }

        return (tmp != null) ? tmp.data : -1;
    }

    public static void main(String[] args) {
        TreeNode<Integer> tree = new TreeNode<>(5);
        tree.left = new TreeNode<>(3);
        tree.right = new TreeNode<>(7);

        int min = findMin(tree);
        System.out.println(min);
    }
}
