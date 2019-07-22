/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 *
 * Example 1:
 *
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 *
 *      0          3
 *      |          |
 *      1 --- 2    4
 *
 * Output: 2
 * Example 2:
 *
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 *
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 *
 * Output:  1
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
import java.util.*;
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
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
                bfs(i, graph, visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int v, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[v] = true;
        for (int neighb : graph[v]) {
            if (!visited[neighb]) {
                dfs(neighb, graph, visited);
            }
        }
    }
    private void bfs(int v, ArrayList<Integer>[] graph, boolean[] visited) {
        Queue<Integer> que = new LinkedList<>();
        que.add(v);
        visited[v] = true;
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int neighb : graph[cur]) {
                if (!visited[neighb]) {
                    que.add(neighb);
                    visited[neighb] = true;
                }
            }
        }
    }

}
