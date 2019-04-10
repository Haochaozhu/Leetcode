import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        List<Integer>[] lists = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (lists[freq] == null) {
                lists[freq] = new ArrayList<>();
            }
            lists[freq].add(key);
        }
        for (int i = lists.length - 1; ans.size() < k; i -= 1) {
            if (lists[i] != null) ans.addAll(lists[i]);
        }
        return ans;
    }

}
