package linkedlist;

public class FindMiddle {
    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        LinkedListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static LinkedListNode<Integer> findMiddle(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;

        while (slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        };

        return slow;
    }

    public static void printList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Integer[][] input = {
                {1, 2, 3, 4, 5},
                {-1, -2, -3, -4, -6},
                {3, 2},
                {1, 2, 3, 4}
        };

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
            LinkedListNode<Integer> check = findMiddle(headNode);
            System.out.println(check.data);
        }
    }
}
