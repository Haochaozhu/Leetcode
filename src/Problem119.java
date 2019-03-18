import java.util.LinkedList;
import java.util.List;

/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

 */
public class Problem119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new LinkedList<>();
        if (rowIndex < 0) return res;
        res.add(1);
        if (rowIndex == 0) return res;
        if (rowIndex == 1) {
            res.add(1);
            return res;
        }

        List<Integer> temp = new LinkedList<>();
        temp.add(1);
        temp.add(1);

        for (int i = 1; i < rowIndex; i += 1) {
            res = new LinkedList<>();
            res.add(1);
            for (int j = 0; j < i; j += 1) {
                res.add(temp.get(j) + temp.get(j + 1));
            }
            res.add(1);
            temp = res;
        }
        return res;
    }
}
