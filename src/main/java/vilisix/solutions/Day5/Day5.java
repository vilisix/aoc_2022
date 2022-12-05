package vilisix.solutions.Day5;
import vilisix.puzzles.InputReader;
import java.util.ArrayList;

public class Day5 {
    private void SolvePuzzle(ArrayList<String> input) {
        ArrayList<String> cratesStrings = new ArrayList<>();
        String indexString = null;
        ArrayList<String> commandsStrings = new ArrayList<>();
        boolean readingToCrates = true;
        for (int i = 0; i < input.size(); i++) {
            if(readingToCrates && input.get(i+1).equals("")){
                indexString = input.get(i++);
                readingToCrates = false;
                continue;
            }
            if(readingToCrates){
                cratesStrings.add(input.get(i));
            }else {
                commandsStrings.add((input.get(i)));
            }
        }

        String[] splitIndexes = indexString.split(" ");
        int stacksSize = Integer.parseInt(splitIndexes[splitIndexes.length - 1]);

        SupplyStorage oldStorage = new SupplyStorage(stacksSize, new CraneSinglePickUp(), cratesStrings);
        for (String s : commandsStrings) {
            oldStorage.HandleInstruction(new Instruction(s));
        }
        System.out.println("CrateMover9000: " + oldStorage.GetTopCrates());

        SupplyStorage newStorage = new SupplyStorage(stacksSize, new CraneMultiPickUp(), cratesStrings);
        for (String s : commandsStrings) {
            newStorage.HandleInstruction(new Instruction(s));
        }
        System.out.println("CrateMover9001: " + newStorage.GetTopCrates());
    }

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        day5.SolvePuzzle(InputReader.readInput("input_day_5"));
    }
}
