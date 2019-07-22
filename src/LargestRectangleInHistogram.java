import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * \find the area of largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, max = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                max = Math.max(max, heights[st.pop()] * (i - (st.isEmpty() ? 0 : st.peek() + 1)));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            max = Math.max(max, heights[st.pop()] * (n - (st.isEmpty() ? 0 : st.peek() + 1)));
        }
        return max;
    }
}
