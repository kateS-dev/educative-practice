package graphs.CountEdges;

import java.util.List;

/*
    method 2:

    for the undirected graph
    count the sum of the lengths of adjacency lists
    dividing the final sum by 2 => ensure the edge is counted only once
*/

public class Solution {
    public static int countEdges(Graph graph) {
        int count = 0;
        List<List<Integer>> list = graph.adjacency;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> items = list.get(i);
            for (int j = 0; j < items.size(); j++) {
                int item = items.get(j);
                if (item > i) {
                    count++;
                }
            }
        }

        if (count > 0) {
            return count;
        }

        return -1;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 4);

        int res = countEdges(g);
        System.out.println(res);
    }
}
