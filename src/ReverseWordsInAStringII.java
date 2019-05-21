/**
 * Given an input string , reverse the string word by word.
 *
 * Example:
 *
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * Follow up: Could you do it in-place without allocating extra space?
 */
public class ReverseWordsInAStringII {
    public void reverseWords(char[] str) {
        int n = str.length;
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i ++) {
            if (str[i] == ' ') {
                swap(str, start, i - 1, sb);
                start = i + 1;
                sb.append(" ");
            }
            if (i == n - 1) swap(str, start, i, sb);
        }
        sb.reverse();
        for (int i = 0; i < str.length; i++) {
            str[i] = sb.charAt(i);
        }
        System.out.println(sb.toString());
    }
    private void swap(char[] str, int l, int r, StringBuilder sb) {
        int L = l, R = r;
        while (l < r) {
            char temp = str[l];
            str[l] = str[r];
            str[r] = temp;
            l++;
            r--;
        }
        for (int i = L; i <= R; i++) {
            sb.append(str[i]);
        }
    }
}
