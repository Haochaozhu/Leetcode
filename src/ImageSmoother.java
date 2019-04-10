/**
 * Given a 2D integer matrix M representing the gray scale of an image,
 * you need to design a smoother to make the gray scale of each cell becomes
 * the average gray scale (rounding down) of all the 8 surrounding cells and itself.
 * If a cell has less than 8 surrounding cells, then use as many as you can.
 *
 * Example 1:
 * Input:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * Output:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note:
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int R = M.length;
        int C = M[0].length;
        int[][] ans = new int[R][C];
        for (int i = 0; i < R; i += 1) {
            for (int j = 0; j < C; j += 1) {
                ans[i][j] = smooth(M, i, j);
            }
        }
        return ans;
    }

    private int smooth(int[][] M, int m, int n) {
        int count = 0;
        int sum = 0;
        for (int i = m - 1; i <= m + 1; i += 1) {
            for (int j = n - 1; j <= n + 1; j += 1) {
                if (i >= 0 && i < M.length && j >= 0 && j < M[0].length) {
                    count += 1;
                    sum += M[i][j];
                }
            }
        }
        return sum / count;
    }

}
