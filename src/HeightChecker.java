import java.util.Arrays;

/**
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 *
 * Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 *
 *
 *
 * Example 1:
 *
 * Input: [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Students with heights 4, 3 and the last 1 are not standing in the right positions.
 *
 *
 * Note:
 *
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int count = 0;
        int n = heights.length;
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) copy[i] = heights[i];
        Arrays.sort(copy);
        for (int i = 0; i < n; i++) {
            if (copy[i] != heights[i]) count++;
        }
        return count;
    }
}
