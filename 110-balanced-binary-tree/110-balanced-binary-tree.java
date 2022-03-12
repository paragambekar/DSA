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
    boolean isBal;
    
    Pair(int height, boolean isBal){
        this.height = height;
        this.isBal = isBal;
    }
}

class Solution {
    
    public Pair isBalHelper(TreeNode root){
        
        if(root == null){
            Pair ans = new Pair(0,true);
            return ans;
        }
        
        Pair left = isBalHelper(root.left);
        Pair right = isBalHelper(root.right);
        
        boolean balanced = true;
        
        if(Math.abs(left.height - right.height) > 1){
            balanced  = false;
        }
        
        balanced = balanced && left.isBal && right.isBal;
        
        int height = Math.max(left.height,right.height) + 1;
        
        return (new Pair(height,balanced));
        
    }
    
    public boolean isBalanced(TreeNode root) {
        
        Pair ans = isBalHelper(root);
        return ans.isBal;
        
    }
}










