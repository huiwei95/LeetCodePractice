/** 39. Combination Sum */
class Solution {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i ++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 先进行排序
        backtracking(candidates, target, 0, 0);
        return result;
    }
}





/** 40. Combination Sum II */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i ++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) 
                continue;
            path.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], i + 1);  
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0 , 0);
        return result;
    }
}





/ ** 131. Palindrome Partitioning */
class Solution {

    List<List<String>> result = new ArrayList<>();
    Deque<String> path = new LinkedList<>();

    public boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i ++, j --) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public void backtracking(String s, int startIndex) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            result.add(new ArrayList(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i ++) {
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                path.addLast(str);
            } else {
                continue;
            }

            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }
}