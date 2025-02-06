package blind75.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    /*
    Time Complexity Analysis
Grid Initialization:
Scanning the entire grid takes O(rows×columns).

BFS Process:
In the worst-case, every cell is processed once (either as a fresh or rotten orange). Therefore, the BFS takes O(rows×columns).

Overall Time Complexity:
Combining both steps, the overall time complexity is: O(rows×columns)

Space Complexity Analysis
Queue Storage:
In the worst-case, the queue could hold a significant fraction of the cells.
For example, if the grid is full of oranges that all eventually become rotten, the queue might hold up to
O(rows×columns) elements in the worst-case scenario.

Additional Storage:
The grid itself is given as input.The dirs array is constant space  O(1).

Overall Space Complexity:
The dominant extra space is used by the queue, so the space complexity is: O(rows×columns)

Summary
Time Complexity: O(m×n) where m is the number of rows and n is the number of columns in the grid.

Space Complexity: O(m×n) in the worst-case due to the queue.
This algorithm efficiently simulates the rotting process using BFS and ensures that every cell is processed a limited number of times.
     */
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int countFreshOrange = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2)
                    q.offer(new int[] {i, j});
                if (grid[i][j] == 1)
                    countFreshOrange++;
            }
        }
        if (countFreshOrange == 0)
            return 0;
        if (q.isEmpty())
            return -1;

        int minutes = -1;
        int[][] dirs = {{1, 0},{-1, 0},{0, -1},{0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cell = q.poll();
                int rowPosition = cell[0];
                int columnPosition = cell[1];
                for (int[] dir : dirs) {
                    int i = rowPosition + dir[0];
                    int j = columnPosition + dir[1];
                    if (i >= 0 && i < rows && j >= 0 && j < columns && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        countFreshOrange--;
                        q.offer(new int[] {i, j});
                    }
                }
            }
            minutes++;
        }
        if (countFreshOrange == 0)
            return minutes;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new RottingOranges().orangesRotting(new int[][] {{2,1,0},
                                                                            {0,0,0},
                                                                            {0,1,2}
        }));

        System.out.println(new RottingOranges().orangesRotting(new int[][] {{2,1,0},{0,0,0},{0,1,1}}));
        System.out.println(new RottingOranges().orangesRotting(new int[][] {{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println(new RottingOranges().orangesRotting(new int[][] {{2,1,1},{0,1,1},{1,0,1}}));
        System.out.println(new RottingOranges().orangesRotting(new int[][] {{0,2}}));
    }
}
