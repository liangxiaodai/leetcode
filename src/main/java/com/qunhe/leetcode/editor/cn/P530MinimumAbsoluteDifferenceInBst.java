package com.qunhe.leetcode.editor.cn;
//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
//
//
//
// 示例：
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
//
//
//
//
// 提示：
//
//
// 树中至少有 2 个节点。
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
//相同
//
// Related Topics 树
// 👍 236 👎 0

public class P530MinimumAbsoluteDifferenceInBst {
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
        private int minValue = Integer.MAX_VALUE;
        private TreeNode preNode = null;

        public int getMinimumDifference(TreeNode root) {
            inOrder(root);
            return minValue;
        }

        private void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            if (preNode != null) {
                minValue = Math.min(minValue, node.val - preNode.val);
            }
            preNode = node;
            inOrder(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
