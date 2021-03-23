package com.qunhe.leetcode.editor.cn;
//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
// 假定 BST 有如下定义：
//
//
// 结点左子树中所含结点的值小于等于当前结点的值
// 结点右子树中所含结点的值大于等于当前结点的值
// 左子树和右子树都是二叉搜索树
//
//
// 例如：
//给定 BST [1,null,2,2],
//
//    1
//    \
//     2
//    /
//   2
//
//
// 返回[2].
//
// 提示：如果众数超过1个，不需考虑输出顺序
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
// Related Topics 树
// 👍 283 👎 0

import java.util.ArrayList;
import java.util.List;

public class P501FindModeInBinarySearchTree {
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
        //数字重复的次数
        private int count = 1;
        //出现数字最多的次数
        private int maxCount = 1;
        private TreeNode preNode = null;

        public int[] findMode(TreeNode root) {
            List<Integer> nums = new ArrayList<>();
            inOrder(root, nums);
            int[] ret = new int[nums.size()];
            int i = 0;
            for (Integer num : nums) {
                ret[i++] = num;
            }
            return ret;
        }

        private void inOrder(TreeNode node, List<Integer> nums) {
            if (node == null) {
                return;
            }
            inOrder(node.left, nums);
            update(node, nums);
            inOrder(node.right, nums);
        }

        private void update(TreeNode node, List<Integer> nums) {
            if (preNode != null) {
                //当前节点与前一个节点相等,出现次数加1
                if (node.val == preNode.val) {
                    count++;
                } else {
                    //否则复位1
                    count = 1;
                }
            }
            //当前节点出现次数大于记录出现的次数，更新maxCount，并清空nums
            if (count > maxCount) {
                maxCount = count;
                nums.clear();
                nums.add(node.val);
                //记录次数相等，则加入nums列表
            } else if (count == maxCount) {
                nums.add(node.val);
            }
            preNode = node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
