// 77. Combinations

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i ++) { // 优化的地方
            path.add(i); // 处理节点
            backtracking(n, k, i + 1);
            path.removeLast(); // 回溯，撤销处理的节点
        }
    }


    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }
}