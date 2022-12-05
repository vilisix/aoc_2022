package vilisix.solutions.Day4;

import vilisix.puzzles.InputReader;

import java.util.ArrayList;

public class Day4 {
    private void SolvePuzzle(ArrayList<String> input) {
        int result_contains = 0;
        int result_overlaps = 0;
        for (String s : input) {
            String[] splitResult = s.split(",");
            String[] lbs = splitResult[0].split("-");
            String[] rbs = splitResult[1].split("-");
            Bounds leftBounds = new Bounds(Integer.parseInt(lbs[0]), Integer.parseInt(lbs[1]));
            Bounds rightBounds = new Bounds(Integer.parseInt(rbs[0]), Integer.parseInt(rbs[1]));

            if(CheckPartOne(leftBounds, rightBounds)){
                result_contains++;
            }

            if(CheckPartTwo(leftBounds, rightBounds)){
                result_overlaps++;
            }
        }
        System.out.println("one part contains other part: " + result_contains);
        System.out.println("one part overlaps other part: " + result_overlaps);
    }

    private boolean CheckPartOne(Bounds leftBounds, Bounds rightBounds) {
        return (leftBounds.GetLength() >= rightBounds.GetLength()) ?
                leftBounds.IsContains(rightBounds) : rightBounds.IsContains(leftBounds);
        }

    private boolean CheckPartTwo(Bounds leftBounds, Bounds rightBounds) {
        return leftBounds.IsOverlaps(rightBounds);
    }

    public static void main(String[] args) {
        Day4 day4 = new Day4();
        day4.SolvePuzzle(InputReader.readInput("input_day_4"));
    }
}
