import java.util.*;

public class cycleDetectionUndirected {

    public static boolean hasCycle(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (checkCycle(i, -1, visited, graph)) return true;
            }
        }
        return false;
    }

    // DFS tracking the parent - in an undirected graph, revisiting a neighbor that ISN'T
    // your immediate parent means you've found a back edge, i.e. a cycle.
    private static boolean checkCycle(int node, int parent, boolean[] visited, List<Integer>[] graph) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                if (checkCycle(neighbor, node, visited, graph)) return true;
            } else if (neighbor != parent) {
                return true; // visited neighbor that isn't our parent -> back edge -> cycle
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] triangle = {{0, 1}, {1, 2}, {2, 0}};
        int[][] line = {{0, 1}, {1, 2}, {2, 3}};
        int[][] star = {{0, 1}, {0, 2}};
        int[][] square = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
        int[][] twoComponents = {{0, 1}, {2, 3}, {3, 4}, {4, 2}};

        System.out.println("Triangle: " + hasCycle(3, triangle) + " (expected: true)");
        System.out.println("Line: " + hasCycle(4, line) + " (expected: false)");
        System.out.println("Star: " + hasCycle(3, star) + " (expected: false)");
        System.out.println("Square: " + hasCycle(4, square) + " (expected: true)");
        System.out.println("Two components, one with a cycle: " + hasCycle(5, twoComponents) + " (expected: true)");
    }
}
