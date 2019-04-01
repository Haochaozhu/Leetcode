import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
169. Majority Element
Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement {
    /**
     * Boyer-Moore Voting Algorithm
\     */
    public int majorityElement(int[] nums) {
        int majority = nums[0]; int count = 1;
        for (int i = 1; i < nums.length; i += 1) {
            if (count == 0) {
                majority = nums[i];
                count += 1;
            } else if (nums[i] == majority) {
                count += 1;
            } else count -= 1;
        }
        return majority;
    }
}
