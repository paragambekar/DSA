/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode arrayToBST(int nums[], int start, int end){
        
        if(start > end){
            return null;
        }
        
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = arrayToBST(nums,start,mid-1);
        root.right = arrayToBST(nums,mid+1,end);
        
        return root;
        
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if(nums.length == 0){
            return null;
        }
        
        return arrayToBST(nums,0,nums.length-1);
        
    }
}