/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on
the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
Two cells are connected if they are adjacent cells connected horizontally or vertically.


 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        for (int i = 0; i < board[0].length; i += 1) {
            if (board[0][i] == 'O') dfs(0, i, board);
        }

        for (int i = 0; i < board[0].length; i += 1) {
            if (board[board.length - 1][i] == 'O') dfs(board.length - 1, i, board);
        }

        for (int i = 0; i < board.length; i += 1) {
            if (board[i][0] == 'O') dfs(i, 0, board);
        }

        for (int i = 0; i < board.length; i += 1) {
            if (board[i][board[0].length - 1] == 'O') dfs(i, board[0].length - 1, board);
        }

        for (int i = 0; i < board.length; i += 1) {
            for (int j = 0; j < board[0].length; j += 1) {
                if (board[i][j] == '*') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i,int j,char[][] board){
        if(board[i][j] == 'X' || board[i][j] == '*') return;
        board[i][j] = '*';
        if(i+1 < board.length) dfs(i+1,j,board);
        if(i-1 > 0) dfs(i-1,j,board);
        if(j+1 < board[0].length) dfs(i,j+1,board);
        if(j-1 > 0) dfs(i,j-1,board);
    }

}
