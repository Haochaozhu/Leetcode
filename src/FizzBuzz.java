import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the
 * multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 *
 * n = 15,
 *
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",if (
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */
public class FizzBuzz {
    /**
     * Naive approach.
     */
    public List<String> fizzBuzz1(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i += 1){
            if (i % 3 == 0 && i % 5 == 0) ans.add("FizzBuzz");
            else if (i % 3 == 0) ans.add("Fizz");
            else if (i % 5 == 0) ans.add("Buzz");
            else ans.add(i + "");
        }
        return ans;
    }

    /**
     * Use string concatenation to avoid messy if else statements.
     */
    public List<String> fizzBuzz2(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i += 1){
            String cur = "";
            if (i % 3 == 0) cur += "Fizz";
            if (i % 5 == 0) cur += "Buzz";
            if (cur.length() == 0) cur += i;
            ans.add(cur);
        }
        return ans;
    }
}
