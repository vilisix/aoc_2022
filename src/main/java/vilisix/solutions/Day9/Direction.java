package vilisix.solutions.Day9;

public enum Direction {
    UP, LEFT, DOWN, RIGHT;

    public Vector2 getOffset() {
        return switch (this) {
            case LEFT -> new Vector2(0,1);
            case RIGHT -> new Vector2(0,-1);
            case UP -> new Vector2(-1,0);
            case DOWN -> new Vector2(1,0);
        };
    }
}
