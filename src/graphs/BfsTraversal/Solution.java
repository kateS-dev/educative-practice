package graphs.BfsTraversal;
import java.util.*;
import java.util.Queue;
/*
    Given a directed graph represented as an adjacency list, graph,
    and an integer, source, which is the starting vertex number,
    return an array of integers, result,
    that contains the order of the graph’s breadth-first traversal starting from the source vertex.public
*/

public class Solution {
   /*
    method 1
       public static List<Integer> bfsTraversal(Graph graph, int source) {
        EduLinkedList<Integer>[] g = graph.adjacencyList;
        List<Integer> res = new ArrayList<>();
        res.add(source);

        int init = 0;
        while (init < res.size() && res.size() < g.length) {
            int initNode = res.get(init);
            for (int i = 0; i < g.length; i++) {
                //find the root node and loop all the children node
                if (i == initNode) {
                    EduLinkedList<Integer>.Node item = g[i].getHeadNode();
                    while (item != null) {
                        res.add(item.data);
                        item = item.nextNode;
                    }
                }
            }
            init++;
        }
        return res;
    }*/

    // method 2
    public static List<Integer> bfsTraversal(Graph graph, int source) {
        EduLinkedList<Integer>[] g = graph.adjacencyList;
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[g.length];
        Queue<Integer> queue = new LinkedList<Integer>();

        // add default source to list
        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int initNode = queue.poll();
            result.add(initNode);

            EduLinkedList<Integer>.Node item = g[initNode].getHeadNode();
            while (item != null) {
                int neighbor = item.data;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
                item = item.nextNode;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(1, 0);
        graph.addEdge(2,1);
        graph.addEdge(2, 3);

        graph.printGraph();

        List<Integer> res = bfsTraversal(graph, 2);
        System.out.println("aaa"+res);
    }
}
