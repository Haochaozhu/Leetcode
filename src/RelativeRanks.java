import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given scores of N athletes, find their relative ranks and the people with
 * the top three highest scores, who will be awarded medals: "Gold Medal",
 * "Silver Medal" and "Bronze Medal".
 *
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so
 * they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        String[] ans = new String[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i += 1) {
            map.put(nums[i], i);
            pq.add(nums[i]);
        }
        int count = pq.size();
        while (!pq.isEmpty()) {
            int item = pq.poll();
            int index = map.get(item);
            if (count == 1) ans[index] = "Gold Medal";
            else if (count == 2) ans[index] = "Silver Medal";
            else if (count == 3) ans[index] = "Bronze Medal";
            else ans[index] = count + "";
            count -= 1;
        }
        return ans;
    }

}
