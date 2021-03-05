package com.qunhe.leetcode.editor.cn;
//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针
// 👍 880 👎 0

public class P234PalindromeLinkedList {
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
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //偶数结点，slow指向下一个结点
            if (fast != null) {
                slow = slow.next;
            }
            //切成两个链表
            cut(head, slow);
            return isEqual(head, reverse(slow));
        }

        /**
         * 切成两个链表
         *
         * @param head
         * @param cutNode
         */
        public void cut(ListNode head, ListNode cutNode) {
            while (head.next != cutNode) {
                head = head.next;
            }
            head.next = null;
        }

        /**
         * 翻转链表
         *
         * @param head
         * @return
         */
        public ListNode reverse(ListNode head) {
            ListNode newNode = null;
            while (head != null) {
                ListNode nextNode = head.next;
                head.next = newNode;
                newNode = head;
                head = nextNode;
            }
            return newNode;
        }

        /**
         * 判读链表是否相等
         *
         * @param l1
         * @param l2
         * @return
         */
        public boolean isEqual(ListNode l1, ListNode l2) {
            while (l1 != null && l2 != null) {
                if (l1.val != l2.val) {
                    return false;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
