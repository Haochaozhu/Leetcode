import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is
given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.


 */
public class LetterCombosOfAPhoneNo {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        String[] phoneBook = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTrack(digits, phoneBook, "", ans);
        return ans;
    }
    private void backTrack(String digits, String[] phoneBook, String temp, List<String> ans) {
        if (digits.length() == 0) {
            ans.add(temp);
        } else {
            int index = digits.charAt(0);
            String s = phoneBook[index];
            for (int i = 0; i < s.length(); i += 1) {
                char c = s.charAt(i);
                backTrack(digits.substring(1), phoneBook, temp + c, ans);
            }
        }
    }
}
