import java.util.*;

/**
 * Consider a directed graph, with nodes labelled 0, 1, ..., n-1.  In this graph, each edge is either red or blue, and there could be self-edges or parallel edges.
 *
 * Each [i, j] in red_edges denotes a red directed edge from node i to node j.  Similarly, each [i, j] in blue_edges denotes a blue directed edge from node i to node j.
 *
 * Return an array answer of length n, where each answer[X] is the length of the shortest path from node 0 to node X such that the edge colors alternate along the path (or -1 if such a path doesn't exist).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * Output: [0,1,-1]
 * Example 2:
 *
 * Input: n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * Output: [0,1,-1]
 * Example 3:
 *
 * Input: n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * Output: [0,-1,-1]
 * Example 4:
 *
 * Input: n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * Output: [0,1,2]
 * Example 5:
 *
 * Input: n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * Output: [0,1,1]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 */
public class ShortestPathWithAlternatingColors {

    int[] ans;

    class Node {
        int idx;
        int color;
        Node(int idx, int color) {
            this.idx = idx;
            this.color = color;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer, Map<Integer, Integer>> G = new HashMap<>();
        ans = new int[n];
        for (int i = 0; i < red_edges.length; i++) {
            int from = red_edges[i][0];
            int to = red_edges[i][1];
            G.putIfAbsent(from, new HashMap<>());
            G.get(from).put(to, G.get(from).getOrDefault(to, 0) + 1);
        }
        for (int i = 0; i < blue_edges.length; i++) {
            int from = blue_edges[i][0];
            int to = blue_edges[i][1];
            G.putIfAbsent(from, new HashMap<>());
            G.get(from).put(to, G.get(from).getOrDefault(to, 0) + 2);
        }
        Arrays.fill(ans, -1);
        bfs(G, n - 1);
        ans[0] = 0;
        return ans;
    }

    private void bfs(Map<Integer, Map<Integer, Integer>> G, int destination) {
        Queue<Node> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        que.offer(new Node(0, 0));

        int step = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node cur = que.poll();
                if (ans[cur.idx] == -1) ans[cur.idx] = step;
                else ans[cur.idx] = Math.min(ans[cur.idx], step);
                Map<Integer, Integer> nbs = G.get(cur.idx);
                if (nbs == null) continue;
                for (int w : nbs.keySet()) {
                    if (cur.color == 0) {
                        if (nbs.get(w) == 3) {
                            que.offer(new Node(w, 2));
                            que.offer(new Node(w, 1));
                            visited.add(0 + "," + w + "," + 2);
                            visited.add(0 + "," + w + "," + 1);
                        } else if (nbs.get(w) == 2) {
                            que.offer(new Node(w, 2));
                            visited.add(0 + "," + w + "," + 2);
                        } else if (nbs.get(w) == 1) {
                            que.offer(new Node(w, 1));
                            visited.add(0 + "," + w + "," + 1);
                        }
                    } else if (cur.color == 1) {
                        if (nbs.get(w) == 3 || nbs.get(w) == 2) {
                            if (!visited.contains(cur.idx + "," + w + "," + 2)) {
                                que.offer(new Node(w, 2));
                                visited.add(cur.idx + "," + w + "," + 2);
                            }
                        }
                    } else if (cur.color == 2) {
                        if (nbs.get(w) == 3 || nbs.get(w) == 1) {
                            if (!visited.contains(cur.idx + "," + w + "," + 1)) {
                                que.offer(new Node(w, 1));
                                visited.add(cur.idx + "," + w + "," + 1);
                            }
                        }
                    }
                }
            }
            step++;
        }
    }

}
/**
 *
 *
 *
 5
 [[2,0],[4,3],[4,4],[3,0],[1,4]]
 [[2,1],[4,3],[3,1],[3,0],[1,1],[2,0],[0,3],[3,3],[2,3]]


 *

 */
