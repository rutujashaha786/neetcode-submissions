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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);

        ListNode current1 = list1;
        ListNode current2 = list2;

        ListNode prev = dummyNode;

        while(current1 != null && current2 != null){
            if(current1.val < current2.val){
                prev.next = current1;
                current1 = current1.next;
                prev = prev.next;
            }
            else{
                prev.next = current2;
                current2 = current2.next;
                prev = prev.next;
            }
        }

        if(current1 != null){
            prev.next = current1;
        }
        if(current2 != null){
            prev.next = current2;
        }

        return dummyNode.next;
    }
}