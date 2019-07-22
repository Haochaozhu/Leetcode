import java.util.*;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following 3-ary tree
 *
 *
 *
 *
 *
 *
 *
 * as [1 [3[5 6] 2 4]]. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 *
 *
 * Note:
 *
 * N is in the range of [1, 1000]
 * Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */


public class SerializeAndDeserializeNaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<String> que = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(que);
    }

    private Node build(Queue<String> que) {
        if (que.isEmpty()) return null;
        String cur = que.poll();
        String size = que.poll();
        int val = Integer.parseInt(cur);
        int sz = Integer.parseInt(size);
        Node root = new Node(val, new ArrayList<Node>());
        for (int i = 0; i < sz; i++) {
            root.children.add(build(que));
        }
        return root;
    }


}
