import java.util.ArrayList;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        if (s.isEmpty()) return true;
        ArrayList<Character> lst = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '*') lst.add(c);
            else {
                int i = lst.size() - 1;
                while (i >= 0 && lst.get(i) != '(') {
                    i--;
                }
                if (i >= 0) lst.remove(i); // remove nearest '('.
                else lst.add(')');
            }
        }
        for (char c : lst) {
            System.out.print(c + " ");
        }
        int i = 0;
        int balance = 0;
        while (i < lst.size() && lst.get(i) != '(') {
            if (lst.get(i) == '*') balance++;
            else balance--;
            if (balance < 0) return false;
            i++;
        }
        balance = 0;
        while (i < lst.size()) {
            if (lst.get(i) == '(') balance++;
            else if (balance != 0) balance--;
            i++;
        }
        return balance <= 0;
    }
}
