import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an array A of integers, we must modify the array in the
following way: we choose an i and replace A[i] with -A[i],
and we repeat this process K times in total.  (We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.

Example 1:

Input: A = [4,2,3], K = 1
Output: 5

2, 3, 4

-2 -3 -4
Explanation: Choose indices (1,) and A becomes [4,-2,3].
Example 2:

Input: A = [3,-1,0,2], K = 3

-1 0 2 3
Output: 6
Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
Example 3:

Input: A = [2,-3,-1,5,-4], K = 2
Output: 13
Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].

-4 -3 -1 2 5
Note:

1 <= A.length <= 10000
1 <= K <= 10000
-100 <= A[i] <= 100

 */
public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : A) {
            pq.offer(n);
        }
        while (K > 0) {
            pq.offer(-pq.poll());
            K -= 1;
        }
        for (int n : pq) {
            sum += pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(90 / 8);
    }
}
// 1 3 2 6 7 9
// 1 2 3 6 7 9
// [-8,3,-5,-3,-5,-2]
// -8 -5 -5 -3 -2 3
// 6

