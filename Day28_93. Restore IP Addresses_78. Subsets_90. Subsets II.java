/** 93. Restore IP Addresses */
class Solution {
    List<String> result = new ArrayList<>();

    public Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }

        // 遇到⾮数字字符不合法
        int num = 0;
        for (int i = start; i <= end; i ++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }

            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public void backtracking(String s, int startIndex, int pointSum) {
        // 逗点数量为3时，分隔结束
        if (pointSum == 3) {
             // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }

        for(int i = startIndex; i < s.length(); i ++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointSum ++;
                backtracking(s, i + 2, pointSum);
                pointSum --; // 回溯
                s = s.substring(0, i + 1) + s.substring(i + 2); // 回溯删掉逗点
            } else {
                break;
            }
        }
    } 

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return result; // 算是剪枝了
        backtracking(s, 0, 0);
        return result;
    }
}





/** 78. Subsets */
class Solution {

    List<List<Integer>> result = new ArrayList<>(); // 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>(); // 用来存放符合条件结果

    public void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path)); //「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        if (startIndex >= nums.length) return; //终止条件可不加
        for (int i = startIndex; i < nums.length; i ++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }
}





/** 90. Subsets II */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) return;

        for (int i = startIndex; i < nums.length; i ++) {
            // 而我们要对同一树层使用过的元素进行跳过
            if (i != startIndex && nums[i] == nums[i - 1]) {
                continue;
            } else {
                path.add(nums[i]);
                backtracking(nums, i + 1);
                path.removeLast();
            }
        }
        return;
    } 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }
}