/** 491. Increasing Subsequences */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (used.contains(nums[i]) || !path.isEmpty() && nums[i] < path.get(path.size() - 1)) {
                continue;
            }
            used.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}





/** 46. Permutations */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums);
            used[i] = false;
            path.removeLast();
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return result;
        used = new boolean[nums.length];
        backtracking(nums);
        return result;
    }
}



// 解法2：通过判断path中是否存在数字，排除已经选择的数字
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return result;
        backtrack(nums, path);
        return result;
    }
    public void backtrack(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        for (int i =0; i < nums.length; i++) {
            // 如果path中已有，则跳过
            if (path.contains(nums[i])) {
                continue;
            } 
            path.add(nums[i]);
            backtrack(nums, path);
            path.removeLast();
        }
    }
}





/** 47. Permutations II */ 
class Solution {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    
    public void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) { // 同层
                continue;
            }
            if (used[i] == true) { // 同树枝
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, used);
            used[i] = false;
            path.removeLast();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return result;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, used);
        return result;
    }
}