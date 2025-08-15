package graphs.DetectCycleInDirectedGraph;


class Solution {
/*
    key points for detecting a cycle in a directe graph

    * how to track the recursion path during a traversal like DFS

    In a directed graph, a cycle exists if you revisit a node that is
    still in the current recursion stack. (same DFS path)

    Two arrays to save data
    visited[] : to track which nodes have been visited at all
    recStack[] / onPath[] : to track which nodes are in the current DFS call stack
*/
    public static boolean detectCycle(Graph g) {
        LinkedList<Integer>[] list = g.adjacencyList;
        boolean[] visited = new boolean[list.length];
        boolean[] recStack = new boolean[list.length];

        for (int i = 0; i < list.length; i++) {
            if (!visited[i] && hasCycle(i, visited, recStack, list)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(int node, boolean[] visited, boolean[] recStack, LinkedList<Integer>[] list) {
        visited[node] = true;
        recStack[node] = true;
        LinkedListNode<Integer> current = list[node].head;

        while (current != null) {
            Integer neighbor = current.data;
            // never visit this neighbor before any DFS run
            if (!visited[neighbor]) {
                // check if a cycle exists starting from this neighbor
                if (hasCycle(neighbor, visited, recStack, list)) {
                    return true;
                }
            // if the neighbor is visited,
            // need to check is still in the recursion stack (this is a back edge)
            } else if (recStack[neighbor]) {
                return true;
            }
            current = current.next;
        }
        recStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        // [[0,2,1],[],[2,1,0]]
        g.addEdge(0,0);
        g.addEdge(0,2);
        g.addEdge(0,1);
        g.addEdge(2,2);
        g.addEdge(2,1);
        g.addEdge(2,0);

        boolean check = detectCycle(g);
        System.out.println(check);
    }
}
