/**
 * Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
 *
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".
 *
 * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
 *
 * We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?
 *
 * Example 1:
 *
 * Input: ["tars","rats","arts","star"]
 * Output: 2
 * Note:
 *
 * A.length <= 2000
 * A[i].length <= 1000
 * A.length * A[i].length <= 20000
 * All words in A consist of lowercase letters only.
 * All words in A have the same length and are anagrams of each other.
 * The judging time limit has been increased for this question.
 */
public class SimilarStringGroups {
    class UF {
        int[] sz;
        int[] id;
        int size;
        UF(int N) {
            id = new int[N];
            sz = new int[N];
            size = N;
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
            if (x == y) return;
            if (sz[x] > sz[y]) {
                id[y] = x;
                sz[x] += sz[y];
            } else {
                id[x] = y;
                sz[y] += sz[x];
            }
            size--;
        }

        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }

    public int numSimilarGroups(String[] A) {
        UF uf = new UF(A.length);
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (check(A[i], A[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.size;
    }

    private boolean check(String A, String B) {
        if (A.equals(B)) return true;
        int diff = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) diff++;
        }
        return diff == 2;
    }

}
