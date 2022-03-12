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
    
    public int height(TreeNode root){
        
        if(root == null) return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        
        return Math.max(left,right) + 1;
        
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
       
        if(root == null) return 0;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        
        int dia = leftHeight + rightHeight;
        
        return Math.max(dia,Math.max(left,right));
        
    }
}