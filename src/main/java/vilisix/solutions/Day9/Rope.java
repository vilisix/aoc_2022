package vilisix.solutions.Day9;

import java.util.ArrayList;
import java.util.HashSet;

public class Rope {

    private final ArrayList<Vector2> nodes;

    private final HashSet<Vector2> lastNodeTrace = new HashSet<>();

    public Rope(int nodesCount) {
        nodes = new ArrayList<>();
        for (int i = 0; i < nodesCount; i++) {
            nodes.add(new Vector2(0,0));
        }
        lastNodeTrace.add(new Vector2(0,0));
    }

    public void MoveHead(Direction dir){
        nodes.get(0).add(dir.getOffset());
        for (int i = 1; i < nodes.size(); i++) {
            Vector2 currentNode = nodes.get(i);
            Vector2 previousNode = nodes.get(i - 1);
            if(currentNode.tooFarFrom(previousNode)){
                currentNode.stepCloser(previousNode);
                nodes.set(i, currentNode);
                if(i == nodes.size() - 1){
                    lastNodeTrace.add(new Vector2(currentNode));
                }
            }
        }
    }

    public int GetLastNodeTraceSize(){
        return lastNodeTrace.size();
    }
}
