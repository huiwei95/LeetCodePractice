// 70. Climbing Stairs
class Solution {
    // 用动态规划（完全背包）
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        int[] weight = {1, 2};
        dp[0] = 1;
        // 背包放外面，物品放里面。这道题是排列问题。order is matter
        for (int j = 0; j <= n; j ++) {
            for (int i = 0; i < weight.length; i ++) {
                if (j >= weight[i]) {
                    dp[j] += dp[j - weight[i]];
                }
            }
        }
        return dp[n];
    }
}





// 322. Coin Change
class Solution {
    // 用动态规划，完全背包问题，历遍顺序组合和排列都可以。这里我用组合
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // initialize
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i ++) {
            dp[i] = max;
        }
        dp[0] = 0;

        // 历遍顺序（组合）先物品后背包
        for (int i = 0; i < coins.length; i ++) {
            for (int j = coins[i]; j <= amount; j ++) {
                // 只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}





// 279. Perfect Squares 
class Solution {
    // 用动态规划写。本题是完全背包，组合和排列历遍都可以。我这里选择组合
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 背包容量大小
        // initialize
        int max = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i ++) {
            dp[i] = max;
        }
        dp[0] = 0;

        // 历遍顺序，先物品后背包
        for (int i = 1; i * i <= n; i ++) {
            for (int j = i * i; j <= n; j ++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}