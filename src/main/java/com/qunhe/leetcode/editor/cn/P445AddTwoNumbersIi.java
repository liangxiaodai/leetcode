package com.qunhe.leetcode.editor.cn;
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//
//
//
// 进阶：
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
//
//
//
// 示例：
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
//
// Related Topics 链表
// 👍 344 👎 0

import java.util.Stack;

public class P445AddTwoNumbersIi {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> l1Stack = buildStack(l1);
            Stack<Integer> l2Stack = buildStack(l2);
            Integer carry = 0;
            ListNode head = new ListNode(-1);
            while (!l1Stack.empty() || !l2Stack.empty() || carry != 0) {
                Integer x = l1Stack.empty() ? 0 : l1Stack.pop();
                Integer y = l2Stack.empty() ? 0 : l2Stack.pop();
                Integer sum = x + y + carry;
                ListNode node = new ListNode(sum % 10);
                node.next = head.next;
                head.next = node;
                carry = sum / 10;
            }
            return head.next;
        }

        public Stack<Integer> buildStack(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
            return stack;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
