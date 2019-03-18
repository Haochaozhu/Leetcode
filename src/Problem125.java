/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

 */
public class Problem125 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        String regex = "[^a-zA-Z0-9]";
        StringBuffer sb = new StringBuffer(s.replaceAll(regex, "").toLowerCase());
        return sb.reverse().toString().equals(s.replaceAll(regex, "").toLowerCase());
    }

}
