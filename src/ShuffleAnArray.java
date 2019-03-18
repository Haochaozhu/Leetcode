/*
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result.
Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */


import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    private int[] save;
    public ShuffleAnArray(int[] nums) {
        save = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return save.clone();
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] temp = save.clone();
        Random rand = new Random();
        for (int i = temp.length - 1; i > 0; i -= 1) {
            int j = rand.nextInt(i + 1);
            swap(temp, j, i);
        }
        return temp;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


