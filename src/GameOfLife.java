/**
 * According to the Wikipedia's article:
 * "The Game of Life, also known simply as Life, is
 * a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical,
 * diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously.
 *
 * Example:
 *
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int R = board.length, C = board[0].length;
        for (int i = 0; i < R; i += 1) {
            for (int j = 0; j < C; j += 1) {
                int lives = neighbLives(board, i, j);
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Dead cell became alive: 10
                } else {
                    if (lives < 2 || lives > 3) {
                        board[i][j] = 1; // Live cell dies: 01
                    } else {
                        board[i][j] = 3; // Live cell lives: 11
                    }
                }
            }
        }
        for (int i = 0; i < R; i += 1) {
            for (int j = 0; j < C; j += 1) {
                board[i][j] >>= 1;
            }
        }
    }

    private int neighbLives(int[][] board, int r, int c) {
        int count = 0;
        for (int i = r - 1; i <= r + 1; i += 1) {
            for (int j = c - 1; j <= c + 1; j += 1) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                    count += board[i][j] & 1;
                }
            }
        }
        count -= board[r][c] & 1;
        return count;
    }
}
