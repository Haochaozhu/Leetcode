/**
 * We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same.
 *
 * Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.
 *
 * Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem better:
 *
 * Given the 8 x 8 grid below, we want to construct the corresponding quad tree:
 * It can be divided according to the definition above:
 *
 *
 * The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.
 *
 * For the non-leaf nodes, val can be arbitrary, so it is represented as *.
 */
public class ConstructQuadTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }
    private Node build(int[][] grid, int m, int n, int length) {
        if (length == 1) return new Node(grid[m][n] == 1, true, null, null, null, null);
        Node tl = build(grid, m, n, length / 2);
        Node tr = build(grid, m, n + length / 2, length / 2);
        Node dl = build(grid, m + length / 2, n, length / 2);
        Node dr = build(grid, m + length / 2, n + length / 2, length / 2);
        if (tl.isLeaf && tr.isLeaf && dl.isLeaf && dr.isLeaf) {
            if (tl.val && tr.val && dl.val && dr.val) return new Node(true, true, null, null, null, null);
            if (!tl.val && !tr.val && !dl.val && !dr.val) return new Node(false, true, null, null, null, null);
        }
        return new Node(true, false, tl, tr, dl, dr);
    }
}
