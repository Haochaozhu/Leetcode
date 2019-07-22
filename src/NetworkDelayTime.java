import java.util.*;

/**
 * There are N network nodes, labelled 1 to N.
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 *
 * Note:
 *
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            map.putIfAbsent(times[i][0], new HashMap<>());
            map.get(times[i][0]).put(times[i][1], times[i][2]);
        }
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
        pq.offer(new int[]{0, K});
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[1];
            int curDist = cur[0];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if (map.containsKey(curNode)) {
                for (int n : map.get(curNode).keySet()) {
                    if (!visited[n]) {
                        pq.offer(new int[]{curDist + map.get(curNode).get(n), n});
                    }
                }
            }
        }
        return N == 0 ? res : -1;
    }
}
