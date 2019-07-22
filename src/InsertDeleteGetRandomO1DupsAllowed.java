import java.util.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 * Example:
 *
 * // Init an empty collection.
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 * collection.insert(1);
 *
 * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 * collection.insert(1);
 *
 * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 * collection.insert(2);
 *
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 * collection.getRandom();
 *
 * // Removes 1 from the collection, returns true. Collection now contains [1,2].
 * collection.remove(1);
 *
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 */
public class InsertDeleteGetRandomO1DupsAllowed {
    /** Initialize your data structure here. */
    ArrayList<Integer> lst;
    Map<Integer, Set<Integer>> map;
    Random rand;
    public InsertDeleteGetRandomO1DupsAllowed() {
        lst = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the collection.
     * Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (!contains) {
            map.put(val, new LinkedHashSet<>());
        }
        map.get(val).add(lst.size());
        lst.add(val);
        return !contains;
    }

    /** Removes a value from the collection.
     * Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        // For duplicate items, always remove the first occurence.
        int pos = map.get(val).iterator().next();
        map.get(val).remove(pos);
        if (pos < lst. size() - 1) {
            int lastItem = lst.get(lst.size() - 1);
            lst.set(pos, lastItem);
            map.get(lastItem).remove(lst.size() - 1);
            map.get(lastItem).add(pos);
        }
        lst.remove(lst.size() - 1);
        if (map.get(val).isEmpty()) map.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return lst.get(rand.nextInt(lst.size()));
    }
}
