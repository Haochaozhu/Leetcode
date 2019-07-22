/**
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 *
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 *
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 *
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 *
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 *
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 *
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 *
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
import java.util.*;

public class InsertDeleteGetRandomO1 {
    private ArrayList<Integer> lst;
    private Map<Integer, Integer> map;
    private Random rand;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        lst = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, lst.size());
        lst.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        // if the item to be removed is not the last one, swap it with the last one, then remove.
        if (idx < lst.size() - 1) {
            int last = lst.get(lst.size() - 1);
            lst.set(idx, last);
            map.put(last, idx);
        }
        map.remove(val);
        lst.remove(lst.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = rand.nextInt(lst.size());
        return lst.get(idx);
    }

    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> ok = set.iterator();
        System.out.println(ok.next());
        System.out.println(ok.next());
        System.out.println(ok.next());
    }

}
