/**216. Combination Sum III*/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public void backtracking(int k, int targetSum, int sum, int startIndex) {
        if (sum > targetSum) // 剪枝
            return;

        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new LinkedList<>(path));               
            }
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i ++) { // 剪枝
            sum += i;
            path.add(i);
            backtracking(k, targetSum, sum, i + 1);
            sum -= i;
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
            backtracking(k, n, 0, 1);
            return result;
    }
}





/**17. Letter Combinations of a Phone Number*/
class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder s = new StringBuilder();

    public void backtracking(String digits, String[] numString, int numIndex) {
        if (numIndex == digits.length()) {
            result.add(s.toString());
            return;
        }
        // s 表示当前num对应的字符串
        String str = numString[digits.charAt(numIndex) - '0'];
        for (int i = 0; i < str.length(); i ++) {
            s.append(str.charAt(i));
            backtracking(digits, numString, numIndex + 1);
            s.deleteCharAt(s.length() - 1);
        }

    }

    public List<String> letterCombinations(String digits) {
        String[] numString = {
            " ", // 0
            " ", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
        } ;

        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtracking(digits, numString, 0);
        return result;
    }
}
