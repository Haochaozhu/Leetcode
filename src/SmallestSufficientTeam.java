import java.util.List;
import java.util.Set;

/**
 * In a project, you have a list of required skills req_skills, and a list of people.  The i-th person people[i] contains a list of skills that person has.
 *
 * Consider a sufficient team: a set of people such that for every required skill in req_skills, there is at least one person in the team who has that skill.  We can represent these teams by the index of each person: for example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
 *
 * Return any sufficient team of the smallest possible size, represented by the index of each person.
 *
 * You may return the answer in any order.  It is guaranteed an answer exists.
 *
 *
 *
 * Example 1:
 *
 * Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
 * Output: [0,2]
 * Example 2:
 *
 * Input: req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * 1 <= req_skills.length <= 16
 * 1 <= people.length <= 60
 * 1 <= people[i].length, req_skills[i].length, people[i][j].length <= 16
 * Elements of req_skills and people[i] are (respectively) distinct.
 * req_skills[i][j], people[i][j][k] are lowercase English letters.
 * It is guaranteed a sufficient team exists.
 */
import java.util.*;
public class SmallestSufficientTeam {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int len = (1 << req_skills.length);
        Set<Integer>[] res = new HashSet[len];
        res[0] = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            map.put(req_skills[i], i);
        }
        for (int i = 0; i < people.size(); i++) {
            int cur = 0;
            for (String s : people.get(i)) {
                cur |= (1 << map.get(s));
            }
            for (int k = 0; k < len; k++) {
                if (res[k] == null) continue;
                Set<Integer> temp = res[k];
                int combined = cur | k;
                if (combined == k) continue;
                if (res[combined] == null || res[combined].size() > temp.size() + 1) {
                    Set<Integer> next = new HashSet<>(temp);
                    next.add(i);
                    res[combined] = next;
                }
            }
        }
        int[] ans = new int[res[len - 1].size()];
        int idx = 0;
        for (int index : res[len - 1]) {
            ans[idx++] = index;
        }
        return ans;
    }
}
