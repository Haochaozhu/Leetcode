import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:
4,5,9
4,4,8,9,9

Each element in the result must be unique.
The result can be in any order.

 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans = new TreeSet();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p = 0, q = 0;
        while (p <nums1.length && q < nums2.length) {
            if (nums1[p] == nums2[q]) {
                ans.add(nums1[p]);
                p += 1;
                q += 1;
            } else if (nums1[p] > nums2[q]) {
                q += 1;
            } else {
                p += 1;
            }
        }
        int[] res = new int[ans.size()];
        int i = 0;
        for (int number : ans) {
            res[i] = number;
            i += 1;
        }
        return res;
    }

}
