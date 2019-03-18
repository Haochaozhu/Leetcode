import java.util.LinkedList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

L L L R R R
L L R L R R
L L R R L R
L R L L R R
L R L R L R

 */
public class GenerateParentheses {
    private final char LEFT = '(';
    private final char RIGHT = ')';

    public List<String> generateParenthesis(int n) {
        LinkedList<String> ans = new LinkedList<>();
        backTrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backTrack(LinkedList lst, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            lst.add(str);
            return;
        }
        if (open < max) backTrack(lst, str + '(', open + 1, close, max);
        if (close < open) backTrack(lst, str + ')', open, close + 1, max);
    }

}
