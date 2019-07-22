import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 *
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
 *
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 *
 * Also, there is a given gene "bank", which records all the valid gene mutations.
 * A gene must be in the bank to make it a valid gene string.
 *
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 *
 * Note:
 *
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 *
 *
 * Example 1:
 *
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 *
 * return: 1
 *
 *
 * Example 2:
 *
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 *
 * return: 2
 *
 *
 * Example 3:
 *
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * return: 3
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        que.offer(start);
        visited.add(end);
        int step = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String cur = que.poll();
                if (cur.equals(end)) return step;
                for (String s : bank) {
                    if (oneCharAway(cur, s)) {
                        if (!visited.contains(s)) {
                            visited.add(s);
                            que.offer(s);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
    private boolean oneCharAway(String str, String goal) {
        int diff = 0;
        if (str.length() != goal.length()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != goal.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
