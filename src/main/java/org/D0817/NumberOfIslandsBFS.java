package org.D0817;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int rows = grid.length;
            int columns = grid[0].length;
            int num_islands = 0;

            for (int row = 0; row < rows; ++row) {
                for (int column = 0; column < columns; ++column) {
                    if (grid[row][column] == '1') {
                        ++num_islands;
                        grid[row][column] = '0'; // mark as visited
                        Queue<Integer> neighbors = new LinkedList<>();
                        neighbors.add(row * columns + column);
                        while (!neighbors.isEmpty()) {
                            int id = neighbors.remove();
                            int rowPos = id / columns;
                            int colPos = id % columns;
                            if (rowPos - 1 >= 0 && grid[rowPos - 1][colPos] == '1') {
                                neighbors.add((rowPos - 1) * columns + colPos);
                                grid[rowPos - 1][colPos] = '0';
                            }
                            if (rowPos + 1 < rowPos && grid[rowPos + 1][colPos] == '1') {
                                neighbors.add((rowPos + 1) * columns + colPos);
                                grid[rowPos + 1][colPos] = '0';
                            }
                            if (colPos - 1 >= 0 && grid[rowPos][colPos - 1] == '1') {
                                neighbors.add(rowPos * columns + colPos - 1);
                                grid[rowPos][colPos - 1] = '0';
                            }
                            if (colPos + 1 < columns && grid[rowPos][colPos + 1] == '1') {
                                neighbors.add(rowPos * columns + colPos + 1);
                                grid[rowPos][colPos + 1] = '0';
                            }
                        }
                    }
                }
            }
            return num_islands;
        }
}
