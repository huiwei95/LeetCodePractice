// 122. Best Time to Buy and Sell Stock II
class Solution {
// 贪心思路
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i ++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
}





// 55. Jump Game
class Solution {
// 贪心思路
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true; // 只有一个元素，就是能达到
       int coverRageIndex = 0;
       
       //在覆盖范围内更新最大的覆盖范围
       for (int i = 0; i <= coverRageIndex; i ++) { // 注意这里是小于等于cover
           coverRageIndex = Math.max(coverRageIndex, i + nums[i]);
           if (coverRageIndex >= nums.length - 1) // 说明可以覆盖到终点了
                return true;
       } 
       return false;
    }
}





// 45. Jump Game II
class Solution {
// 贪心思路
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count=0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance,i+nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance>=nums.length-1){
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i==curDistance){
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}