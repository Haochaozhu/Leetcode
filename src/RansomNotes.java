/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNotes {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[128];
        for (int i = 0; i < magazine.length(); i += 1) {
            char c = magazine.charAt(i);
            table[c] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i += 1) {
            char c = ransomNote.charAt(i);
            table[c] -= 1;
            if (table[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
