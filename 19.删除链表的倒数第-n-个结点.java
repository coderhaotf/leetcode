/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vNode = new ListNode();
        vNode.next = head;
        ListNode cur = vNode;
        ListNode pre = vNode;

        if (n <= 0) {
            return vNode.next;
        }

        // 先走n步
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }

        // 链长小于n
        if (cur == null)
            return vNode.next;

        // 开始同步走
        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }

        // 删除倒数第n个节点
        if (n == 1) {
            pre.next = null;
        } else {
            pre.next = pre.next.next;
        }

        return vNode.next;
    }
}
// @lc code=end
