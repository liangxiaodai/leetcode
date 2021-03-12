package com.qunhe.leetcode.editor.cn;
//计算给定二叉树的所有左叶子之和。
//
// 示例：
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// Related Topics 树
// 👍 295 👎 0

public class P404SumOfLeftLeaves {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (isLeaf(root.left)) {
                return root.left.val + sumOfLeftLeaves(root.right);
            }
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }

        private boolean isLeaf(TreeNode root) {
            if (root == null) {
                return false;
            }
            return root.left == null && root.right == null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
