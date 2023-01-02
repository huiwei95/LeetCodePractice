// 121. Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
       int[][] dp = new int[prices.length][2];
       dp[0][0] = -prices[0];
       dp[0][1] = 0;
        for (int i = 1; i < prices.length; i ++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]); // dp[i][0]代表第i天持有股票的最大收益
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]); // dp[i][1]代表第i天不持有股票的最大收益
        }
        return dp[prices.length - 1][1];
    }
}





// 122. Best Time to Buy and Sell Stock II
class Solution {
    public int maxProfit(int[] prices) {
       int[][] dp = new int[prices.length][2];
       dp[0][0] = -prices[0];
       dp[0][1] = 0;
        for (int i = 1; i < prices.length; i ++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]-prices[i]); // dp[i][0]代表第i天持有股票的最大收益
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]); // dp[i][1]代表第i天不持有股票的最大收益
        }
        return dp[prices.length - 1][1];
    }
}