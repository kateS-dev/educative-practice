package linkedlist;

public class DeleteByValue {
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


    private static boolean deleteByValue(LinkedListNode <Integer> head, int value) {
        LinkedListNode<Integer> current = head;
        while (current != null) {
            // handle the first one is target deleted item
            if (current.data == value) {
                current.data = null;
                return true;
            }

            // handle the others
            if (current.next != null) {
                LinkedListNode<Integer> next = current.next;
                if (next.data == value) {
                    current.next = next.next;
                    return true;
                }
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
        int[] values = {4, -3, 2, 1, 2, 3};

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
            boolean output = DeleteByValue.deleteByValue(headNode, values[i]);
            printList(headNode);
            System.out.println(values[i] +" : "+ output);
        }
    }
}
