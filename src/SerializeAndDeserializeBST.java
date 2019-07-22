import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection
 * link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on
 * how your serialization/deserialization algorithm should work. You just need to ensure that a binary search
 * tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, root);
        return sb.toString();
    }

    private void dfs(StringBuilder sb, TreeNode cur) {
        if (cur == null) {
            sb.append("null,");
            return;
        }
        sb.append(cur.val).append(",");
        dfs(sb, cur.left);
        dfs(sb, cur.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> que = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(que, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(Queue<String> que, int min, int max) {
        String cur = que.poll();
        if (cur.equals("null")) return null;
        int val = Integer.parseInt(cur);
        if (val < min || val > max) return null;
        TreeNode root = new TreeNode(val);
        root.left = build(que, min, val);
        root.right = build(que, val, max);
        return root;
    }


}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));