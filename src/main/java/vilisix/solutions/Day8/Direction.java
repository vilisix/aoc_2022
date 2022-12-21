package vilisix.solutions.Day8;

public enum Direction {
        NORTH, EAST, SOUTH, WEST;

        public int[] getOffset() {
                return switch (this) {
                        case EAST -> new int[]{0, 1};
                        case WEST -> new int[]{0, -1};
                        case NORTH -> new int[]{-1, 0};
                        case SOUTH -> new int[]{1, 0};
                };
        }
}
