import java.util.LinkedList;
import java.util.List;

/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n- 1;
        int counter = 0;
        while (true) {
            for (int i = left; i <= right; i += 1) {
                matrix[top][i] = counter;
                counter += 1;
            }
            top += 1;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i += 1) {
                matrix[i][right] = counter;
                counter += 1;
            }
            right -= 1;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i -= 1) {
                matrix[bottom][i] = counter;
                counter += 1;
            }
            bottom -= 1;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i -= 1) {
                matrix[i][left] = counter;
                counter += 1;
            }
            left += 1;
            if (left > right || top > bottom) break;
        }
        return matrix;
    }

}
