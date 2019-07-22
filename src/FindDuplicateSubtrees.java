import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with same node values.
 *
 * Example 1:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * The following are two duplicate subtrees:
 *
 *       2
 *      /
 *     4
 * and
 *
 *     4
 * Therefore, you need to return above trees' root in the form of a list.
 */
public class FindDuplicateSubtrees {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return ans;
    }

    private String serialize(TreeNode cur) {
        if (cur == null) return "";
        String str = cur.val + serialize(cur.left) + serialize(cur.right);
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2) ans.add(cur);
        return str;
    }
}
