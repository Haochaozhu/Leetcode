import java.util.*;

/**
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.
 *
 * We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.
 *
 * Example:
 * Input:
 * routes = [[1, 2, 7], [3, 6, 7]]
 * S = 1
 * T = 6
 * Output: 2
 * Explanation:
 * The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 * Note:
 *
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 500.
 * 0 <= routes[i][j] < 10 ^ 6.
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Queue<Integer> que = new LinkedList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                map.putIfAbsent(stop, new HashSet<>());
                map.get(stop).add(i);
            }
        }
        que.offer(S);
        int change = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int s = 0; s < size; s++) {
                int cur = que.poll();
                if (cur == T) return change;
                for (int routeNum : map.get(cur)) {
                    if (!visited.contains(routeNum)) {
                        visited.add(routeNum);
                        for (int i = 0; i < routes[routeNum].length; i++) {
                            if (routes[routeNum][i] == T) return change + 1;
                            que.offer(routes[routeNum][i]);
                        }
                    }
                }
            }
            change++;
        }
        return -1;
    }
}
