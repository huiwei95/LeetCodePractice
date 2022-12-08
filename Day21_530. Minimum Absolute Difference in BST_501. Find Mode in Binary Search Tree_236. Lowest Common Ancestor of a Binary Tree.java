/**
530. Minimum Absolute Difference in BST

递归法
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;

    public void traversal(TreeNode root) {
        if (root == null) return;
        // 左
        traversal(root.left);
        // 中
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        // 右
        traversal(root.right);
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return result;
    }
}





/**
501. Find Mode in Binary Search Tree

递归法
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Integer> resList;
    int count;
    int maxCount;
    TreeNode pre;

    public void findMode1(TreeNode root) {
        if (root == null) return;
        findMode1(root.left); // 左
                              // 中
        if (pre == null) { // 第一个节点
            count = 1;
        } else if (pre.val == root.val) { // 与前一个节点数值相同
            count ++;
        } else { // 与前一个节点数值不同
            count = 1;
        }
        pre = root; // 更新上一个节点

        if (count == maxCount) 
            resList.add(root.val);
        if (count > maxCount) {
            resList.clear();
            resList.add(root.val);
            maxCount = count;
        }
        findMode1(root.right); // 右
    }

    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        count = 0;
        maxCount = 0;
        pre = null;
        findMode1(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i ++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}





/**
236. Lowest Common Ancestor of a Binary Tree

递归法
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);

        if (left == null && right == null) { // 若未找到节点 p 或 q
            return null;
        }else if (left == null && right != null) { // 若找到一个节点
            return right;
        }else if (left != null && right == null) { // 若找到一个节点
            return left;
        }else { // 若找到两个节点
            return root;
        }
    }
}