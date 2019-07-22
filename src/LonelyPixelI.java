import java.util.HashSet;
import java.util.Set;

/**
 * Given a picture consisting of black and white pixels, find the number of black lonely pixels.
 *
 * The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.
 *
 * A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.
 *
 * Example:
 * Input:
 * [['W', 'W', 'B'],
 *  ['W', 'B', 'W'],
 *  ['B', 'W', 'W']]
 *
 * Output: 3
 * Explanation: All the three 'B's are black lonely pixels.
 * Note:
 * The range of width and height of the input 2D array is [1,500].
 */
public class LonelyPixelI {
    public int findLonelyPixel(char[][] picture) {

        int m = picture.length;
        int n = picture[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    if (dfsLeft(picture, i, j - 1, m, n) && dfsRight(picture, i, j + 1, m, n) &&
                            dfsUp(picture, i - 1, j, m, n) && dfsDown(picture, i + 1, j, m, n)) count++;
                }
            }
        }
        return count;
    }
    private boolean dfsLeft(char[][] pic, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) return true;
        if (pic[i][j] == 'B') {
            pic[i][j] = 'W';
            return false;
        }
        return dfsLeft(pic, i, j - 1, m, n);
    }
    private boolean dfsRight(char[][] pic, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) return true;
        if (pic[i][j] == 'B') {
            pic[i][j] = 'W';
            return false;
        }
        return dfsRight(pic, i, j + 1, m, n);
    }
    private boolean dfsUp(char[][] pic, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) return true;
        if (pic[i][j] == 'B') {
            pic[i][j] = 'W';
            return false;
        }
        return dfsUp(pic, i - 1, j, m, n);
    }
    private boolean dfsDown(char[][] pic, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) return true;
        if (pic[i][j] == 'B') {
            pic[i][j] = 'W';
            return false;
        }
        return dfsDown(pic, i + 1, j, m, n);
    }

}
