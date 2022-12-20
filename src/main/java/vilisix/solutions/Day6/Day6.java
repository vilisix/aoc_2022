package vilisix.solutions.Day6;
import vilisix.reader.InputReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Day6 {

    private void SolvePuzzle(ArrayList<String> input) {
        System.out.println("Part One = " + FindFirstNonRepeatableEntry(input.get(0), 4));
        System.out.println("Part Two = " + FindFirstNonRepeatableEntry(input.get(0), 14));
    }

    private int FindFirstNonRepeatableEntry(String input, int entrySize){
        int result = 0;
        char[] chars = input.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length - entrySize; i++) {
            if(i > entrySize - 1){
                hashMap.computeIfPresent(chars[i - entrySize], (k,v)->
                        v - 1
                );
                if(hashMap.get(chars[i - entrySize]).equals(0)){
                    hashMap.remove(chars[i - entrySize]);
                }
            }
            hashMap.computeIfPresent(chars[i], (k,v)-> v+1);
            hashMap.putIfAbsent(chars[i], 1);

            if(hashMap.size() == entrySize){
                result = i+1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Day6 day6 = new Day6();
        day6.SolvePuzzle(InputReader.readInput("input_day_6"));
    }
}
