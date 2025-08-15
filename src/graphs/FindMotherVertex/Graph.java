package graphs.FindMotherVertex;
import java.util.*;

public class Graph {
    // Total number of vertices in graph
    int vertices;

    // An array of linked lists to store adjacent vertices
    LinkedList< Integer > adjacencyList[];

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList < > ();
        }
    }

    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            this.adjacencyList[source].insertAtEnd(destination);
        }
    }
}
