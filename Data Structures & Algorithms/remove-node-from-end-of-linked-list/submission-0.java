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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //length
        int count = 0;
        ListNode current = head;
        while(current != null){
            count++;
            current = current.next;
        }

        int index = count - n;

        if(index == 0){
            return head.next;
        }

        current = head;
        for(int i = 0; i < index - 1; i++){
            current = current.next;
        }

        current.next = current.next.next;
        return head;
    }
}
