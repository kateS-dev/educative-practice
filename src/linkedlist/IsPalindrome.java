package linkedlist;

public class IsPalindrome {
    public static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode prev;
        public DoublyLinkedListNode next;

        public DoublyLinkedListNode(int data, DoublyLinkedListNode prev, DoublyLinkedListNode next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public DoublyLinkedListNode(int data) {
            this(data, null, null);
        }
    }

    public class DoublyLinkedList {
        public DoublyLinkedListNode head;

        public DoublyLinkedList() {
            this.head = null;
        }

        public void insertNodeAtHead(DoublyLinkedListNode node) {
            if (head != null) {
                node.next = head;
                head.prev = node;
                head = node;
            } else {
                head = node;
            }
        }

        public void createLinkedList(int[] lst) {
            for (int i = lst.length - 1; i >= 0; i--) {
                DoublyLinkedListNode newNode = new DoublyLinkedListNode(lst[i]);
                insertNodeAtHead(newNode);
            }
        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            DoublyLinkedListNode temp = head;
            while (temp != null) {
                result.append(temp.data);
                temp = temp.next;
                if (temp != null) {
                    result.append(", ");
                }
            }
            return result.toString();
        }
    }

    public static boolean isPalindrome(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;
        DoublyLinkedListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        while (current != null && tail != null) {
            if (current.data != tail.data) {
                return false;
            }
            current = current.next;
            tail = tail.prev;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] list = {2,4,6,7,8,6,4,2};
        IsPalindrome outer = new IsPalindrome();
        DoublyLinkedList dll = outer.new DoublyLinkedList();
        dll.createLinkedList(list);

        System.out.println("Doubly Linked List: " + dll);
        boolean isPalindrome = isPalindrome(dll.head);
        System.out.println(isPalindrome);
    }
}
