
import java.util.*;

/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 */
public class MergeIntevals {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start < o2.start ? -1 : o1.start == o2.start ? 0 : 1;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        LinkedList<Interval> ans = new LinkedList<>();
        for (Interval interval : intervals) {
            if (ans.isEmpty() || ans.getLast().end < interval.start) ans.add(interval);
            else ans.getLast().end = Math.max(ans.getLast().end, interval.start);
        }
        return ans;
    }
}
