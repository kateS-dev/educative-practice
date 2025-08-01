package graphs.DfsTraversal;

import java.util.*;

public class Solution {
    public static List<Integer> dfsTraversal(Graph graph, int source) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.adjacencyList.length];
        dfsUtil(source, graph.adjacencyList, visited, result);
       return result;
    }

    private static void dfsUtil(int node, DoublyLinkedList<Integer>[] adjacencyList, boolean[] visited, List<Integer> result) {
        visited[node] = true;
        result.add(node);

        DoublyLinkedList<Integer>.Node current = adjacencyList[node].getHeadNode();
        while (current != null) {
            Integer neighbor = current.data;
            if (!visited[neighbor]) {
                dfsUtil(neighbor, adjacencyList, visited, result);
            }
            current = current.nextNode;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(1, 0);
        graph.addEdge(2,1);
        graph.addEdge(2, 3);

        graph.printGraph();

        List<Integer> res = dfsTraversal(graph, 2);
        System.out.println("aaa"+res);
    }
}
