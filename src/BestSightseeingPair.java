/**
 * Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot,
 * and two sightseeing spots i and j have distance j - i between them.
 *
 * The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) :
 * the sum of the values of the sightseeing spots, minus the distance between them.
 *
 * Return the maximum score of a pair of sightseeing spots.
 *
 *
 *
 * Example 1:
 *
 * Input: [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 * 8 , 1,  5,  2,  6
 * 0   8  11  11  11
 * Note:
 *
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 */
public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        if (A == null || A.length < 2) return 0;
        int maxScore = 0;
        int i = 0, j = A.length - 1;
        while (i < j) {
            int temp = A[i] + A[j] + i - j;
            maxScore = Math.max(maxScore, temp);
            if (A[i] < A[j]) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        return maxScore;
    }
}
