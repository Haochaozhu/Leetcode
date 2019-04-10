/**
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A'
 * (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        if (s.length() == 1) return true;
        int absent = 0;
        for (int i = 1; i < s.length() - 1; i += 1) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == 'L') return false;
            if (s.charAt(i) == 'A') absent += 1;
        }
        absent += s.charAt(0) == 'A' ? 1 : 0;
        absent += s.charAt(s.length() - 1) == 'A' ? 1 : 0;
        return absent <= 1;
    }
}
