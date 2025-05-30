package linkedlist;

class LinkedListNode<T> {
     T data;
     LinkedListNode<T> next;

     LinkedListNode(T data) {
         this.data = data;
         this.next = null;
     }
 }

public class SearchNode {
    public static void printList(LinkedListNode <Integer> head) {
        LinkedListNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }

        System.out.println("null");
    }


    // can use recursive method
    /*public static boolean searchNode(LinkedListNode<Integer> head, int value) {
        LinkedListNode<Integer> current = head;
        return searchRecursive(current, value);
    }

    private static boolean searchRecursive(LinkedListNode<Integer> node, int value) {
        // Base case
        if (node == null) {
            return false;  // Value not found
        }

        // Check if the node's data matches our value
        if (node.data == value) {
            return true;  // Value found
        }

        // Recursive call to next node in the list
        return searchRecursive(node.next, value);
    }*/

    public static boolean searchNode(LinkedListNode <Integer> head, int value) {
        LinkedListNode<Integer> current = head;
        if (current == null) {
            return false;
        }

        if (current.data == value) {
            return true;
        }

        while (current.next != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[][] input = {
                {1, 2, 3, 4, 5},
                {-1, -2, -3, -4, -6},
                {3, 2, 1},
                {},
                {1, 2},
                {3},
        };
        int[] values = {4, -5, 2, 0, -98, 3};

        for (int i = 0; i < input.length; i++) {
            Integer[] each = input[i];
            int len = each.length;

            if (len == 0) {
                continue;
            }

            LinkedListNode<Integer> headNode = new LinkedListNode<>(each[0]);
            LinkedListNode<Integer> current = headNode;
            if (len > 1) {
                for (int j=1; j < len; j++) {
                    LinkedListNode<Integer> newNode = new LinkedListNode<>(each[j]);
                    current.next = newNode;
                    current = newNode;
                }
            }
            printList(headNode);
            boolean output = SearchNode.searchNode(headNode, values[i]);
            System.out.println(values[i] +" : "+ output);
        }
    }
}
