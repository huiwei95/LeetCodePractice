977. Squares of a Sorted Array
/*
977. Squares of a Sorted Array
Two-pointers can compare the value of a number. 
*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ary = new int[nums.length];
        int k = nums.length - 1;
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {	// be careful! = must be written. If left equals right, the value of the nums array can include. Otherwise, not contained.
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                ary[k] = nums[left] * nums[left];
                k --;
                left ++;
            } else {
                ary[k] = nums[right] * nums[right];
                k --;
                right --;
            }
        }
        return ary;
    }
}





/*
209. Minimum Size Subarray Sum
mistake : My mistake is a return error in the last part. If the sum is smaller than the target, I need to output 0. The smart way is that use ==? :三元运算符
MAX_VALUE is a number in the Java Integer сlass of java. lang package. It is the maximum possible Integer number that can be represented in 32 bits. 
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;	
        for (int fast = 0; fast < nums.length; fast ++) {
            sum = sum + nums[fast];
            while (sum >= target) {
                int subLength = fast - slow + 1;
                result = Math.min(result, subLength);
                sum = sum - nums[slow];
                slow ++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}



/*
59. Spiral Matrix II
mistake : if (n % 2 == 1) res[start][start] = count write in while loop. If this command is wrote in the while loop. When I put n = 1, the output is wrong.
Do not forget crreate new array.
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int start = 0;
        int loop = 0;
        int count = 1;
        int i, j;
        int[][] res = new int[n][n];
        
        while (loop++ < n / 2) {
            // only column changes.
            for (j = start; j < n - loop; j ++) {
                res[start][j] = count ++;
            }
            
            // only row changes.
            for (i = start ; i < n - loop; i ++) {
                res[i][j] = count ++;
            }
            
            // only column changes. j starts n - loop
            for (; j >= loop; j --) {
                res[i][j] = count ++;
            }
            
            // only row changes. i starts n - loop
            for (; i >= loop; i --) {
                res[i][j] = count ++;
            }
            
            start ++;            
        }
        if (n % 2 == 1) res[start][start] = count;
        return res;
    }
}