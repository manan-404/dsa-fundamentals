import java.util.*;

public class graphStats {

    public static void countGraph(int n, int[][] edges) {
        System.out.println("Total number of nodes: " + n);
        System.out.println("Total number of edges: " + edges.length);

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.println("\nConnections per node:");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + " has " + graph[i].size() + " connections: " + graph[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Graph 1: Triangle ---");
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        countGraph(3, edges1);

        System.out.println("\n--- Graph 2: Two disconnected components ---");
        int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        countGraph(6, edges2);

        System.out.println("\n--- Graph 3: Single isolated node ---");
        int[][] edges3 = {};
        countGraph(1, edges3);

        System.out.println("\n--- Graph 4: Fully connected (K4) ---");
        int[][] edges4 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}};
        countGraph(4, edges4);
    }
}
