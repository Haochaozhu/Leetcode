import java.util.*;

/**
 * Design a Snake game that is played on a device with screen size = width x height.
 * Play the game online if you are not familiar with the game.
 *
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 *
 * You are given a list of food's positions in row-column order.
 * When a snake eats the food, its length and the game's score both increase by 1.
 *
 * Each food appears one by one on the screen.
 * For example, the second food will not appear until the first food was eaten by the snake.
 *
 * When a food does appear on the screen, it is guaranteed that it will not appear
 * on a block occupied by the snake.
 *
 * Example:
 *
 * Given width = 3, height = 2, and food = [[1,2],[0,1]].
 *
 * Snake snake = new Snake(width, height, food);
 *
 * Initially the snake appears at position (0,0) and the food at (1,2).
 *
 * |S| | |
 * | | |F|
 *
 * snake.move("R"); -> Returns 0
 *
 * | |S| |
 * | | |F|
 *
 * snake.move("D"); -> Returns 0
 *
 * | | | |
 * | |S|F|
 *
 * snake.move("R"); -> Returns 1 (Snake eats the first food and right after that,
 * the second food appears at (0,1) )
 *
 * | |F| |
 * | |S|S|
 *
 * snake.move("U"); -> Returns 1
 *
 * | |F|S|
 * | | |S|
 *
 * snake.move("L"); -> Returns 2 (Snake eats the second food)
 *
 * | |S|S|
 * | | |S|
 *
 * snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */
public class DesignSnakeGame {
    LinkedList<int[]> snake;
    int i;
    int j;
    int width;
    int height;
    int score;
    int[][] food;
    Set<Integer> set;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public DesignSnakeGame(int width, int height, int[][] food) {
        set = new HashSet<>();
        this.food = food;
        snake = new LinkedList<>();
        this.width = width;
        this.height = height;
        i = 0;
        j = 0;
        snake.offer(new int[]{0, 0});
        set.add(0);
        score = 0;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (direction.equals("U")) i--;
        if (direction.equals("D")) i++;
        if (direction.equals("L")) j--;
        if (direction.equals("R")) j++;
        if (outOfBound(i, j)) {
            return -1;
        }
        int[] prev = snake.removeFirst();
        int val = prev[0] * width + prev[1];
        set.remove(val);
        if (set.contains(i * width + j)) return -1;
        snake.addLast(new int[]{i, j});
        set.add(i * width + j);
        if (score < food.length && food[score][0] == i && food[score][1] == j) {
            score++;
            snake.addFirst(prev);
            return score;
        }
        return score;
    }
    private boolean outOfBound(int i, int j) {
        System.out.println("here");
        return i < 0 || j < 0 || i >= height || j >= width;
    }

    public static void main(String[] args) {
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
