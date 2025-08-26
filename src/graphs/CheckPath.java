package graphs;
import java.util.*;

/*
    check if a path exists between two vertices
*/

public class CheckPath {
    public static boolean checkPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];

        // transfer the array to arraylist
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        return dfsUtil(adj, source, destination, visited);
    }

    private static boolean dfsUtil(List<List<Integer>> adj, int current, int destination, boolean[] visited) {
        visited[current] = true;

        for (Integer edge: adj.get(current)) {
            if (edge == destination) {
                return true;
            } else if (!visited[edge] && dfsUtil(adj, edge, destination, visited)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {
            {0, 1},
            {0, 2},
            {0, 4},
            {0, 5}
        };

        boolean check = checkPath(6, edges, 0, 5 );
        System.out.println(check);
    }
}
