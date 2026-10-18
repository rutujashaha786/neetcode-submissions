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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = getSize(head);
        int groupNum = size / k;

        ListNode dummyNode = new ListNode(-1);
        ListNode tail = dummyNode;

        //use reverse linked list pattern till k nodes
        ListNode current = head;

        for(int i = 0; i < groupNum; i++){
            ListNode prev = null;
            ListNode newTail = current;
            
            for(int j = 0; j < k; j++){
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            ListNode newHead = prev;
            tail.next = newHead;
            tail = newTail;
        }
        tail.next = current;

        return dummyNode.next;  
    }

    public int getSize(ListNode head){
        int size = 0;
        ListNode current = head;
        while(current != null){
            size++;
            current = current.next;
        }
        return size;
    }
}
