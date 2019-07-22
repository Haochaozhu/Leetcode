public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        int X = 0;
        int O = 0;
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == 'X') X++;
                if (c == 'O') O++;
            }
        }
        if (X < O || X > O + 1) return false;
        boolean XWin = canWin(board, 'X');
        boolean OWin = canWin(board, 'O');
        if (XWin && OWin) return false;
        else if (OWin) return O == X;
        else if (XWin) return X == O + 1;
        return true;
    }

    private boolean canWin(String[] board, char target) {
        // check rows.
        for (int i = 0; i < board.length; i++) {
            String cur = board[i];
            if (cur.charAt(0) == cur.charAt(1) && cur.charAt(0) == cur.charAt(2)
                    && cur.charAt(0) == target) {
                return true;
            }
        }
        // check cols.
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == board[1].charAt(i)
                    && board[0].charAt(i) == board[2].charAt(i) && board[0].charAt(i) == target) {
                return true;
            }
        }
        if (board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2) &&
        board[0].charAt(0) == target) {
            return true;
        }
        if (board[0].charAt(2) == board[1].charAt(1) && board[0].charAt(2) == board[2].charAt(0) &&
                board[0].charAt(2) == target) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.print(1 << 0);
    }
}
