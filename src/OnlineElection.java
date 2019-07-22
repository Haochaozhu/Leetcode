import java.util.HashMap;
import java.util.Map;

/**
 * In an election, the i-th vote was cast for persons[i] at time times[i].
 *
 * Now, we would like to implement the following query function:
 * TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.
 *
 * Votes cast at time t will count towards our query.
 * In the case of a tie, the most recent vote (among tied candidates) wins.
 *
 *
 *
 * Example 1:
 *
 * Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
 * Output: [null,0,1,1,0,0,1]
 * Explanation:
 * At time 3, the votes are [0], and 0 is leading.
 * At time 12, the votes are [0,1,1], and 1 is leading.
 * At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
 * This continues for 3 more queries at time 15, 24, and 8.
 *
 *
 * Note:
 *
 * 1 <= persons.length = times.length <= 5000
 * 0 <= persons[i] <= persons.length
 * times is a strictly increasing array with all elements in [0, 10^9].
 * TopVotedCandidate.q is called at most 10000 times per test case.
 * TopVotedCandidate.q(int t) is always called with t >= times[0].
 */

public class OnlineElection {
    Map<Integer, Integer> count;
    Map<Integer, Integer> stamp;
    int[] myTimes;
    public OnlineElection(int[] persons, int[] times) {
        myTimes = new int[times.length];
        count = new HashMap();
        stamp = new HashMap();
        int lead = 0;
        for (int i = 0; i < persons.length; i++) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if (i == 0 || count.get(persons[i]) >= count.get(lead)) {
                lead = persons[i];
            }
            stamp.put(times[i], lead);
            myTimes[i] = times[i];
        }
    }

    public int q(int t) {
        if (stamp.containsKey(t)) return stamp.get(t);
        int l = 0;
        int r = myTimes.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (myTimes[mid] < t) l = mid + 1;
            else r = mid - 1;
        }
        return stamp.get(myTimes[r]);
    }

    public static void main(String[] args) {
        System.out.println(1e9);
    }
}
