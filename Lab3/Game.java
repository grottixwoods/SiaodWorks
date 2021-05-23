package Lab3;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int[][] blocks = new int[][]{{1, 2, 3, 0}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 4}};
        Table initial = new Table(blocks);
        ReshGame solver = new ReshGame(initial);
        System.out.println("Minimum number of moves = " + solver.moves());
        for (Table board : solver.solution())
            System.out.println(board);
    }
}