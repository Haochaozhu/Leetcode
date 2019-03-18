/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * 1234
 * 5678
 */
public class AddStrings {
    /**
     *  Messy, confusing and unreadable code.
     */
    public String addStrings1(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int i = 1;
        while (num1.length() - i >= 0 && num2.length() - i >= 0) {
            int curSum = num1.charAt(num1.length() - i) - '0' + num2.charAt(num2.length() - i) - '0' + carry;
            carry = curSum >= 10 ? 1 : 0;
            curSum %= 10;
            ans.append(curSum);
            i += 1;
        }
        while (num1.length() - i >= 0) {
            int curSum = num1.charAt(num1.length() - i) - '0' + carry;
            carry = curSum >= 10 ? 1 : 0;
            curSum %= 10;
            ans.append(curSum);
            i += 1;
        }

        while (num2.length() - i >= 0) {
            int curSum = num2.charAt(num2.length() - i) - '0' + carry;
            carry = curSum >= 10 ? 1 : 0;
            curSum %= 10;
            ans.append(curSum);
            i += 1;
        }
        if (carry == 1) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }

    /**
     * After refactoring.
     */
    public String addStrings2(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }

}
