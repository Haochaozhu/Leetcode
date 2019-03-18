
/**
 * You are playing the following Bulls and Cows game with your friend:
 * You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess, you provide a hint that indicates
 * how many digits in said guess match your secret number exactly in both
 * digit and position (called "bulls") and how many digits match the secret number
 * but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess,
 * use A to indicate the bulls and B to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 *
 * Output: "1A3B"
 *
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 *
 * secret: 0 1 2 3 4 5 6 7 8 9
 *           1 1
 * guess:  0 1 2 3 4 5 6 7 8 9
 *         1 2
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * Note: You may assume that the secret number and your friend's guess only contain digits,
 * and their lengths are always equal.
 */
public class BullsAndCows {
    /**
     * Naive approach. Use two tables.
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] tableSecret = new int[10];
        int[] tableGuess = new int[10];
        for (int i = 0; i < secret.length(); i += 1) {
            int s = secret.charAt(i) - '0';
            int g = secret.charAt(i) - '0';
            if (s == g) {
                bulls += 1;
            } else {
                tableSecret[s] += 1;
                tableGuess[g] += 1;
            }
        }
        for (int i = 0; i < tableGuess.length; i += 1) {
            cows += Math.min(tableGuess[i], tableSecret[i]);
        }
        return bulls + "A" + cows + "B";
    }

    /**
     * Use two tables. If i is visited by secret, increment by 1, if visited by guess decrement by 1.
     */
    public String getHint2(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] table = new int[10];
        for (int i = 0; i < secret.length(); i += 1) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls += 1;
            } else {
                //when visited by secret, if table[s] < 0 it's already visited by guess
                if (table[s] < 0) cows += 1;
                if (table[g] > 0) cows += 1;
                table[s] += 1;
                table[g] -= 1;
            }
        }

        return bulls + "A" + cows + "B";
    }


}
