import java.util.LinkedList;
import java.util.List;

/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

 */

public class PascalSTriangleI {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();

        if (numRows == 0) return res;
        for (int i = 0; i < numRows; i += 1) {
            List<Integer> temp = new LinkedList<>();
            temp.add(1);
            if (i == 0) {
                res.add(temp);
                continue;
            }
            if (i == 1) {
                temp.add(1);
                res.add(temp);
                continue;
            }
            for (int j = 0; j < i - 1; j += 1) {
                temp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}
