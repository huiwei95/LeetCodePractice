// 1005. Maximize Sum Of Array After K Negations
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 从小到大排序
        for (int c : nums)
        queue.add(c);

        for (int i = 0; i < k; i ++) {
            int smallestNum = queue.poll(); // 弹出最小的
            smallestNum = -smallestNum; // 把最小的变为相反数
            queue.add(smallestNum); // 再塞回PriorityQueue中
        }
        int sum = 0;
        for (Integer c : queue) { // 对queue里面的数字加起来
            sum += c;
        }
        return sum;
    }
}





// 134. Gas Station
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curGasSum = 0;
        int totalSum = 0;
        int start = 0; // declare the index of the gas

        for (int i = 0; i < gas.length; i ++) {
            curGasSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curGasSum < 0) {
                start = i + 1; // 起始位置更新为i+1
                curGasSum = 0;
            }
        }
        if (totalSum < 0) return -1; // 说明怎么走都不可能跑一圈了
        return start;
    }
}





// 135. Candy
class Solution {
/**
分两个阶段
1、起点下标1 从左往右，只要 右边 比 左边 大，右边的糖果=左边 + 1
2、起点下标 ratings.length - 2 从右往左， 只要左边 比 右边 大，此时 左边的糖果应该 取本身的糖果数（符合比它左边大） 和 右边糖果数 + 1 二者的最大值，这样才符合 它比它左边的大，也比它右边大
*/
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candyVec = new int[len];
        candyVec[0] = 1;
        // 从前向后
        for (int i = 1; i < len; i++) {
            candyVec[i] = (ratings[i] > ratings[i - 1]) ? candyVec[i - 1] + 1 : 1;
        }
        // 从后向前
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }
        // 统计结果
        int ans = 0;
        for (int num : candyVec) {
            ans += num;
        }
        return ans;
    }
}