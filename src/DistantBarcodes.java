import java.util.*;

/**
 * In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].
 *
 * Rearrange the barcodes so that no two adjacent barcodes are equal.
 * You may return any answer, and it is guaranteed an answer exists.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,1,1,2,2,2]
 * Output: [2,1,2,1,2,1]
 * Example 2:
 *
 * Input: [1,1,1,1,2,2,3,3]
 * Output: [1,3,1,3,2,1,2,1]
 *
 *
 * Note:
 *
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 */
public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] res = new int[barcodes.length];
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : barcodes) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (int n : barcodes) if (!pq.contains(n)) pq.offer(n);
        Integer prev = -1;
        while (!pq.isEmpty()) {
            int cur = pq.peek();
            pq.poll();
            res[i++] = cur;
            if (map.containsKey(prev) && map.get(prev) > 0) {
                pq.offer(prev);
            }
            map.put(cur, map.get(cur) - 1);
            prev = cur;
        }
        return res;
    }
}
