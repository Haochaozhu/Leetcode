import java.util.ArrayList;

/**
 * There are N students in a class. Some of them are friends, while some are not.
 * Their friendship is transitive in nature.
 * For example, if A is a direct friend of B, and B is a direct friend of C, then A is an
 * indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1,
 * then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 *
 * Example 1:
 * Input:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * Example 2:
 * Input:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * Note:
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 */
public class FriendCircles {
    private class Graph {
        int v;
        int e;
        ArrayList<Integer>[] adj;
        Graph(int v) {
            this.v = v;
            for (int i = 0; i < v; i += 1) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        int connectedComponents() {
            int count = 0;
            boolean[] visited = new boolean[v];
            for (int i = 0; i < v; i += 1) {
                if (!visited[i]) {
                    dfs(i, visited);
                    count += 1;
                }
            }
            return count;
        }
        void dfs(int n, boolean[] visited) {
            visited[n] = true;
            for (int w : adj[n]) {
                if (!visited[w]) {
                    dfs(w, visited);
                }
            }
        }
    }
    public int findCircleNum(int[][] M) {
        Graph g = new Graph(M.length);
        for (int i = 0; i < M.length; i += 1) {
            for (int j = 0; j < M[0].length; j += 1) {
                if (M[i][j] == 1 && i != j) g.addEdge(i, j);
            }
        }
        return g.connectedComponents();
    }

}

/**      0 1 2 3
      0  X 0 0 1
      1  0 X 1 0
      2  0 1 1 1
      3  1 0 1 1
 **/