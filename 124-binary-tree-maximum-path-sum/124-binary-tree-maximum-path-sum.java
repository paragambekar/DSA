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
    int toForm;
    int maxSum;
    
    public Pair(int toForm, int maxSum){
        this.toForm = toForm;
        this.maxSum = maxSum;
    }
    
}

class Solution {
    
    public Pair maxPath(TreeNode root){
        
        if(root == null){
            return (new Pair(-1001,-1001));
        }
        
        if(root.left == null && root.right == null){
            return (new Pair(root.val,root.val));
        }
        
        
        Pair left = maxPath(root.left);
        Pair right = maxPath(root.right);
        
        int toPass = Math.max(Math.max(left.toForm,right.toForm) + root.val, root.val);
        
        int mxSum = Math.max(toPass, left.toForm + right.toForm + root.val);
        
        int maxPath = Math.max(mxSum, Math.max(left.maxSum, right.maxSum));
        
        return (new Pair(toPass,maxPath));
        
    }
    
    public int maxPathSum(TreeNode root) {
        
        Pair ans = maxPath(root);
        System.out.println(ans.maxSum + " " + ans.toForm);
        return Math.max(ans.maxSum,ans.toForm);
        
    }
}












