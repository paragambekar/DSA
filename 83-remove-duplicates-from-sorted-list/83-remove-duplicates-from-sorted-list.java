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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode smallOutput = deleteDuplicates(head.next);
        
        if(head.val == smallOutput.val){
            return smallOutput;
        }else{
            head.next = smallOutput;
            return head;
        }
        
    }
}