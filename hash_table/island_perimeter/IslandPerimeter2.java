package hash_table.island_perimeter;

public class IslandPerimeter2 {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) {
            return 1;
        }
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;
        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        IslandPerimeter2 islandPerimeter = new IslandPerimeter2();
        int[][] case1 = new int[][] {
            new int[] {0,1,0,0},
            new int[] {1,1,1,0},
            new int[] {0,1,0,0},
            new int[] {1,1,0,0},
        };
        System.out.println(islandPerimeter.islandPerimeter(case1));
    }
}