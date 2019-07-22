/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * Example:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 *
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class RangeSumQueryMutable {
    private class SegTreeNode {
        int sum;
        int start;
        int end;
        SegTreeNode left;
        SegTreeNode right;
        SegTreeNode(int sum, int start, int end) {
            this.sum = sum;
            this.start = start;
            this.end = end;
        }
    }

    SegTreeNode root;
    public RangeSumQueryMutable(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }

    private SegTreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new SegTreeNode(nums[l], l, l);
        }
        int mid = l + (r - l) / 2;
        SegTreeNode cur = new SegTreeNode(0, l, r);
        cur.left = build(nums, l, mid);
        cur.right = build(nums, mid + 1, r);
        cur.sum = cur.left.sum + cur.right.sum;
        return cur;
    }

    public void update(int i, int val) {
        update(root, i, val);
    }
    private void update(SegTreeNode cur, int idx, int val) {
        if (cur.start == cur.end) {
            cur.sum = val;
        } else {
            int mid = cur.start + (cur.end - cur.start) / 2;
            if (idx <= mid) {
                update(cur.left, idx, val);
            } else {
                update(cur.right, idx, val);
            }
            cur.sum = cur.left.sum + cur.right.sum;
        }
    }
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegTreeNode cur, int i, int j) {
        if (cur.start == i && cur.end == j) {
            return cur.sum;
        }
        int mid = cur.start + (cur.end - cur.start) / 2;
        if (j <= mid) {
            return sumRange(cur.left, i, j);
        } else if (i >= mid + 1) {
            return sumRange(cur.right, i, j);
        } else {
            return sumRange(cur.right, mid + 1, j) + sumRange(cur.left, i, mid);
        }
    }
}
