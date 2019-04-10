/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].
 * An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 */
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 1) return true;
        boolean incre = true;
        boolean decre = true;
        for (int i = 1; i < A.length; i += 1) {
            if (A[i] > A[i - 1]) decre = false;
            if (A[i] < A[i - 1]) incre = false;
        }
        return decre || incre;
    }
}

/**

 1 1 1 0 24 234

 **/