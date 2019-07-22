/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int[] count = new int[nums1.length + nums2.length];
        int idx = 0;
        while (i < nums1.length || j < nums2.length) {
            int p = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int q = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;
            System.out.println(idx);
            if (p > q) {
                count[idx++] = q;
                j++;
            } else {
                count[idx++] = p;
                i++;
            }
        }
        if ((count.length % 2 == 0)) {
            return (count[count.length / 2] + count[count.length / 2 - 1]) * 0.5;
        }
        return count[count.length / 2] * 1.0;
    }
}
