/**
 * Given a string S, return the "reversed" string where all characters that
 * are not a letter stay in the same place, and all letters reverse their positions.
 *
 *
 *
 * Example 1:
 *
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 *
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 *
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 *
 * Note:
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        int left = 0, right = S.length() - 1;
        char[] haha = S.toCharArray();
        while (left < right) {
            while (left < right && Character.isLetter(haha[left])) left += 1;
            while (left < right && Character.isLetter(haha[right])) right -=1;
            swap(haha, left, right);
            left += 1;
            right -=1;
        }
        return new String(haha);
    }
    private void swap(char[] haha, int i, int j) {
        char temp = haha[i];
        haha[i] = haha[j];
        haha[j] = temp;
    }

}
