package linkedlist;

import java.util.HashSet;

public class DetectCycle {

    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        LinkedListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static <Integer> boolean detectCycle(LinkedListNode<Integer> head) {
        HashSet<Integer> store = new HashSet<>();
        while(head != null) {
            if (store.contains(head.data)) {
                return true;
            } else {
                store.add(head.data);
            }
            head = head.next;
        }
        return false;
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
                {4, 6, 2, 8, 10, 2},
                {1, 2, 3, 4, 5},
                {-1, -2, -3, -4, -6},
                {3, 2, 1}
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
            boolean check = detectCycle(headNode);
            System.out.println(check);
        }
    }
}
