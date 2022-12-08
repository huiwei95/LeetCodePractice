/**
654. Maximum Binary Tree

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return contruct(nums, 0, nums.length);
    }

    public TreeNode contruct(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) // 没有元素了
            return null;
        
        if (rightIndex - leftIndex == 1) // 只有一个元素
            return new TreeNode(nums[leftIndex]);

        int maxIndex = leftIndex;
        int maxValue = nums[maxIndex];
        for (int i = leftIndex + 1; i < rightIndex; i ++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = contruct(nums, leftIndex, maxIndex);
        root.right = contruct(nums, maxIndex + 1, rightIndex);
        
        return root;
    }
}





/**
617. Merge Two Binary Trees

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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}





/**
700. Search in a Binary Search Tree

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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        TreeNode result = new TreeNode();
        result = null;
        if (val < root.val) result = searchBST(root.left, val);
        if (val > root.val) result = searchBST(root.right, val);
        return result;
    }
}



/**
迭代法
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
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) root = root.left;
            else if (val > root.val) root = root.right;
            else return root;
        }
        return null;
    }
}





/**
98. Validate Binary Search Tree

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

    public long maxVal = Long.MIN_VALUE;
    boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        // 中序遍历，验证遍历的元素是不是从小到大
        if (maxVal < root.val) maxVal = root.val;
        else return false;
        boolean right = isValidBST(root.right);

        return left && right;
    }
}