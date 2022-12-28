// 518. Coin Change II
class Solution {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1; //初始化dp数组，非0下标的初始值为0
        for (int i = 0; i < coins.length; i ++) {
            for (int j = coins[i]; j <= amount; j ++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}





// 377. Combination Sum IV
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j ++) { // 背包
            for (int i = 0; i < nums.length; i ++) { //物品
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}