/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.

 */
public class JumpGame {
    public boolean canJumpGreedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i -= 1) {
            if (i + nums[i] >= lastPos) lastPos = i;
        }
        return lastPos == 0;
    }

    public boolean canJumpBackTrack(int[] nums) {
        return backTrack(0, nums);
    }

    private boolean backTrack(int pos, int[] nums) {
        if (pos == nums.length - 1) return true;
        int furthestJump = Math.min(pos + nums[pos], nums.length - 1);
        for (int nextPos = pos + 1; nextPos <= furthestJump; nextPos += 1) {
            if (backTrack(nextPos, nums)) return true;
        }
        return false;
    }

    private enum Index {
        GOOD, BAD, UNKNOWN
    }

    Index[] memo;

    public boolean canJumpDPTopDown(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i += 1) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return backTrackDP(0, nums);
    }

    private boolean backTrackDP(int pos, int[] nums) {
        if (memo[pos] != Index.UNKNOWN) {
            return memo[pos] == Index.GOOD;
        }

        int furthestJump = Math.min(pos + nums[pos], nums.length - 1);
        for (int nextJumpPos = pos + 1; nextJumpPos <= furthestJump; nextJumpPos += 1) {
            if (backTrackDP(nextJumpPos, nums)) {
                memo[pos] = Index.GOOD;
                return true;
            }
        }
        memo[pos] = Index.BAD;
        return false;
    }
}
