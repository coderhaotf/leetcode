/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;

        while (pa != pb) {
            if (pa == null) {
                pa = headB;
            } else {
                pa = pa.next;
            }

            if (pb == null) {
                pb = headA;
            } else {
                pb = pb.next;
            }
        }
        return pa;
    }
}
// @lc code=end
