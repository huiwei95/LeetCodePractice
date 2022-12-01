/**
102. Binary Tree Level Order Traversal

Note：用层序历遍。层序历遍的是把每一层的历遍好的元素放在一维数组中，最后把一维数组结合起来变为二维数组
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); // 2d array
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {    
            List<Integer> ary = new ArrayList<Integer>(); // 1d array
            int length = queue.size();
            
            while (length-- > 0) {
                TreeNode tempNode = queue.poll();
                ary.add(tempNode.val);
                
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
                
            }
            result.add(ary);
        }
        return result;
    }
}





/**
226. Invert Binary Tree

Note： 用递归来写，采用前序（中左右）先进行交换左右孩子节点，然后反转左子树，反转右子树。
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        
        swapChildren(root); // 中
        invertTree(root.left); // 左
        invertTree(root.right); //右
        
        return root;
    }
    
    public void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}



class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        
        // 后序
        invertTree(root.left); // 左
        invertTree(root.right); //右
        swapChildren(root); // 中
        
        return root;
    }
    
    public void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}






/**
101. Symmetric Tree

Note： 用后序递归
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
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }
    
    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) 
            return true;
        if (left != null && right == null) 
            return false;
        if (left == null && right != null) 
            return false;
        if (left.val != right.val)
            return false;
        
        boolean outSide = compare(left.left, right.right);
        boolean inSide = compare(left.right, right.left);
        return outSide && inSide;
    }
}