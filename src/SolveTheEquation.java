/**
 * Solve a given equation and return the value of x in the form of string "x=#value".
 * The equation contains only '+', '-' operation, the variable x and its coefficient.
 *
 * If there is no solution for the equation, return "No solution".
 *
 * If there are infinite solutions for the equation, return "Infinite solutions".
 *
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 *
 * Example 1:
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 * Example 2:
 * Input: "x=x"
 * Output: "Infinite solutions"
 * Example 3:
 * Input: "2x=x"
 * Output: "x=0"
 * Example 4:
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 * Example 5:
 * Input: "x=x+2"
 * Output: "No solution"
 */
public class SolveTheEquation {
    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        String left = split[0];
        String right = split[1];
        int[] leftRes = calc(left);
        int[] rightRes = calc(right);
        int leftX = leftRes[0];
        int leftVal = leftRes[1];
        int rightX = rightRes[0];
        int rightVal = rightRes[1];
        leftX -= rightX;
        rightVal -= leftVal;
        if (leftX == 0 && rightVal != 0) return "No solution";
        else if (leftX == 0) return "Infinite solutions";
        return "x=" + rightVal / leftX;
    }
    public int[] calc(String exp) {
        String[] tokens = exp.split("(?=[-+])");
        int[] res =  new int[2];
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x")) res[0] += 1;
            else if (token.equals("-x")) res[0] -= 1;
            else if (token.contains("x")) res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            else res[1] += Integer.parseInt(token);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "x+5-3+x";
        String[] hha = s.split("(?=[-+])");
        for (String str : hha) {
            System.out.print(str + "    ");
        }
    }
 }
