import java.util.HashMap;

/**
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go
downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

10 15 18 21
 **/
public class PathSumIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // if curSum == sum, res gets add up 1.
        return findPath(root, sum, map, 0);
    }

    private int findPath(TreeNode node, int sum, HashMap<Integer, Integer> map, int curSum) {
        if (node == null) return 0;
        curSum += node.val;
        int res = map.getOrDefault(curSum - sum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        res += findPath(node.left, sum, map, curSum) + findPath(node.right, sum, map, curSum);
        map.put(curSum, map.get(curSum) - 1);
        return res;
    }
}
