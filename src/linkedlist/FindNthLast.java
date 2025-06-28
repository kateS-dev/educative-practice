package linkedlist;

public class FindNthLast {
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

    public static LinkedListNode<Integer> findNth(LinkedListNode<Integer> head, int n) {
        //reverse the linkedlist
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> prev = null;

        while (current != null) {
            LinkedListNode<Integer> currentNode = new LinkedListNode<>(current.data);
            if (prev == null) {
                prev = currentNode;
            } else {
                LinkedListNode<Integer> tmp = prev;
                prev = currentNode;
                prev.next = tmp;
            }

            current = current.next;
        }

        while (n > 1) {
            prev = prev.next;
            n--;
        }

        return prev;
    }

    public static void main(String[] args) {
        Integer[] list = {2,4,6,8};
        LinkedListNode<Integer> head = new LinkedListNode<>(list[0]);
        LinkedListNode<Integer> l = head;

        for (int i = 1; i < list.length; i++) {
            LinkedListNode<Integer> node = new LinkedListNode<>(list[i]);
            l.next = node;
            l = l.next;
        }

        printList(head);
        LinkedListNode<Integer> retNode = findNth(head, 3);
        printList(retNode);
    }
}
