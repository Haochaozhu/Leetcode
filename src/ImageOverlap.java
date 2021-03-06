import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)
 *
 * We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.
 *
 * (Note also that a translation does not include any kind of rotation.)
 *
 * What is the largest possible overlap?
 *
 * Example 1:
 *
 * Input: A = [[1,1,0],
 *             [0,1,0],
 *             [0,1,0]]
 *        B = [[0,0,0],
 *             [0,1,1],
 *             [0,0,1]]
 * Output: 3
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 * Notes:
 *
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 */
public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        ArrayList<int[]> lstA = new ArrayList<>();
        ArrayList<int[]> lstB = new ArrayList<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) lstA.add(new int[]{i, j});
                if (B[i][j] == 1) lstB.add(new int[]{i, j});
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (int[] a : lstA) {
            for (int[] b : lstB) {
                String cur = b[0] - a[0] + "," + (b[1] - a[1]);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }
        int max = 0;
        for (int val : map.values()) max = Math.max(max, val);
        return max;
    }
}
