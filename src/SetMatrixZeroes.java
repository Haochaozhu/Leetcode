/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;
        int R = matrix.length;
        int C = matrix[0].length;
        for (int i = 0; i < R; i += 1) {
            if (matrix[i][0] == 0) firstCol = true;
        }
        for (int i = 0; i < C; i += 1) {
            if (matrix[0][i] == 0) firstRow = true;
        }
        for (int i = 1; i < R; i += 1) {
            for (int j = 1; j < C; j += 1) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < R; i += 1) {
            for (int j = 1; j < C; j += 1) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < R; i += 1) {
                matrix[i][0] = 0;
            }
        }
        if (firstRow) {
            for (int i = 0; i < C; i += 1) {
                matrix[0][i] = 0;
            }
        }
    }
}
