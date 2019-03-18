import java.util.ArrayList;
import java.util.List;

/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"

 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> table = new ArrayList<>();
        for (int i = 1; i <= n; i += 1) {
            table.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i += 1) {
            fact[i] = i * fact[i - 1];
        }
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i -= 1) {
            int index = k / fact[i - 1];
            k %= fact[i - 1];
            sb.append(table.get(index));
            table.remove(index);
        }
        return sb.toString();
    }
}
