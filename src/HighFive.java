/**
 * Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
 *
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 *
 *
 * Note:
 *
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * The IDs of the students is between 1 to 1000
 * The score of the students is between 1 to 100
 * For each student, there are at least 5 scores
 */
import java.util.*;

public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int[] student : items) {
            int id = student[0];
            int score = student[1];
            map.putIfAbsent(id, new ArrayList<>());
            map.get(id).add(score);
        }
        ArrayList<int[]> ans = new ArrayList<>();
        for (int id : map.keySet()) {
            ArrayList<Integer> score = map.get(id);
            Collections.sort(score);
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += score.get(score.size() - 1 - i);
            }
            sum /= 5;
            ans.add(new int[]{id, sum});
        }
        Collections.sort(ans, (a1, a2) -> a1[0] - a2[0]);
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
