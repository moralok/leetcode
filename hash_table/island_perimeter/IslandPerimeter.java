package hash_table.island_perimeter;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    // 注意边界检查
                    if (i-1 >= 0 && grid[i-1][j] == 1) {
                        res -= 2;
                    }
                    if (j-1 >= 0 && grid[i][j-1] == 1) {
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int[][] case1 = new int[][] {
            new int[] {0,1,0,0},
            new int[] {1,1,1,0},
            new int[] {0,1,0,0},
            new int[] {1,1,0,0},
        };
        System.out.println(islandPerimeter.islandPerimeter(case1));
    }
}