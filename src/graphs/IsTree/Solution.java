package graphs.IsTree;

// NOTE: 'Graph' has been created from the class 'Graph' in 'Graph.java'

// class Graph => {int vertices, LinkedList<Integer> adjacencyList[]}
// class LinkedList => {LinkedListNode head}
// class LinkedListNode => {T data, LinkedListNode next}

import java.util.Arrays;

class Solution {
    public static boolean isTree(Graph<Integer> graph) {
        //detect any node can reach all node
        int node = graph.vertices;
        boolean[] visited = new boolean[node];
        Arrays.fill(visited, false);

        for (int i = 0; i < node; i++) {
            dfsUtil(i, graph.list, visited);
            // check the visited table
            if (!checkVisitedTable(visited)) {
                return false;
            }
            // reset the visited table
            Arrays.fill(visited, false);
        }

        return true;
    }

    private static void dfsUtil(int node, LinkedList<Integer>[] adj, boolean[] visited) {
        visited[node] = true;
        LinkedListNode<Integer> current = adj[node].head;

        while (current != null) {
            Integer neighbor = current.data;
            if (!visited[neighbor]) {
                dfsUtil(neighbor, adj, visited);
            }
            current = current.next;
        }
    }

    private static boolean checkVisitedTable(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Graph g = new Graph<>(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 5);

        boolean check = isTree(g);
        System.out.println(check);
    }
}
