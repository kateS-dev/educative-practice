package graphs.FindMotherVertex;

public class Solution {
    public static int findMotherVertex(Graph g) {
        // use DFS
        LinkedList<Integer>[] list = g.adjacencyList;
        boolean[] visited = new boolean[list.length];
        boolean[] candidates = new boolean[list.length];
        for (int i = 0; i < list.length; i++) {
            dfsUtil(i, visited, list);
            for (boolean item: visited) {
                if (item == false) {
                    candidates[i] = true;
                }
            }
            visited = new boolean[list.length];
        }

        for (int i = 0; i < candidates.length; i++) {
            if (!candidates[i]) {
                return i;
            }
        }
        return -1;
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