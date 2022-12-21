package vilisix.solutions.Day8;

import java.util.ArrayList;

public class Forest {
    private static int[][] trees;

    int width, height;

    public Forest(ArrayList<String> input) {
        width = input.get(0).length();
        height = input.size();
        trees = new int[width][height];
        for (int i = 0; i < height; i++) {
            char[] row = input.get(i).toCharArray();
            for (int j = 0; j < width; j++) {
                trees[i][j] = Character.getNumericValue(row[j]);
            }
        }
    }

    public int HiddenAmount(){
        int amount = 0;
        for (int i = 0; i < height; i++){
            for (int j = 0; j < height; j++){
                if(!IsTreeHidden(i, j)){
                    amount++;
                }
            }
        }
        return amount;
    }

    public int MaxScenicScore(){
        int maxScore = 0;
        for (int i = 0; i < height; i++){
            for (int j = 0; j < height; j++){
                int treeScore = ScenicScore(i, j);
                if(treeScore > maxScore){
                    maxScore = treeScore;
                }
            }
        }
        return maxScore;
    }

    private int ScenicScore(int row, int column){
        int ourTreeHeight = trees[row][column];
        return DirectionScenicScore(Direction.NORTH, ourTreeHeight, row, column)
                * DirectionScenicScore(Direction.SOUTH, ourTreeHeight, row, column)
                * DirectionScenicScore(Direction.WEST, ourTreeHeight, row, column)
                * DirectionScenicScore(Direction.EAST, ourTreeHeight, row, column);
    }

    private int DirectionScenicScore(Direction dir, int height, int row, int column){
        int[] offset = dir.getOffset();
        if(IsOnTheBorder(row,column)) return 0;
        int score = 0;
        do {
            row += offset[0];
            column += offset[1];
            score++;
        }while (!IsOnTheBorder(row, column) && trees[row][column] < height);
        return score;
    }

    private boolean IsTreeHidden(int row, int column){
        if(IsOnTheBorder(row,column)) return false;

        int ourTreeHeight = trees[row][column];
        return IsDirectionHidden(Direction.NORTH, ourTreeHeight, row, column)
                && IsDirectionHidden(Direction.SOUTH, ourTreeHeight, row, column)
                && IsDirectionHidden(Direction.WEST, ourTreeHeight, row, column)
                && IsDirectionHidden(Direction.EAST, ourTreeHeight, row, column);
    }

    private boolean IsDirectionHidden(Direction dir, int height, int row, int column){
        int[] offset = dir.getOffset();
        do {
            row += offset[0];
            column += offset[1];
            if(trees[row][column] >= height){
                return true;
            }
        }while (!IsOnTheBorder(row, column));
        return false;
    }

    private boolean IsOnTheBorder(int row, int column){
        if(row == 0 || row == width - 1) return true;
        if(column == 0 || column == height - 1) return true;
        return false;
    }
}
