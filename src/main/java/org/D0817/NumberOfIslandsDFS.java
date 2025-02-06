package org.D0817;

//Approach - Flood Fill BFS

// well this problem is more like applying bfs on a matrix
// without converting it to adjacency list or matrix

// sometimes people get into the stuff which involves making a
// matrix for directions - might increase the complexity v badly just
// do it like its done here in this solution (its pretty fast)

// Avoid using a queue (can be solved with it too) while the recursive approach is simpler and often faster, it could run into issues with deep recursion if the grid is very large. Using a queue might be safer in such cases.

// its like encountring a 1 and incrementing the island count
// then you set its neighbours 0 via bfs

// We do it because every connected piece of land ("1") will be counted as 1 island only, so on encountering ("1") , would just increment the count and then submerge the whole piece of land and move on as other 1s won't affect the count.

import java.util.Arrays;

public class NumberOfIslandsDFS {

    int rows;
    int columns;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //BFS
        rows=grid.length;
        columns=grid[0].length;
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]=='1'){ //encountered land
                    count++;
                    dfs(grid,i,j); //now i am gonna make every connected piece of land("1") connected to it under water ("0").
                }
            }
        }
        return count;
    }
    // flood-fill by dfs
    public void dfs(char[][] grid, int row, int col){
        //System.out.println(Arrays.deepToString(grid)+" row : "+row+" col : "+col);
        if(row<0 || row>=rows || col<0 || col>=columns || grid[row][col]=='0'){
            return;
        }
        System.out.println(Arrays.deepToString(grid)+" row : "+row+" col : "+col);
        grid[row][col]='0';  //submerge the land
        dfs(grid,row-1,col); // up
        dfs(grid,row+1,col); // down
        dfs(grid,row,col-1); // left
        dfs(grid,row,col+1); // right
    }

    public static void main(String[] args) {

        char[][] pangrid = {
                {'0', '0', '0'},
                {'0', '1', '0'},
                {'0', '0', '1'}
        };
        System.out.println(new NumberOfIslandsDFS().numIslands(pangrid));
        char[][] pangrid1 = {
                {'0', '0', '0'},
                {'0', '1', '0'},
                {'0', '0', '1'}
        };
        System.out.println(new NumberOfIslandsDFS().numIslands(pangrid1));
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };
        System.out.println(new NumberOfIslandsDFS().numIslands(grid));
        char[][] grid1 = {
                {'1', '1'},
                {'0', '0'},
                {'0', '1'}
        };
        System.out.println(new NumberOfIslandsDFS().numIslands(grid1));

        char[][] grid2 = {
                {'1', '0'},
                {'0', '0'},
                {'0', '1'}
        };

        char[][] grid3 = {
                {'1', '0'},
                {'0', '1'},
                {'0', '1'}
        };


    }
}