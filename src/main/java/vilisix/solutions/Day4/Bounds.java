package vilisix.solutions.Day4;

public class Bounds {
        Integer left;
        Integer right;

        public Bounds(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }

        public int GetLength(){
            return right - left;
        }

        public boolean IsContains(Bounds other){
            return right >= other.right
                    && left <= other.left;
        }

        public boolean IsOverlaps(Bounds other){
            return left <= other.right
                    && other.left <= right;
        }
    }
