/**
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.
 * These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.
 *
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south),
 * then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
 *
 * Return the number of pawns the rook can capture in one move.
 */
public class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; i += 1) {
            for (int j = 0; j < board[0].length; j += 1) {
                if (board[i][j] == 'R') return go(board, i, j);
            }
        }
        return 0;
    }

    private int go(char[][] board, int m, int n) {
        int count = 0;
        for (int i = m + 1; i < board.length; i += 1) {
            if (board[i][n] == 'B') break;
            if (board[i][n] == 'p') {
                count += 1;
                break;
            }
        }
        for (int i = m - 1; i >= 0; i -= 1) {
            if (board[i][n] == 'B') break;
            if (board[i][n] == 'p') {
                count += 1;
                break;
            }
        }
        for (int i = n + 1; i < board[0].length; i += 1) {
            if (board[m][i] == 'B') break;
            if (board[m][i] == 'p') {
                count += 1;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i -= 1) {
            if (board[m][i] == 'B') break;
            if (board[m][i] == 'p') {
                count += 1;
                break;
            }
        }
        return count;
    }
}
