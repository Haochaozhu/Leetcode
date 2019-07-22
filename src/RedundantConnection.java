/**
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 *
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 *
 * Update (2017-09-26):
 * We have overhauled the problem description + test cases and specified clearly the graph is an undirected graph. For the directed graph follow up please see Redundant Connection II). We apologize for any inconvenience caused.
 */
public class RedundantConnection {
    class UF {
        int[] sz;
        int[] id;

        UF(int N) {
            id = new int[N];
            sz = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        int find(int p) {
            while (p != id[p]) p = id[p];
            return p;
        }

        void union(int p, int q) {
            int x = find(p);
            int y = find(q);
            if (sz[x] > sz[y]) {
                id[y] = x;
                sz[x] += sz[y];
            } else {
                id[x] = y;
                sz[y] += sz[x];
            }
        }

        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(1001);
        for (int[] cur : edges) {
            int p = cur[0];
            int q = cur[1];
            if (uf.isConnected(p, q)) return cur;
            uf.union(p, q);
        }
        return null;
    }
}
