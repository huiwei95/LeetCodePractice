// 1049. Last Stone Weight II
class Solution {
    public int lastStoneWeightII(int[] stones) {
        // 求出stones里面的重量总和
        int sum = 0;
        for(int c : stones) {
            sum += c;
        }
        // 分为重量相近的两堆石头，我求的是其中的一堆
        int target = sum / 2;
        int[] dp = new int[target + 1]; 
        for (int i = 0; i < stones.length; i ++) { // 遍历物品
            for (int j = target; j >= stones[i]; j --) { // 遍历背包
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }
}





// 494. Target Sum
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (Math.abs(target) > sum) return 0; // 此时没有方案
        if ((target + sum) % 2 != 0) return 0;
        int size = (target + sum) / 2;
        if(size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}





// 474. Ones and Zeroes
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1]; // m，n是背包容量
        int oneNum, zeroNum;
        // 把String数组中的每个string的0和1 个数统计下
        for (String s : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeroNum ++;
                } else {
                    oneNum ++;
                }
            }
            for (int i = m; i >= zeroNum; i --) {
                for (int j = n; j >= oneNum; j --) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}