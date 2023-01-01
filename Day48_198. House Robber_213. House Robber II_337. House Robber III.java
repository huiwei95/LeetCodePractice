// 198. House Robber
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i ++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}





// 213. House Robber II
class Solution {

    public int function(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i ++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }


    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int case1 = function(nums, 0, nums.length - 2);
        int case2 = function(nums, 1, nums.length - 1);
        return Math.max(case1, case2);
    }
}





// 337. House Robber III
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int rob(TreeNode root) {
        int[] res = robAction1(root);
        return Math.max(res[0], res[1]);
    }

    int[] robAction1(TreeNode cur) {
        int res[] = new int[2];
        if (cur == null)
            return res;

        int[] left = robAction1(cur.left); // 左
        int[] right = robAction1(cur.right); // 右
        // 中
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 不偷 
        res[1] = cur.val + left[0] + right[0]; // 偷
        return res;
    }
}