import java.util.*;

public class findAllPathsDFS {

    public static void findAllPaths(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.println("Finding all paths from " + source + " to " + destination + ":");

        boolean[] visited = new boolean[n];
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> allPaths = new ArrayList<>();

        findPathsDFS(source, destination, graph, visited, path, allPaths);

        if (allPaths.isEmpty()) {
            System.out.println("No paths found!");
        } else {
            for (int i = 0; i < allPaths.size(); i++) {
                List<Integer> p = allPaths.get(i);
                StringBuilder sb = new StringBuilder("Path " + (i + 1) + ": ");
                for (int j = 0; j < p.size(); j++) {
                    sb.append(p.get(j));
                    if (j < p.size() - 1) sb.append(" -> ");
                }
                System.out.println(sb);
            }
            System.out.println("Total paths: " + allPaths.size());
        }
    }

    // Backtracking DFS: try every unvisited neighbor, and undo the choice (backtrack) after
    // exploring it fully - this is what lets the same node be reused in a DIFFERENT path.
    private static void findPathsDFS(int current, int destination, List<Integer>[] graph,
                                      boolean[] visited, List<Integer> path,
                                      List<List<Integer>> allPaths) {
        visited[current] = true;
        path.add(current);

        if (current == destination) {
            allPaths.add(new ArrayList<>(path));
        } else {
            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    findPathsDFS(neighbor, destination, graph, visited, path, allPaths);
                }
            }
        }

        // backtrack: undo this node's participation so other paths can use it
        path.remove(path.size() - 1);
        visited[current] = false;
    }

    public static void main(String[] args) {
        System.out.println("--- Line: 0-1-2-3 ---");
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}};
        findAllPaths(4, edges1, 0, 3);

        System.out.println("\n--- Triangle: 0-1-2-0 ---");
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 0}};
        findAllPaths(3, edges2, 0, 2);

        System.out.println("\n--- Square with both diagonals (fully connected K4) ---");
        int[][] edges3 = {{0, 1}, {0, 3}, {0, 2}, {1, 2}, {1, 3}, {2, 3}};
        findAllPaths(4, edges3, 0, 3);
    }
}
