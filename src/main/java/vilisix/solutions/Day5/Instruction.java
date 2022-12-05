package vilisix.solutions.Day5;

public class Instruction {
    Integer amount;
    Integer fromIndex;
    Integer toIndex;

    public Instruction(String stringInstruction) {
        String[] split = stringInstruction.split(" ");
        this.amount = Integer.parseInt(split[1]);
        this.fromIndex = Integer.parseInt(split[3]) - 1;
        this.toIndex = Integer.parseInt(split[5]) - 1;
    }
}
