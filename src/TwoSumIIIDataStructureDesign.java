import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class.
 * It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * Example 1:
 *
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * Example 2:
 *
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 */
public class TwoSumIIIDataStructureDesign {
    /** Initialize your data structure here. */
    ArrayList<Integer> lst;
    Map<Integer, Integer> map;
    public TwoSumIIIDataStructureDesign() {
        lst = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        lst.add(number);
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int size = lst.size();
        for (int i = 0; i < size; i++) {
            int a = lst.get(i);
            int b = value - a;
            if ((a == b && map.get(a) >= 2) || (a != b && map.containsKey(b))) return true;
        }
        return false;
    }

}
/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */