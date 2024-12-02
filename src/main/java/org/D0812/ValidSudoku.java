package org.D0812;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        String[][] input1 = new String[][]{
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}};
        String[][] input2 = new String[][]{
                {"8","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}};
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(input1));
        System.out.println(validSudoku.isValidSudoku(input2));
    }

    public boolean isValidSudoku(String[][] board){
        Set<String> seen = new HashSet<>();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j].toCharArray()[0];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }
}
