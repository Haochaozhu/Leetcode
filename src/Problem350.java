import java.util.Arrays;
import java.util.LinkedList;

/*
350. Intersection of Two Arrays II
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is
limited such that you cannot load all elements into the memory at once?

 */
public class Problem350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        LinkedList<Integer> lst = new LinkedList<>();

        int p = 0, q = 0;
        while (p < nums1.length && q < nums2.length) {
            if (nums1[p] < nums2[q]) {
                p += 1;
            } else {
                if (nums1[p] > nums2[q]) {
                    q += 1;
                } else {
                    lst.add(nums1[p]);
                    p += 1;
                    q += 1;
                }
            }
        }
        int[] ans = new int[lst.size()];
        for (int i = 0; i < ans.length; i += 1) {
            ans[i] = lst.get(i);
        }
        return ans;
    }

}
