import edu.princeton.cs.algs4.In;

/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 * The black pixels are connected, i.e., there is only one black region.
 * Pixels are connected horizontally and vertically. Given the location (x, y)
 * of one of the black pixels, return the area of the smallest (axis-aligned) rectangle
 * that encloses all black pixels.
 *
 * Example:
 *
 * Input:
 * [
 *   "0010",
 *   "0110",
 *   "0100"
 * ]
 * and x = 0, y = 2
 *
 * Output: 6
 */
public class SmallestRectangleEnclosingBlackPixels {
    int minI = Integer.MAX_VALUE, maxI = Integer.MIN_VALUE;
    int minJ = Integer.MAX_VALUE, maxJ = Integer.MIN_VALUE;
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0) {
            return 0;
        }
        dfs(image, x, y, new boolean[image.length][image[0].length]);
        System.out.println(minI);
        System.out.println(maxI);
        System.out.println(minJ);
        System.out.println(maxI);

        return (maxI - minI + 1) * (maxJ - minJ + 1);
    }

    private void dfs(char[][] image, int x, int y, boolean[][] visited) {
        if (x < 0|| y < 0 || x >= image.length || y >= image[0].length || image[x][y] != '1' || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        minI = Math.min(minI, x);
        maxI = Math.max(maxI, x);
        minJ = Math.min(minJ, y);
        maxJ = Math.max(maxJ, y);
        dfs(image, x + 1, y, visited);
        dfs(image, x - 1, y, visited);
        dfs(image, x, y + 1, visited);
        dfs(image, x, y - 1, visited);
    }
}
