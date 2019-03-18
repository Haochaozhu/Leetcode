import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * Basic naive brute force approach. Simply loop through find all possibilities of two sum.
     */

    public int[] twoSum1(int[] numbers, int target) {
        return null;
    }
    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i += 1) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException();
    }
}
