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

class Tuple{
    long max;
    long min;
    boolean isBst;
    
    public Tuple(long max,long min, boolean isBst){
        this.max = max;
        this.min = min;
        this.isBst = isBst;
    }
}

class Solution {
    
    public Tuple check(TreeNode root){
        
         if(root == null){
            return new Tuple(Long.MIN_VALUE,Long.MAX_VALUE,true);
        }
        
        if(root.left == null && root.right == null){
            return new Tuple(root.val,root.val,true); 
        }
        
        Tuple left = check(root.left);
        Tuple right = check(root.right);
        
        
        boolean bst = true;
        if(left.max >= root.val){
            bst = false;
        }
        
        if(right.min <= root.val){
            bst = false;
        }
        
        bst = bst && left.isBst && right.isBst;
        
        long min = Math.min(root.val, Math.min(left.min, right.min));
        
        long max = Math.max(root.val, Math.max(left.max, right.max));
        
        return new Tuple(max,min,bst);
        
        
    }
    
    public boolean isValidBST(TreeNode root) {
        
      Tuple ans = check(root);
        return ans.isBst;
        
        
    }
}









