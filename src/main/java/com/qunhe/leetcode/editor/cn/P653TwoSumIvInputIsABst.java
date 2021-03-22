package com.qunhe.leetcode.editor.cn;
//给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
//
// 案例 1:
//
//
//输入:
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//输出: True
//
//
//
//
// 案例 2:
//
//
//输入:
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//输出: False
//
//
//
// Related Topics 树
// 👍 227 👎 0

import java.util.ArrayList;
import java.util.List;

public class P653TwoSumIvInputIsABst {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> numList = new ArrayList<>();
            inOrder(root, numList);
            int i = 0, j = numList.size() - 1;
            while (i < j) {
                int sum = numList.get(i) + numList.get(j);
                if (sum == k) {
                    return true;
                }
                if (sum < k) {
                    i++;
                } else {
                    j--;
                }
            }
            return false;
        }

        private void inOrder(TreeNode root, List<Integer> numList) {
            if (root == null) {
                return;
            }
            inOrder(root.left, numList);
            numList.add(root.val);
            inOrder(root.right, numList);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
