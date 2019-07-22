/**
 * Given two numbers arr1 and arr2 in base -2, return the result of adding them together.
 *
 * Each number is given in array format:  as an array of 0s and 1s,
 * from most significant bit to least significant bit.
 * For example, arr = [1,1,0,1] represents the number (-2)^3 + (-2)^2 + (-2)^0 = -3.
 * A number arr in array format is also guaranteed to have no leading zeros: either arr == [0] or arr[0] == 1.
 *
 * Return the result of adding arr1 and arr2 in the same format: as an array of 0s and 1s with no leading zeros.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * Output: [1,0,0,0,0]
 * Explanation: arr1 represents 11, arr2 represents 5, the output represents 16.
 *
 *
 * Note:
 *
 * 1 <= arr1.length <= 1000
 * 1 <= arr2.length <= 1000
 * arr1 and arr2 have no leading zeros
 * arr1[i] is 0 or 1
 * arr2[i] is 0 or 1
 */
public class AddingTwoNegabinaryNumbers {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = m - 1, j = n - 1;  carry != 0 ||i >= 0 || j >= 0; i--, j --) {
            int a = i >= 0 ? arr1[i] : 0;
            int b = j >= 0 ? arr2[j] : 0;
            carry += a + b;
            sb.append(carry & 1);
            carry = -(carry >> 1);
        }
        String s = sb.reverse().toString();
        s = s.replaceAll("^0+", "");
        if (s.length() == 0) return new int[]{0};
        int[] ans = new int[s.length()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = s.charAt(i) - '0';
        }
        return ans;

        // int m = arr1.length - 1;
        // int a = 0;
        // int l1 = m;
        // int n = arr2.length - 1;
        // int l2 = n;
        // int b = 0;
        // for (int i = 0; i < arr1.length; i++) {
        //     a += Math.pow(-2, m) * arr1[i];
        //     m--;
        // }
        // for (int i = 0; i < arr2.length; i++) {
        //     b += Math.pow(-2, n) * arr2[i];
        //     n--;
        // }
        // int sum = a + b;
        // ArrayList<Integer> lst = new ArrayList<>();
        // while (sum != 0) {
        //     lst.add(sum & 1);
        //     sum = -(sum >> 1);
        // }
        // int[] ans = new int[lst.size()];
        // for (int i = 0; i < lst.size(); i++) {
        //     ans[i] = lst.get(lst.size() - 1 - i);
        // }
        // return ans.length == 0 ? new int[]{0} : ans;
    }

}
