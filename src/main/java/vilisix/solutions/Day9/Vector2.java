package vilisix.solutions.Day9;

public class Vector2 {
    public Integer x;
    public Integer y;

    public Vector2(Vector2 copy) {
        this.x = copy.x;
        this.y = copy.y;
    }

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector2 v) {
        this.x += v.x;
        this.y += v.y;
    }

    public boolean tooFarFrom(Vector2 v) {
        int xd = Math.abs(v.x - x);
        int yd = Math.abs(v.y - y);
        return xd > 1 || yd > 1;
    }

    public void stepCloser(Vector2 dst){
        int dx = dst.x - this.x;
        int dy = dst.y - this.y;
        this.x += Math.abs(dx) == 1 ? dx : dx/2;
        this.y += Math.abs(dy) == 1 ? dy : dy/2;
    }

    public static Vector2 add(Vector2 v1, Vector2 v2) {
        return new Vector2(v1.x + v2.x, v1.y + v2.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Vector2 v) {
            return (x.equals(v.x)) && (y.equals(v.y));
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x.hashCode();
        result = prime * result + y.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
