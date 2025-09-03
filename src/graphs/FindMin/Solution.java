package graphs.FindMin;

class Solution {
/*
    should use BFS

    In an unweighted graph, the first time BFS reaches the destination,
    that path is guaranteed to be the shortest

    BFS naturally works level by level => each level represents destance from the source
    Complexity is O(V+E)
*/

    public static int findMin(Graph g, int src, int dest) {
        // may need use BFS
        int len = g.vertices;
        boolean[] visited = new boolean[len];
        Queue<int[]> q = new Queue<>(len);
        LinkedList<Integer>[] adj = g.adjacencyList;

        visited[src] = true;
        q.enqueue(new int[]{src, 0});
        while (!q.isEmpty()) {
            int[] initNode = q.dequeue();
            if (initNode[0] == dest) {
                return initNode[1];
            }

            LinkedListNode<Integer> node = adj[initNode[0]].head;
            while (node != null) {
                int value = node.data;
                if (!visited[value]) {
                    visited[value] = true;
                    q.enqueue(new int[]{value, initNode[1]+1});
                }
                node = node.next;
            }
        }

        return -1;
    }



    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(0, 3);

        int len = findMin(g, 0, 3);
        System.out.println(len);
    }
}