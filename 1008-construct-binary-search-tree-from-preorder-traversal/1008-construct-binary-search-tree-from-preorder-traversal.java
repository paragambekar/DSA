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
    
    public TreeNode builder(int preorder[], int start, int end){
        
        if(start > end) return null;
        
        int rootData = preorder[start];         
        int i;
        for(i = start; i <= end; i++){
            if(preorder[i] > rootData){
               break;
            }
        }
        
        TreeNode root = new TreeNode(rootData);
        
        root.left = builder(preorder,start+1,i-1);
        root.right = builder(preorder, i, end);
        
        return root;
        
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return builder(preorder,0,preorder.length-1);
        
    }
}







