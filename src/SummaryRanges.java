import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 *
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 *
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int start = 0, end = 0;
        while (end < nums.length) {
            if (end == nums.length - 1 || nums[end] + 1 < nums[end + 1]) {
                if (end == start) ans.add("" + nums[end]);
                else ans.add(nums[start] + "->" + nums[end]);
                start = end + 1;
            }
            end += 1;
        }
        return ans;
    }
}
