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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;

        ListNode curr1 = l1;
        ListNode curr2 = l2;

        int carry = 0;

        while(curr1 != null || curr2 != null || carry != 0){
            int a = curr1 != null ? curr1.val : 0;
            int b = curr2 != null ? curr2.val : 0;

            int sum = a + b + carry;
            int q = sum / 10;
            int rem = sum % 10;

            carry = q;

            ListNode newNode = new ListNode(rem);
            prev.next = newNode;
            prev = newNode;

            curr1 = curr1 != null ? curr1.next : null;
            curr2 = curr2 != null ? curr2.next : null;

        } 

        return dummyNode.next;

    }
}
