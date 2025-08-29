package graphs.IsTree;

// NOTE: 'Graph' has been created from the class 'Graph' in 'Graph.java'

// class Graph => {int vertices, LinkedList<Integer> adjacencyList[]}
// class LinkedList => {LinkedListNode head}
// class LinkedListNode => {T data, LinkedListNode next}

import java.util.Arrays;

class Solution {
    public static boolean isTree(Graph<Integer> graph) {
        int node = graph.vertices;
        boolean[] visited = new boolean[node];
        boolean[] recStack = new boolean[node];
        Arrays.fill(visited, false);
        Arrays.fill(recStack, false);

        // Start DFS from node 0
        /*
            the reason we only start DFS from node 0 instead of
            looping over all nodes is tied directly to the definition of a tree

            if the graph is a tree, then every node must be reachable from any other node
            so, if we start DFS at 0:
                we will visit every vertex(Trees are connected → one DFS from 0 must visit everything.)
                during the traversel, if there is a cycle, hasCycle will detect it(Trees are acyclic → cycle detection works during that same DFS.)
        */
        if (hasCycle(0, graph.list, visited, recStack)) {
            return false;
        }

        // After DFS, check if all nodes are visited
        for (int i = 0; i < node; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasCycle(int node, LinkedList<Integer>[] adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;
        LinkedListNode<Integer> current = adj[node].head;
        while (current != null) {
            Integer neighbor = current.data;
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, adj, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
               return true;
            }
            current = current.next;
        }
        recStack[node] = false;
        return false;
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

//        [[0,1],[0,2],[0,3],[0,4],[3,4]] false

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(3, 4);

        boolean check = isTree(g);
        System.out.println(check);
    }
}
