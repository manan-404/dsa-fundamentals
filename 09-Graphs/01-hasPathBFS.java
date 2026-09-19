import java.util.*;

public class hasPathBFS {

    public static boolean hasPath(int n, int[][] edges, int start, int end) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph[a].add(b);
            graph[b].add(a); // undirected graph
        }

        if (start == end) return true;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.remove();
            for (int neighbor : graph[current]) {
                if (neighbor == end) return true;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("Path 0 -> 2 (triangle, connected): " + hasPath(3, edges1, 0, 2)); // true

        int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        System.out.println("Path 0 -> 5 (two separate components): " + hasPath(6, edges2, 0, 5)); // false
    }
}
