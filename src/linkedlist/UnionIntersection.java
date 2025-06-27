package linkedlist;

import java.util.HashSet;

public class UnionIntersection {
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

    // performs union of two lists
    public static LinkedListNode<Integer> union(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        HashSet<Integer> seen = new HashSet<>();
        // add list1 element
        LinkedListNode<Integer> current1 = head1;
        LinkedListNode<Integer> resHead = new LinkedListNode<>(current1.data);
        LinkedListNode<Integer> res = resHead;
        seen.add(current1.data);

        while (current1.next != null) {
            if (!seen.contains(current1.next.data)) {
                seen.add(current1.next.data);
                LinkedListNode<Integer> tmp = new LinkedListNode<>(current1.next.data);
                res.next = tmp;
                res = res.next;
            }
            current1 = current1.next;
        }

        // add list2 element
        LinkedListNode<Integer> current2 = head2;
        while (current2 != null) {
            if (!seen.contains(current2.data)) {
                seen.add(current2.data);
                LinkedListNode<Integer> tmp = new LinkedListNode<>(current2.data);
                res.next = tmp;
                res = res.next;
            }
            current2 = current2.next;
        }
        return resHead;
    }

    // performs intersection between list
    public static LinkedListNode<Integer> intersection(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        HashSet<Integer> seen = new HashSet<>();
         // add list1 element
        LinkedListNode<Integer> current1 = head1;
        while (current1 != null) {
            if (!seen.contains(current1.data)) {
                seen.add(current1.data);
            }
            current1 = current1.next;
        }

        LinkedListNode<Integer> resHead = new LinkedListNode<>(null);
        LinkedListNode<Integer> res = resHead;
        LinkedListNode<Integer> current2 = head2;

        while (current2 != null) {
            if (seen.contains(current2.data)) {
                LinkedListNode<Integer> tmp = new LinkedListNode<>(current2.data);
                if (resHead.data == null) {
                    resHead = tmp;
                    res = resHead;
                } else {
                    res.next = tmp;
                    res = res.next;
                }

            }
            current2 = current2.next;
        }

        return resHead;
    }

    public static void main(String[] args) {
        Integer[] input1 = {5,10,15,20,25,30,35,40,45,50,55,60,65,70,75};
        Integer[] input2 = {25,30,35,40,45,50,55,60,65,70,75,80,85,90,95};

        LinkedListNode<Integer> head1 = new LinkedListNode<>(input1[0]);
        LinkedListNode<Integer> l1 = head1;
        for (int i = 1; i < input1.length; i++) {
            LinkedListNode<Integer> node = new LinkedListNode<>(input1[i]);
            l1.next = node;
            l1 = l1.next;
        }

        LinkedListNode<Integer> head2 = new LinkedListNode<>(input2[0]);
        LinkedListNode<Integer> l2 = head2;
        for (int i = 1; i < input2.length; i++) {
            LinkedListNode<Integer> node = new LinkedListNode<>(input2[i]);
            l2.next = node;
            l2 = l2.next;
        }
        printList(head1);
        printList(head2);

        //union output
//        LinkedListNode<Integer> unionOutput = union(head1, head2);
//        printList(unionOutput);

        LinkedListNode<Integer> intersectOutput = intersection(head1, head2);
        printList(intersectOutput);
    }
}
