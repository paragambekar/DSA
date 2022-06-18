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
    public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next == null) return head;
        
        ListNode lessThan = null, lessThanTail = null, greaterThan = null, greaterThanTail = null;
        
        ListNode curr = head;
        
        while(curr != null){
            
        
            if(curr.val < x){
                if(lessThan == null){
                    lessThan = curr;
                    lessThanTail = curr;
                    // curr = curr.next;
                }else{
                    lessThanTail.next = curr;
                    lessThanTail = lessThanTail.next;
                    // curr = curr.next;
                }
            }else{
                if(greaterThan == null){
                    greaterThan = curr;
                    greaterThanTail = curr;
                    // curr = curr.next;
                }else{
                    greaterThanTail.next = curr;
                    greaterThanTail = greaterThanTail.next;
                    // curr = curr.next;
                }
            }
            curr = curr.next;
            
        }
        
        if(lessThan == null){
            return greaterThan;
        }else if(greaterThan == null){
            return lessThan;
        }else{
            lessThanTail.next = greaterThan;
            greaterThanTail.next = null;
            return lessThan;
        }
        
        
        
    }
}