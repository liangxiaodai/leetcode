package com.qunhe.leetcode.editor.cn;
//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表
// 👍 1544 👎 0

public class P206ReverseLinkedList {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newNode = new ListNode(-1);
            while (head != null) {
                ListNode next = head.next;//2
                head.next = newNode.next;//1->null
                newNode.next = head;//-1->1->null
                head = next;//2
            }
            return newNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
