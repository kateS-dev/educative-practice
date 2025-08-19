package graphs.FindMotherVertex;

import java.util.Arrays;

/*
    this is O(V+E) for a full DFS from every vertex
*/

/*
    In a DFS forest, the mother vertex (if it exists) will always be in the last DFS tree finished.

    Method:
    1. Run a DFS over all vertices, keeping track of the last vertex you finish exploring
    2. That vertex is your candidate mother vertex
    3. Run DFS once more from that candidate to verify it reaches all vertices
    4. If it does => candidate is mother vertex; otherwise, there's none
*/

public class Solution2 {
    public static int findMotherVertex(Graph g) {
        // use DFS
        LinkedList<Integer>[] list = g.adjacencyList;
        boolean[] visited = new boolean[list.length];
        int candidates = -1;

        // step1: find candidate (the last vertex never visit before, others will be overwritten)
        for (int i = 0; i < list.length; i++) {
            if (!visited[i]) {
                dfsUtil(i, visited, list);
                candidates = i; // last finished vertex
            }
        }

        // step2: verify candidate (reset the visited array, use the candidate mother vertex to check if there is unvisited vertex)
        Arrays.fill(visited, false);
        dfsUtil(candidates, visited, list);
        for (boolean v: visited) {
            if (!v) {
                return -1;
            }
        }
        return candidates;
    }

    private static void dfsUtil(int node, boolean[] visited, LinkedList<Integer>[] list) {
        visited[node] = true;
        LinkedListNode<Integer> current = list[node].head;
        while (current != null) {
            Integer neighbor = current.data;
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited, list);
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        // [[2,3],[3,2,1],[3,0,2],[2,1]]
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(1,3);
        g.addEdge(1,2);
        g.addEdge(1,1);
        g.addEdge(2,3);
        g.addEdge(2,0);
        g.addEdge(2,2);
        g.addEdge(3,2);
        g.addEdge(3,1);

        int res = findMotherVertex(g);
        System.out.println(res);
    }
}