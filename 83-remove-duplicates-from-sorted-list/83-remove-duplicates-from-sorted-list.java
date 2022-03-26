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
        
        ListNode curr = head;
        ListNode runner = head;
        
        while(runner != null){
      
            
            
            while(runner != null && curr.val == runner.val){
                runner = runner.next;
            }
            
            if(runner == null){
                curr.next = null;
                return head;
            }
            
            if(curr.val != runner.val){
                curr.next = runner;
                    curr = curr.next;
            }
            
            
             
        }
        
        return head;
        
    }
}