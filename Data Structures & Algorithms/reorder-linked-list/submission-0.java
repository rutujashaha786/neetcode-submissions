/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        
        ListNode reversedHead = reverse(newHead);

        ListNode current1 = head;
        ListNode current2 = reversedHead;

        while(current2 != null){
            ListNode next1 = current1.next;
            current1.next = current2;

            ListNode next2 = current2.next;
            current2.next = next1;

            current1 = next1;
            current2 = next2;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
