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

class Pair{
    int height;
    boolean isBalanced;
    
    public Pair(int height, boolean isBalanced){
        this.height = height;
        this.isBalanced = isBalanced;
    }
}

class Solution {
    
    public Pair isBal(TreeNode root){
        
        if(root == null){
            return (new Pair(0,true));
        }
        
        
        Pair left = isBal(root.left);
        Pair right = isBal(root.right);
        
        boolean bal = true;
        
        int lefth = left.height;
        int righth = right.height;
        
        if(Math.abs(lefth - righth) > 1){
            bal = false;
        }
        
        bal = bal && (left.isBalanced && right.isBalanced);
        
        int height = Math.max(lefth,righth)+1;
        
        Pair ans = new Pair(height,bal);
        return ans;
        
    }
    
    public boolean isBalanced(TreeNode root) {
        
        Pair ans = isBal(root);
        
        return ans.isBalanced;
        
    }
}











