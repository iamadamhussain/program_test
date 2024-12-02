package com.app.wise;

public class MaxAreaofIsland {

	/*
	 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:

Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    grid[i][j] is either 0 or 1.






// Approach:
// We use Depth-First Search (DFS) to explore and count the area of each island.
// We iterate through each cell in the grid and, if it is part of an unvisited i
	 */
	
	
	 // Helper method to perform depth-first search (DFS)
    public static int dfs(int row, int col, int[][] visit, int[][] grid) {
        // Mark the current cell as visited
        visit[row][col] = 1;

        // Initialize the area of the current island
        int area = 1;

        // Define the possible moves: up, right, down, left
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};

        // Explore each neighbor
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            // Check if the neighbor is within the grid bounds and is part of the island
            if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && grid[nrow][ncol] == 1 && visit[nrow][ncol] == 0) {
                // Recursively perform DFS on the neighbor
                area += dfs(nrow, ncol, visit, grid);
            }
        }

        // Return the total area of the island
        return area;
    }
    
    
    /* best soulto
     *  public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1) {
                   maxArea = Math.max(maxArea, traverse(grid, i, j));
                }
            }
        }
        return maxArea;
        
    }
    public int traverse(int[][] grid, int row, int col) {
         if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
            return 0;
        }
        int area = 1;
        grid[row][col] = 0;
        area += traverse(grid, row, col + 1);
        area += traverse(grid, row, col -1);
        area += traverse(grid, row + 1, col);
        area += traverse(grid, row - 1, col);
        return area;
    }
     */
    
    /*
     * 
     * private int dfs(int[][] grid, int i, int j, int count){
    if(grid[i][j] == 1){
        grid[i][j] = 2;
        count++;
        if(j >= 1) count = dfs(grid, i, j-1, count);
        if(j < grid[0].length-1) count = dfs(grid, i, j+1, count);
        if(1 <= i) count = dfs(grid, i-1, j, count);
        if(i < grid.length-1) count = dfs(grid, i+1, j, count);
    }
    return count;
}
     */
}
