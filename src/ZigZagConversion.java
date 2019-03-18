import java.util.LinkedList;
import java.util.List;

/**
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        boolean backwards = false;
        int j = 0;

        StringBuffer[] res = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i += 1) {
            res[i] = new StringBuffer();
        }

        for (int i = 0; i < s.length(); i += 1) {
            res[j].append(s.charAt(i));
            if (j == numRows - 1) backwards = true;
            if (j == 0) backwards = false;
            if (backwards) j -= 1;
            else j += 1;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < res.length; i += 1) {
            sb = sb.append(res[i]);
        }
        return sb.toString();
    }
}
