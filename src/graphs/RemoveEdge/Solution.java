package graphs.RemoveEdge;

import java.util.List;

public class Solution {
    static Graph removeEdge(Graph graph, int source, int destination) {
        int count = graph.vertices;
        Graph result = new Graph(count);

        List<List<Integer>> adj = graph.adjacency;
        for (int i = 0; i < count; i++) {
            List<Integer> children = adj.get(i);
            while (!children.isEmpty()) {
                if (i != source || i == source && children.get(0) != destination) {
                    result.addEdge(i, children.get(0));
                }
                children.remove(0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2, 3);
        g.addEdge(0, 3);

        g.printAdjacencyList();
        Graph newG = removeEdge(g, 1, 2);
        newG.printAdjacencyList();
    }
}
