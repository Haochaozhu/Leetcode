import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a stream of integers and a window size,
 * calculate the moving average of all integers in the sliding window.
 *
 * Example:
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {
    Deque<Integer> dq;
    int capacity;
    int curSize;
    int curSum;
    public MovingAverageFromDataStream(int size) {
        dq = new ArrayDeque<>();
        capacity = size;
        curSize = 0;
        curSum = 0;
    }

    public double next(int val) {
        if (curSize == capacity) {
            curSum -= dq.removeFirst();
            curSum += val;
            dq.add(val);
            return curSum * 1.0 / capacity;
        } else {
            curSum += val;
            curSize++;
            dq.add(val);
            return curSum * 1.0 / curSize;
        }
    }
}
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */