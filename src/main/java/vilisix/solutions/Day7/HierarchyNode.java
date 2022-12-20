package vilisix.solutions.Day7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class HierarchyNode {
    private final HashMap<String, HierarchyNode> directories = new HashMap<>();
    private final HashMap<String, Long> files = new HashMap<>();
    private final HierarchyNode parent;

    public HierarchyNode(HierarchyNode parent) {
        this.parent = parent;
    }

    public void Fill(List<String> data){
        for (String hierarchyElement : data) {
            String[] split = hierarchyElement.split(" ");
            if(split[0].equals("dir")){
                directories.put(split[1], new HierarchyNode(this));
            }else {
                files.put(split[1], Long.valueOf(split[0]));
            }
        }
    }

    public HierarchyNode GoUp() {
        return parent;
    }

    public HierarchyNode GoDown(String dir){
        return directories.get(dir);
    }

    public Long GetSize(){
        return files.values().stream().mapToLong(d -> d).sum()
                + directories.values().stream().mapToLong(HierarchyNode::GetSize).sum();
    }

    public Stream<HierarchyNode> stream() {
        if (this.directories.values().isEmpty()) {
            return Stream.of(this);
        } else {
            return this.directories.values().stream()
                    .map(HierarchyNode::stream)
                    .reduce(Stream.of(this), Stream::concat);
        }
    }

    public Long GetSumOfSizesLessThan(Long size){
        return directories.values().stream().filter(v -> v.GetSize() <= size)
                .mapToLong(HierarchyNode::GetSize).sum()
                + directories.values().stream().mapToLong(v -> v.GetSumOfSizesLessThan(size)).sum();
    }

    public Long FindDirSizeClosestTo(Long size) {
        return stream().map(HierarchyNode::GetSize)
                .filter(v -> v > size).min(Comparator.naturalOrder()).get();
    }
}
