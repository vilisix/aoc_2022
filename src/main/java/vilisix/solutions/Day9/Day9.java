package vilisix.solutions.Day9;

import vilisix.reader.InputReader;
import java.util.ArrayList;

public class Day9 {

    private void SolvePuzzle(ArrayList<String> input) {
        Rope shortRope = new Rope(2);
        Rope longRope = new Rope(10);

        for (String command : input) {
            String[] split = command.split(" ");
            Direction direction = switch (split[0]) {
                case "U" -> Direction.UP;
                case "D" -> Direction.DOWN;
                case "L" -> Direction.LEFT;
                case "R" -> Direction.RIGHT;
                default -> throw new IllegalStateException("Unexpected value: " + split[0]);
            };
            int distance = Integer.parseInt(split[1]);
            for (int i = 0; i < distance; i++) {
                shortRope.MoveHead(direction);
                longRope.MoveHead(direction);
            }
        }

        System.out.println("shortRope.GetLastNodeTraceSize() = " + shortRope.GetLastNodeTraceSize());
        System.out.println("longRope.GetLastNodeTraceSize() = " + longRope.GetLastNodeTraceSize());
    }

    public static void main(String[] args) {
        Day9 day9 = new Day9();
        day9.SolvePuzzle(InputReader.readInput("input_day_9"));
    }
}
