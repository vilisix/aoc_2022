package vilisix.solutions.Day5;

import java.util.ArrayList;
import java.util.Stack;

public class SupplyStorage {
    private final ArrayList<Stack<Character>> stacks = new ArrayList<>();
    private final Crane crane;

    public SupplyStorage(int size, Crane crane, ArrayList<String> cratesStrings) {
        this.crane = crane;
        for (int i = 0; i < size; i++) {
            stacks.add(new Stack<>());
        }

        for (int i = cratesStrings.size() - 1; i >= 0; i--) {
            int crateIdx = 0;
            var crateSlice = cratesStrings.get(i);
            while (crateIdx * 4 + 1 < crateSlice.length()) {
                char crateChar = crateSlice.charAt(crateIdx * 4 + 1);
                if (crateChar != ' ') {
                    stacks.get(crateIdx).push(crateChar);
                }
                crateIdx++;
            }
        }
    }

    public void HandleInstruction(Instruction instruction) {
        Stack<Character> fromStack = stacks.get(instruction.fromIndex);
        Stack<Character> toStack = stacks.get(instruction.toIndex);
        crane.Move(fromStack, toStack, instruction.amount);
    }

    public String GetTopCrates() {
        StringBuilder result = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            Character character = stack.lastElement();
            if (character != null) {
                result.append(character);
            }
        }
        return result.toString();
    }
}
