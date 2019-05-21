import java.util.*;

/**
 * Given a list of 24-hour clock time points in "Hour:Minutes" format,
 * find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for (String s : timePoints) {
            String[] time = s.split(":");
            int hour = Integer.parseInt(time[0]);
            int mins = Integer.parseInt(time[1]);
            int total = hour * 60 + mins;
            minutes.add(total);
        }
        Collections.sort(minutes, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.size(); i++) {
            int diff = minutes.get(i) - minutes.get(i - 1);
            ans = Math.min(ans, diff);
        }
        int corner = 1440 - minutes.get(minutes.size() - 1) + minutes.get(0);
        return Math.min(corner, ans);
    }

    public static void main(String[] args) {
        String s = "23:59";
        System.out.println(Integer.valueOf(s.substring(0,2)) + Integer.valueOf(s.substring(3,5)));
    }
}
// 22:55 - 23:05