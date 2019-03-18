import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        backTrack(ans, new ArrayList<>(), 0, s);
        return ans;
    }

    private void backTrack(List<List<String>> ans, List<String> temp, int start, String s) {
        if (start == s.length()) ans.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < s.length(); i += 1) {
                if (isPalindrome(s, start, i)) {
                    temp.add(s.substring(start, i + 1));
                    backTrack(ans, temp, i + 1, s);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }
}
