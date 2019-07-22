import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ),
 * the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * The expression string contains only non-negative integers, +, -, *, / operators ,
 * open ( and closing parentheses ) and empty spaces . The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648, 2147483647].
 *
 * Some examples:
 *
 * "1 + 1" = 2
 * " 6-4 / 2 " = 4
 * "2*(5+5*2)/3+(6/2+8)" = 21
 * "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 *
 *
 * Note: Do not use the eval built-in library function.
 */
public class BasicCalculatorIII {
    //TODO
    public int calculate(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> vals = new Stack<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c =='-' || c == '*' || c == '/') {
                ops.push(c);
                vals.push(num);
                num = 0;
            } else if (c == ')') {
                char operator = ops.pop();
                int temp = vals.pop();
                if (operator == '+') {
                    temp += num;
                } else if (operator == '-') {
                    temp -= num;
                } else if (operator == '*') {
                    temp *= num;
                } else if (operator == '/') {
                    temp /= num;
                }
                vals.push(temp);
                num = 0;
            }
        }
        return 0;
    }
}
