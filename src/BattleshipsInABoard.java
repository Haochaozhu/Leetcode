/**
 * Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 */
public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'X') {
                    count++;
                    goDown(board, i + 1, j);
                    goRight(board, i, j + 1);
                } else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        for (char[] cc : board) {
            for (char c : cc) System.out.print(c + "  ");
            System.out.println();
        }
        return count;
    }
    private void goDown(char[][] board, int i, int j) {
        if (i >= board.length) return;
        if (board[i][j] == '.') return;
        board[i][j] = 'O';
        goDown(board, i + 1, j);
    }
    private void goRight(char[][] board, int i, int j) {
        if (j >= board[0].length) return;
        if (board[i][j] == '.') return;
        board[i][j] = 'O';
        goRight(board, i, j + 1);
    }
}
