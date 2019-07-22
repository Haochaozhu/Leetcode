import java.util.*;

/**
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 *
 * Example 1:
 *
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * Example 2:
 *
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 */
public class GraphValidTree {
    private boolean hasCycle = false;
    public boolean validTree(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, i, graph, visited);
                count++;
            }
        }
        return !hasCycle && count == 1;
    }
    private void dfs(int cur, int prev, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[cur] = true;
        for (int w : graph[cur]) {
            if (!visited[w]) {
                dfs(w, cur, graph, visited);
            } else {
                if (w != prev) hasCycle = true;
            }
        }
    }

}
