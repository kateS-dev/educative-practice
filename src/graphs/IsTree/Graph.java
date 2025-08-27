package graphs.IsTree;

import java.util.*;
public class Graph<T> {

    //Total number of vertices in graph
    int vertices;

    //An array of linked lists to store adjacent vertices
    LinkedList< Integer > list[];

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        list = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            list[i] = new LinkedList < > ();
        }
    }

    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.list[source].insertAtEnd(destination);

            //for undirected graph uncomment the line below
            this.list[destination].insertAtEnd(source);
        }
    }
    public void printGraph() {
        System.out.println("\t>>Undirected Graph<<");
        for (int i = 0; i < vertices; i++) {
            if (list[i] != null) {
                System.out.print("\t|" + i + "| => ");

                LinkedListNode < Integer > temp = list[i].head;
                while (temp != null) {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.next;
                }
                System.out.println("null");
            } else {

                System.out.println("|" + i + "| => " + "null");
            }
        }
    }
}