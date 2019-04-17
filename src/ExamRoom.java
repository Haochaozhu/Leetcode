/**
 * In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.
 *
 * When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.
 * If there are multiple such seats, they sit in the seat with the lowest number.  (Also, if no one is in the room, then the student sits at seat number 0.)
 *
 * Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing what seat the student sat in,
 * and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.
 * It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.
 *
 *
 *
 * Example 1:
 *
 * Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * Output: [null,0,9,4,2,null,5]
 * Explanation:
 * ExamRoom(10) -> null
 * seat() -> 0, no one is in the room, then the student sits at seat number 0.
 * seat() -> 9, the student sits at the last seat number 9.
 * seat() -> 4, the student sits at the last seat number 4.
 * seat() -> 2, the student sits at the last seat number 2.
 * leave(4) -> null
 * seat() -> 5, the student sits at the last seat number 5.
 * ​​​​​​​
 * 0  2      9
 * Note:
 *
 * 1 <= N <= 10^9
 * ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
 * Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
 */
public class ExamRoom {
    int[] seats;
    public ExamRoom(int N) {
        seats = new int[N];
    }

    public int seat() {
        int i = seats.length - 1;
        int maxL = 0;
        int index = 0;
        while (i >= 0) {
            while (i >= 0 && seats[i] == 1) {
                i -= 1;
            }
            int j = i;
            while (i >= 0 && seats[i] == 0) {
                i -= 1;
            }
            if (j == seats.length - 1 || i == -1) {
                int cur = j - i;
                if (cur >= maxL) {
                    maxL = cur;
                    if (i == -1) index = 0;
                    else index = seats.length - 1;
                }
            } else {
                int cur = (j - i + 1) / 2;
                if (cur >= maxL) {
                    maxL = cur;
                    index = (j + i + 1) / 2;
                }
            }
        }
        seats[index] = 1;
        return index;
    }

    public void leave(int p) {
        seats[p] = 0;
    }

    public static void main(String[] args) {
        ExamRoom r1 = new ExamRoom(999999999);

    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
// 0   2     5      9