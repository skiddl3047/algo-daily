package org.D0905;

import java.util.Arrays;

public class RottingOranges {

    public static void main(String[] args) {
        System.out.println(new RottingOranges().orangesRotting(new int[][] {{2,1,1},{1,1,0},{0,1,1}}));
    }
    public int dfs(int[][] grid, int row, int column, int currentDistanceToRotten) {
        System.out.println("row : "+row+" column : "+column+" currentDistanceToRotten : "+currentDistanceToRotten);
        int n = grid.length;
        int m = grid[0].length;
        if (row < 0 || column < 0 || row >= n || column >= m) {
            return currentDistanceToRotten;
        }
        int currentVal = grid[row][column];
        if (currentVal == 0) {
            return currentDistanceToRotten;
        } else if (currentVal == 2 && currentDistanceToRotten != 0) {
            return currentDistanceToRotten;
        } else if (currentVal != 2) {
            if (currentDistanceToRotten < currentVal && currentVal != 1) {
                return currentDistanceToRotten;
            } else {
                grid[row][column] = currentDistanceToRotten;
                System.out.println("grid["+row+"]["+column+"] = "+grid[row][column]);
            }
        }

        int newDistanceToRotten = dfs(grid, row - 1, column, currentDistanceToRotten - 1);
        newDistanceToRotten = Math.min(newDistanceToRotten, dfs(grid, row + 1, column, currentDistanceToRotten - 1));
        newDistanceToRotten = Math.min(newDistanceToRotten, dfs(grid, row, column - 1, currentDistanceToRotten - 1));
        newDistanceToRotten = Math.min(newDistanceToRotten, dfs(grid, row, column + 1, currentDistanceToRotten - 1));
        return newDistanceToRotten;
    }

    public int orangesRotting(int[][] grid) {

        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }
        if (grid == null || grid.length == 0) return 0;

        int rowLength = grid.length;
        int columnLength = grid[0].length;

        boolean visitRotten = false;
        boolean visitFresh = false;

        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                int val = grid[row][column];
                if (val == 2) {
                    dfs(grid, row, column, 0);
                    visitRotten = true;
                } else if (val == 1 && !visitFresh) {
                    visitFresh = true;
                }
            }
        }
        if (!visitRotten && visitFresh) {
            return -1;
        }
        int min = 0;
        for (int[] rowArray : grid) {
            System.out.println(Arrays.toString(rowArray));
            //for (int column = 0; column < columnLength; column++) {
            for (int val : rowArray) {
                    //int val = rowArray[column];
                    if (val == 1) {
                        return -1;
                    } else if (val < 0 && val < min) {
                        min = val;
                    }
                }
            }
        //}
        return Math.abs(min);
    }
}


