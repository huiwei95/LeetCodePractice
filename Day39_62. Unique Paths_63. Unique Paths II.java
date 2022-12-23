// 62. Unique Paths
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // initialize
        for (int i = 0; i < m; i ++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j ++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[i][j] = dp[i - 1][j] + dp [i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}





// 63. Unique Paths II
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; // row
        int n = obstacleGrid[0].length; // column
        int[][] dp = new int[m][n];
        //如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        // initialize
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i ++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j ++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp [i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}