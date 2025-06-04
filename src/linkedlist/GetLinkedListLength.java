package linkedlist;

public class GetLinkedListLength {

    static class LinkedListNode<T> {
        T data;
        LinkedListNode<Integer> next;

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

    public static int length(LinkedListNode<Integer> head) {
        int len = 0;
        LinkedListNode<Integer> current = head;
        while (current != null) {
            len++;
            current = current.next;
        }

        return len;
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
            int linkLen = length(headNode);
            printList(headNode);
            System.out.println("The length is: " + linkLen);
        }
    }

}
