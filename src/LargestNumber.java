import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * 2 10
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 *
 *
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */


/**
 * 10 2
 * 2 10
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < strings.length; i += 1) {
            strings[i] = nums[i] + "";
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return a.compareTo(b);
            }
        });
        StringBuilder ans = new StringBuilder();
        for (String s : strings) {
            ans.append(s);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"10", "2"};
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }
        });
        for (String s : strings) {
            System.out.print(s);
        }
    }
}
