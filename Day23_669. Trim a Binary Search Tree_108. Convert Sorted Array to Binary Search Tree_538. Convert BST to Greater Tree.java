/**
669. Trim a Binary Search Tree

递归法：
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        // 如果root（当前节点）的元素小于low的数值，那么应该递归右子树，并返回右子树符合条件的头结点
        if (root.val < low) {
            return trimBST(root.right, low, high); // 寻找符合区间[low, high]的节点
        }
        // 如果root(当前节点)的元素大于high的，那么应该递归左子树，并返回左子树符合条件的头结点
        if (root.val > high) {
            return trimBST(root.left, low, high);  // 寻找符合区间[low, high]的节点
        }
        // 接下来要将下一层处理完左子树的结果赋给root->left，处理完右子树的结果赋给root->right
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high); 

        return root;
    }
}





/**
108. Convert Sorted Array to Binary Search Tree

递归法：
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

    // 左闭右闭区间[left, right]
    public TreeNode traversal(int[] nums, int left, int right) {
        // 这里定义的是左闭右闭的区间，所以当区间 left > right的时候，就是空节点了。
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, left, mid - 1);
        root.right = traversal(nums, mid + 1, right);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = traversal(nums, 0, nums.length - 1);
        return root;
    }
}





/**
538. Convert BST to Greater Tree

递归法：
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

    int pre;
    public void traversal(TreeNode cur) {
        if (cur == null) return; // 遇空就终止
        traversal(cur.right);
        cur.val += pre;
        pre = cur.val;
        traversal(cur.left);

    }
    public TreeNode convertBST(TreeNode root) {
        pre  = 0;
        traversal(root);
        return root;
    }
}