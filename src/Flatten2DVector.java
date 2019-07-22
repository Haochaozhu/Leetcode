import java.util.ArrayList;
import java.util.List;

/**
 * Design and implement an iterator to flatten a 2d vector.
 * It should support the following operations: next and hasNext.
 *
 *
 *
 * Example:
 *
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 *
 * iterator.next(); // return 1
 * iterator.next(); // return 2
 * iterator.next(); // return 3
 * iterator.hasNext(); // return true
 * iterator.hasNext(); // return true
 * iterator.next(); // return 4
 * iterator.hasNext(); // return false
 */
public class Flatten2DVector {
    List<Integer> lst;
    int start = 0;
    int size = 0;
    public Flatten2DVector(int[][] v) {
        lst = new ArrayList<>();
        for(int i = 0;i < v.length; i++){
            for(int num : v[i]){
                lst.add(num);
                size++;
            }
        }
    }

    public int next() {
        return lst.get(start++);
    }

    public boolean hasNext() {
        return start < size;
    }

}
