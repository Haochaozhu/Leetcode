import java.util.HashSet;
import java.util.Set;

/**
 * Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
 *
 * Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.
 *
 *
 *
 * Example 1:
 *
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  There is no way to assign the variables to satisfy both equations.
 * Example 2:
 *
 * Input: ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * Example 3:
 *
 * Input: ["a==b","b==c","a==c"]
 * Output: true
 * Example 4:
 *
 * Input: ["a==b","b!=c","c==a"]
 * Output: false
 * Example 5:
 *
 * Input: ["c==c","b==d","x!=z"]
 * Output: true
 *
 *
 * Note:
 *
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] and equations[i][3] are lowercase letters
 * equations[i][1] is either '=' or '!'
 * equations[i][2] is '='
 */
public class SatisfiabilityOfEqualityEquations {
    class UF {
        int[] sz;
        int[] id;
        UF (int N) {
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
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String s : equations) {
            int a = s.charAt(0) - 'a';
            int b = s.charAt(3) - 'a';
            if (s.charAt(1) == '=') {
                uf.union(a, b);
            }
        }
        for (String s : equations) {
            int a = s.charAt(0) - 'a';
            int b = s.charAt(3) - 'a';
            if (s.charAt(1) == '!') {
                if (a == b) return false;
                if (uf.isConnected(a, b)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<int[]> set = new HashSet<>();
        int[] p = {0, 1};
        set.add(new int[]{0, 1});
        System.out.println(set.contains(p));
    }

}
