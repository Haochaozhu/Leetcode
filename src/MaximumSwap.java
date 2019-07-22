/**
 * Given a non-negative integer, you could swap two digits at
 * most once to get the maximum valued number. Return the maximum valued number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * The given number is in the range [0, 108]
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        String s = Integer.toString(num);
        char[] arr = s.toCharArray();
        int toSwap = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - '0' >= max) {
                    max = arr[j] - '0';
                    toSwap = j;
                }
            }
            if (max > arr[i] - '0') {
                swap(arr, i, toSwap);
                break;
            }
        }
        int ans = 0;
        for (char c : arr) {
            ans *= 10;
            ans += c - '0';
        }
        return ans;
    }
    private void swap(char[] arr , int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
