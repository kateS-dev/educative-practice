package graphs.IsTree;

import java.util.Arrays;

/*
    directed-graph cycle detection logic cannot apply on undirected tree.
    The back edge to the parent is incorrectly flagged as a cycle.
*/

class Solution {
    public static boolean isTree(Graph<Integer> graph) {
        int node = graph.vertices;
        boolean[] visited = new boolean[node];
        Arrays.fill(visited, false);

        // Start DFS from node 0
        /*
            the reason we only start DFS from node 0 instead of
            looping over all nodes is tied directly to the definition of a tree

            if the graph is a tree, then every node must be reachable from any other node
            so, if we start DFS at 0:
                we will visit every vertex(Trees are connected → one DFS from 0 must visit everything.)
                during the traversel, if there is a cycle, hasCycle will detect it(Trees are acyclic → cycle detection works during that same DFS.)
        */
        if (hasCycle(0, -1, graph.list, visited)) {
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

    private static boolean hasCycle(int node, int parent, LinkedList<Integer>[] adj, boolean[] visited) {
        visited[node] = true;
        LinkedListNode<Integer> current = adj[node].head;
        while (current != null) {
            Integer neighbor = current.data;
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, node, adj, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // visited neighbor and the neighbor is not the parent node(check parent node is to confirm the undirected graph)
                // it means that circle here
               return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph<>(5);

//        [[0,1],[0,2],[0,3],[0,4],[3,4]] false
//        [[0,1],[0,2],[0,3],[3,4]] true

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        boolean check = isTree(g);
        System.out.println(check);
    }
}
