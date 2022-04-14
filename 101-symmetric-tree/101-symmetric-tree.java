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
    
    public boolean isSym(TreeNode p, TreeNode q){
        
        if(p == null && q == null) return true;
        
        if(p == null || q == null) return false;
        
        if(p.val != q.val) return false;
        
        
        boolean one = isSym(p.left,q.right);
        boolean two = isSym(p.right,q.left);
        
        if(p.left != null && q.right != null){
            if(p.left.val != q.right.val) return false;
        }
        
        if(p.right != null && q.left != null){
            if(p.right.val != q.left.val) return false;
        }
        
        
        return one && two;
        
        
    }
    
    public boolean isSymmetric(TreeNode root) {
        
        return isSym(root,root);
        
        
    }
}