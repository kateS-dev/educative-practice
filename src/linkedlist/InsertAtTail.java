package linkedlist;

public class InsertAtTail {
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

    public LinkedListNode<Integer> insertAtTail(LinkedListNode<Integer> head, int value) {
        LinkedListNode<Integer> newNode = new LinkedListNode<>(value);
        newNode.next = null;

        //case for empty linkedlist
        if (head == null) {
            return newNode;
        }

        //case for non-empty linkedlist
        LinkedListNode<Integer> tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }

        tailNode.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        InsertAtTail insertObj = new InsertAtTail();

        // Test Case 1: Insert into an empty list
        // List: 1 -> 2
        InsertAtTail.LinkedListNode<Integer> head1 = new InsertAtTail.LinkedListNode<>(1);
        head1 = insertObj.insertAtTail(head1,2);
        printList(head1);

        // Test Case 2: Insert into a list with multiple elements
        // List: 1 -> 2 -> 3
        head1 = insertObj.insertAtTail(head1, 3);
        printList(head1);

        // Test Case 3: Insert into a single-node list
        // List: 10 -> 20
        InsertAtTail.LinkedListNode<Integer> head2 = new InsertAtTail.LinkedListNode<>(10);
        head2 = insertObj.insertAtTail(head2, 20);
        printList(head2);
    }
}
