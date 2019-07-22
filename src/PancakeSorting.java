import java.util.*;

public class PancakeSorting {
    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int x = A.length, i; x > 0; --x) {
            for (i = 0; A[i] != x; ++i);
            reverse(A, i + 1);
            res.add(i + 1);
            reverse(A, x);
            res.add(x);
        }
        return res;
    }

    public static void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] a = {1,3,2,5,4,8,6,7};
        pancakeSort(a);
    }

}
