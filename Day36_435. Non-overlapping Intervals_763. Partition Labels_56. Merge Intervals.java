// 435. Non-overlapping Intervals
class Solution {
    class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
        return a[1] - b[1];
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        // 按照区间右边界升序排序
        Arrays.sort(intervals, new myComparator());

        int previousEnd = intervals[0][1];
        int count = 1;
        for (int i = 0; i < intervals.length; i ++) {
            if (previousEnd <= intervals[i][0]) {
                count ++;
                previousEnd = intervals[i][1];
            }
        } 
        return intervals.length - count; // 全部的数量- 不重叠的数量 = 重叠的数量
    }
}





// 763. Partition Labels
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndexArray = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            lastIndexArray[s.charAt(i) - 'a'] = i; // 统计每一个字符最后出现的位置
        } 

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i ++) {
            right = Math.max(right, lastIndexArray[s.charAt(i) - 'a']); // 找到字符出现的最远边界
            if (i == right) { // 找到了
                result.add(right - left + 1);
                left = i + 1;
            }
        }
        return result;
    }
}





// 56. Merge Intervals
class Solution {
    public int[][] merge(int[][] intervals) {
        // 排序，按照左边界从小到大
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new LinkedList<>();
        //initial start 是最小左边界
        int start = intervals[0][0];
        int rightMostRightBound = intervals[0][1];
        for (int i = 1; i < intervals.length; i ++) {
             //如果左边界大于最大右边界
             if (intervals[i][0] > rightMostRightBound) {
                 //加入区间 并且更新start
                 res.add(new int[]{start, rightMostRightBound});
                 start = intervals[i][0];
                 rightMostRightBound = intervals[i][1];
             } else {
                 //更新最大右边界
                 rightMostRightBound = Math.max(rightMostRightBound, intervals[i][1]);
             }
        }
        res.add(new int[]{start, rightMostRightBound});
        return res.toArray(new int[res.size()][]);
    }
}