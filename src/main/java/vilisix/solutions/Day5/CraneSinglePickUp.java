package vilisix.solutions.Day5;

import java.util.Stack;

public class CraneSinglePickUp implements Crane {
    @Override
    public void Move(Stack<Character> fromStack, Stack<Character> toStack, Integer amount) {
        for (int i = 0; i < amount; i++) {
            toStack.push(fromStack.pop());
        }
    }
}
