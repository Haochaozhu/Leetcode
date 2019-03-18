/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

 */
public class WordSearch {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i += 1) {
            for (int j = 0; i < board[0].length; j += 1) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int R, int C, String word, int pos) {
        if (pos == word.length()) return true;
        if (R < 0 || R >= board.length || C < 0 || C >= board[0].length || board[R][C] != word.charAt(pos) || visited[R][C]) return false;

        visited[R][C] = true;
        if (dfs(board, R + 1, C, word, pos + 1) ||
            dfs(board, R - 1, C, word, pos + 1) ||
            dfs(board, R, C + 1, word, pos + 1) ||
            dfs(board, R, C - 1, word, pos + 1)) return true;
        visited[R][C] = false;
        return false;
    }
}
