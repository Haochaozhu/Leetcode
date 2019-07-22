import java.util.*;

/**
 * Given a string of numbers and operators, return all possible results
 * from computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 *
 * Example 1:
 *
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Example 2:
 *
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        if (cur == '+') {
                            ans.add(l + r);
                        }
                        if (cur == '-') {
                            ans.add(l - r);
                        }
                        if (cur == '*') {
                            ans.add(l * r);
                        }
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.parseInt(input));
        }
        return ans;
    }
}
