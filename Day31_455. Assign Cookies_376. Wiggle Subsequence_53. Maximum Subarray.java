// 455. Assign Cookies
class Solution {
    // 思路1： 优先考虑饼干，小饼干先喂饱小胃口
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int startS = 0; 
        int count = 0;
        for (int i = 0; i < s.length && startS < g.length; i++) {
            if (s[i] >= g[start]) {
                startS++;
                count++;
            }
        }
        return count;
    }
}



class Solution {
    // 思路2： 优先考虑胃口，先喂饱大胃口
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        Arrays.sort(s);
        Arrays.sort(g);
        int count = 0;
        int sIndex = s.length - 1;
        for (int i = g.length - 1; i >= 0; i --) {
            if (sIndex >= 0 && s[sIndex] >= g[i]) {
                count ++;
                sIndex --;
            }
        }
        return count;
    }
}





// 376. Wiggle Subsequence
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) return 1;
        int prediffenerce = 0; // 前一对差值
        int curdifference; // 当前一对差值
        int count = 1; // 记录峰值个数，序列默认序列最右边有一个峰值

        for (int i = 0; i < nums.length - 1; i ++) {
            curdifference = nums[i + 1] - nums[i];
            // 出现峰值
            if (curdifference > 0 && prediffenerce <= 0 || curdifference < 0 && prediffenerce >= 0) {
                count ++;
                prediffenerce = curdifference;
            }
        }
        return count;
    }
}





// 53. Maximum Subarray
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            count += nums[i];
            sum = Math.max(sum, count); // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count <= 0){
                count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
        }
       return sum;
    }
}