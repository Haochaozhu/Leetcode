import java.util.*;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers.
 * If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values,
 * vector<pair<string, string>> queries , where equations.size() == values.size(),
 * and the values are positive. This represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 *
 * The input is always valid. You may assume that evaluating the queries will result in no
 * division by zero and there is no contradiction.
 */
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> G = new HashMap<>();
        String u, v;
        for (int i = 0; i < equations.length; i++) {
            u = equations[i][0];
            v = equations[i][1];
            G.putIfAbsent(u, new HashMap<>());
            G.get(u).put(v, values[i]);
            G.putIfAbsent(v, new HashMap<>());
            G.get(v).put(u, 1 / values[i]);
        }

        double[] ans = new double[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] =dfs(G, queries[i][0], queries[0][1], new HashSet<>());
        }
        return ans;
    }

    private double dfs(Map<String, Map<String, Double>> G, String u, String v, Set<String> visited) {
        if (!G.containsKey(u)) return -1;
        if (G.get(u).containsKey(v)) return G.get(u).get(v);
        visited.add(u);
        for (Map.Entry<String, Double> m : G.get(u).entrySet()) {
            if (!visited.contains(m.getKey())) {
                double res = dfs(G, m.getKey(), v, visited);
                if (res != -1) return res *= m.getValue();
            }
        }
        return -1;
    }
}
