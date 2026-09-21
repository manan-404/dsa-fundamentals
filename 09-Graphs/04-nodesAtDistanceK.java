import java.util.*;

public class nodesAtDistanceK {

    public static List<Integer> findNodesAtDistance(int n, int[][] edges, int start, int k) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        List<Integer> result = new ArrayList<>();
        if (k == 0) {
            result.add(start);
            return result;
        }

        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.remove();
            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[current] + 1;
                    queue.add(neighbor);
                    if (dist[neighbor] == k) {
                        result.add(neighbor);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Tree structure:
        //         0
        //       /   \
        //      1     2
        //     / \   / \
        //    3   4 5   6
        //   /|
        //  7 8   (7 under 3, 8 under 4)
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}};
        int n = 9;

        System.out.println("Nodes at distance 2 from 0: " + findNodesAtDistance(n, edges, 0, 2));
        System.out.println("Nodes at distance 1 from 1: " + findNodesAtDistance(n, edges, 1, 2));
        System.out.println("Nodes at distance 0 from 5: " + findNodesAtDistance(n, edges, 5, 0));
    }
}
