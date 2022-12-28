// 416. Partition Equal Subset Sum
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int c : nums) {
            sum += c;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i ++) { // 物品
            for (int j = target; j >= nums[i]; j --) { // 背包
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}