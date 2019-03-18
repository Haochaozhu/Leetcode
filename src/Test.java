import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    static void permutation(String str) {
        permutation(str, "");
    }

    static void permutation(String str, String prefix) {
        if (str.length() == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < str.length(); i += 1) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
    public static void main(String[] args) {
        String name = "Haochao";
        StdOut.println(Integer.MAX_VALUE);
    }
}
