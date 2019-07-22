/**
 *
 */
public class MostStonesRemovedWithSameRowOrColumn {
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

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int CG = n;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!uf.isConnected(i, j) && i != j && (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])) {
                    uf.union(i, j);
                    CG--;
                }
            }
        }
        return n - CG;
    }

}
