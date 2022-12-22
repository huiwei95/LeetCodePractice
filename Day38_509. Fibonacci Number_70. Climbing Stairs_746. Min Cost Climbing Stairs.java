// 509. Fibonacci Number
class Solution {
    public int fib(int n) { // 这里的n是index所指的位置
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}





// 70. Climbing Stairs
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return n; // 因为下面直接对dp[2]操作了，防止空指针
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i ++) {
            dp[i] = dp[i - 1] + dp [i - 2];
        }
        return dp[n];
    }
}





// 746. Min Cost Climbing Stairs
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        // 从下标为 0 或下标为 1 的台阶开始，因此支付费用为0
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i ++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length]; // 到达顶楼所花的时间
    }
}