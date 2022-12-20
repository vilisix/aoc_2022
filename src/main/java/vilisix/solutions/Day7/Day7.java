package vilisix.solutions.Day7;
import vilisix.reader.InputReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day7 {
    private void SolvePuzzle(ArrayList<String> input) {
        HierarchyNode root = new HierarchyNode(null);
        HierarchyNode currentNode = null;

        for (int i = 0; i < input.size(); i++) {
            String[] split = input.get(i).split(" ");
            if (split[0].equals("$")) {
                if (split[1].equals("cd")) {
                    currentNode = switch (split[2]) {
                        case "/" -> root;
                        case ".." -> currentNode.GoUp();
                        default -> currentNode.GoDown(split[2]);
                    };
                    continue;
                }
                if (split[1].equals("ls")) {
                    int rangeStart = i + 1;
                    List<String> strings = input.stream().skip(rangeStart)
                            .takeWhile(v -> !v.startsWith("$")).collect(Collectors.toList());
                    i += strings.size();
                    currentNode.Fill(strings);
                }
            }
        }

        long capSize = 100000L;
        System.out.println("root.GetSumOfSizeLessThan = " + root.GetSumOfSizesLessThan(capSize));

        long totalSize = 70000000L;
        long updateSize = 30000000L;

        long targetSizeToDelete = updateSize - (totalSize - root.GetSize());
        Long sizeClosestTo = root.FindDirSizeClosestTo(targetSizeToDelete);
        System.out.println("root.subDirClosestToSize = " + sizeClosestTo);
    }

    public static void main(String[] args) {
        Day7 day7 = new Day7();
        day7.SolvePuzzle(InputReader.readInput("input_day_7"));
    }
}
