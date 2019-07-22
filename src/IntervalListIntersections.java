import java.util.*;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> lst = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[i];
            if (a[1] < b[0]) {
                i++;
            } else if (a[0] > b[1]) {
                j++;
            } else {
                lst.add(findIntersect(a, b));
                if (a[1] < b[1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        int[][] res = new int[lst.size()][2];
        for (int k = 0; k < lst.size(); k++) {
            res[k] = lst.get(k);
        }
        return res;
    }

    private static int[] findIntersect(int[] A, int[] B) {
        int[] res = new int[2];
        res[0] = Math.max(A[0], B[0]);
        res[1] = Math.min(A[1], B[1]);
        return res;
    }

    public static void main(String[] args) {
        int[] a = {5, 10};
        int[] b = {1, 5};
        int[] res = findIntersect(a, b);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
