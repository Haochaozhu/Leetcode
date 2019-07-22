public class LexicographicallySmallestEquivalentString {
    private class DSU {
        char[] id;
        DSU() {
            id = new char[26];
            for (int i = 0; i < 26; i++) {
                id[i] = (char)('a' + i);
            }
        }
        private char find(char p) {
            while (p != id[p - 'a']) {
                p = id[p - 'a'];
            }
            return p;
        }
        private void union(char p, char q) {
            if (p < q) {
                id[q - 'a'] = p;
            } else {
                id[p - 'a'] = q;
            }
        }
    }
    public String smallestEquivalentString(String A, String B, String S) {
        DSU dsu = new DSU();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                dsu.union(A.charAt(i), B.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            sb.append(dsu.find(c));
        }
        return sb.toString();
    }

}
