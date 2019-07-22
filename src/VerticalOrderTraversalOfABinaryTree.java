import java.util.*;
public class VerticalOrderTraversalOfABinaryTree {
    private class Node implements Comparable<Node> {
        int x;
        int y;
        int val;

        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y == o.y) {
                return Integer.compare(this.val, o.val);
            } else {
                return Integer.compare(this.y, o.y);
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<Integer> temp;
        for (int key : map.keySet()) {
            List<Node> lst = map.get(key);
            Collections.sort(lst);
            temp = new ArrayList<>();
            for (Node n : lst) {
                temp.add(n.val);
            }
            ans.add(temp);
        }
        return ans;
    }

    private void dfs(TreeNode cur, int x, int y, Map<Integer, List<Node>> map) {
        if (cur == null) {
            return;
        }
        dfs(cur.left, x - 1, y + 1, map);
        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(new Node(x, y, cur.val));
        dfs(cur.right, x  + 1, y + 1, map);
    }


}
