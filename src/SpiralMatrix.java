import java.util.LinkedList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        if (matrix.length == 0) return ans;
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        while (true) {
            for (int i = left; i <= right; i += 1) {
                ans.add(matrix[top][i]);
            }
            top += 1;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i += 1) {
                ans.add(matrix[i][right]);
            }
            right -= 1;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i -= 1) {
                ans.add(matrix[bottom][i]);
            }
            bottom -= 1;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i -= 1) {
                ans.add(matrix[i][left]);
            }
            left += 1;
            if (left > right || top > bottom) break;
        }
        return ans;
    }
}
