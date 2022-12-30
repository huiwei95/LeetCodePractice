// 139. Word Break
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // s是的长度是背包容量。这里用完全背包。
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // 历遍顺序. 组合排列 所以先背包后物品
        for (int i = 1; i <= s.length(); i ++) {
            for (String word : wordDict) {
                int len = word.length();
                // 判断截取的字是否满足
                if (len <= i && dp[i - len] && word.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}