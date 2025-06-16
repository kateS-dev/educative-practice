package linkedlist;

import java.util.HashSet;

public class RemoveDuplicates {
    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        LinkedListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    /*
    alternative answer:
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        // Check if list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        LinkedListNode<Integer> outerNode = head;
        // Traverse the linked list to find duplicates
        while (outerNode != null) {
            LinkedListNode<Integer> innerNode = outerNode;
            while (innerNode != null && innerNode.next != null) {
                if (outerNode.data.equals(innerNode.next.data)) {
                    innerNode.next = innerNode.next.next;
                } else {
                    innerNode = innerNode.next;
                }
            }
            outerNode = outerNode.next;
        }

        return head;
    }
    */

    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode <Integer> head) {
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> prev = null;
        HashSet<Integer> store = new HashSet<>();

        while (current != null) {
            if (store.contains(current.data)) {
                if (current.next != null) {
                    prev.next = current.next;
                } else {
                    prev.next = null;
                }
            } else {
                store.add(current.data);
                prev = current;
            }
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Integer[][] input = {
                {3,6,9,11,6,4},
                {-1, -1, -3, -4, -6},
                {3, 3},
                {1, 2, 2, 4}
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
            LinkedListNode<Integer> newNode = removeDuplicates(headNode);
            printList(newNode);
        }
    }
}
