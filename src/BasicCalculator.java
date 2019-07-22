import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ),
 * the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 * 1 - (5 - 6)
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(1);
        int sign = 1;
        int res = 0;
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                cur = cur * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                res += cur * sign;
                sign = st.peek() * (c == '+' ? 1 : -1);
                cur = 0;
            } else if (c == '(') {
                st.push(sign);
            } else if (c == ')') {
                st.pop();
            }
        }
        res += cur * sign;
        return res;
    }

}
