import java.util.List;

/**
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Note: You may assume that the string is well-formed:
 *
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * Example 1:
 *
 * Given s = "324",
 *
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 *
 * Given s = "[123,[456,[789]]]",
 *
 * Return a NestedInteger object containing a nested list with 2 elements:
 *
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 *     i.  An integer containing value 456.
 *     ii. A nested list with one element:
 *          a. An integer containing value 789.
 */
public class MiniParser {
//      public abstract class NestedInteger {
//      // Constructor initializes an empty nested list.
//              public NestedInteger();
//
//              // Constructor initializes a single integer.
//              public NestedInteger(int value);
//
//              // @return true if this NestedInteger holds a single integer, rather than a nested list.
//              public boolean isInteger();
//
//              // @return the single integer that this NestedInteger holds, if it holds a single integer
//              // Return null if this NestedInteger holds a nested list
//              public Integer getInteger();
//
//              // Set this NestedInteger to hold a single integer.
//              public void setInteger(int value);
//
//              // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//              public void add(NestedInteger ni);
//
//              // @return the nested list that this NestedInteger holds, if it holds a nested list
//              // Return null if this NestedInteger holds a single integer
//              public List<NestedInteger> getList();
//      }
//
//    class Solution {
//        public NestedInteger deserialize(String s) {
//            if (s == null || s.isEmpty()) return new NestedInteger();
//            int sign = 1;
//            Stack<NestedInteger> st = new Stack<>();
//            for (int i = 0; i < s.length(); i++) {
//                char cur = s.charAt(i);
//                if (cur == '[') {
//                    st.push(new NestedInteger());
//                } else if (cur == ']' && st.size() > 1) {
//                    NestedInteger temp = st.pop();
//                    st.peek().add(temp);
//                } else if (cur == '-') {
//                    sign = -1;
//                } else if (Character.isDigit(cur)) {
//                    int num = cur - '0';
//                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
//                        num = num * 10 + (s.charAt(i + 1) - '0');
//                        i++;
//                    }
//                    num *= sign;
//                    sign = 1;
//                    if (!st.isEmpty()) {
//                        st.peek().add(new NestedInteger(num));
//                    } else {
//                        st.push(new NestedInteger(num));
//                    }
//                }
//            }
//            return st.isEmpty() ? new NestedInteger() : st.pop();
//        }

    }
