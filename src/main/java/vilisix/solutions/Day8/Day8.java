package vilisix.solutions.Day8;
import vilisix.reader.InputReader;

import java.util.ArrayList;

public class Day8 {
    private void SolvePuzzle(ArrayList<String> input) {
        Forest forest = new Forest(input);
        System.out.println("forest.HiddenAmount() = " + forest.HiddenAmount());
        System.out.println("forest.MaxScenicScore() = " + forest.MaxScenicScore());
    }

    public static void main(String[] args) {
        Day8 day8 = new Day8();
        day8.SolvePuzzle(InputReader.readInput("input_day_8"));
    }
}
