package org.D0817;

import java.util.Arrays;

public class MaxAreaOfIsland {


    /*
    Time Complexity: O(R∗C), where R is the number of rows in the given grid,
    and C is the number of columns. We visit every square once.

    Space complexity: O(R∗C), the space used by seen to keep track of visited squares and
    the space used by the call stack during our recursion.
     */
    int rows;
    int columns;
    public int maxAreaOfIslandWithCharInput(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //DFS
        rows=grid.length;
        columns=grid[0].length;
        int maxArea=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]=='1'){ //encountered land
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    // flood-fill by dfs
    public int dfs(char[][] grid, int row, int col){
        //System.out.println(Arrays.deepToString(grid)+" row : "+row+" col : "+col);
        if(row<0 || row>=rows || col<0 || col>=columns || grid[row][col]=='0') {
            return 0;
        }
        // Mark this cell as visited by setting it to '0'
        grid[row][col] = '0';
        // Start with area = 1 (current cell)
        int area = 1;
        System.out.println(Arrays.deepToString(grid)+" row : "+row+" col : "+col+" maxArea : "+area);
        // Check all four directions
        area += dfs(grid, row - 1, col); // up
        area += dfs(grid, row + 1, col); // down
        area += dfs(grid, row, col - 1); // left
        area += dfs(grid, row, col + 1); // right

        return area;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        //System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
        char[][] grid1 = {
                {'1', '1'},
                {'0', '0'},
                {'0', '1'}
        };
        //System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid1));


        char[][] grid2 = {
                {'0','0','1','0','0','0','0','1','0','0','0','0','0'},
                {'0','0','0','0','0','0','0','1','1','1','0','0','0'},
                {'0','1','1','0','1','0','0','0','0','0','0','0','0'},
                {'0','1','0','0','1','1','0','0','1','0','1','0','0'},
                {'0','1','0','0','1','1','0','0','1','1','1','0','0'},
                {'0','0','0','0','0','0','0','0','0','0','1','0','0'},
                {'0','0','0','0','0','0','0','1','1','1','0','0','0'},
                {'0','0','0','0','0','0','0','1','1','0','0','0','0'}
        };

        System.out.println(new MaxAreaOfIsland().maxAreaOfIslandWithCharInput(grid2));

    }
}
