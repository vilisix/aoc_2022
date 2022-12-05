package vilisix.solutions.Day5;

import java.util.Stack;

public class CraneMultiPickUp implements Crane {
    @Override
    public void Move(Stack<Character> fromStack, Stack<Character> toStack, Integer amount) {
        Stack<Character> middleStack = new Stack<>();
        for (int i = 0; i < amount; i++) {
            middleStack.push(fromStack.pop());
        }
        for (int i = 0; i < amount; i++) {
            toStack.push(middleStack.pop());
        }
    }
}
