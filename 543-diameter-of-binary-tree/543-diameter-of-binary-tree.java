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
    int dia;
    
    public Pair(int height, int dia){
        this.height = height;
        this.dia = dia;
    }
}

class Solution {
    
    public Pair diaHelper(TreeNode root){
        
        if(root == null){
            Pair ans = new Pair(0,0);
            return ans;
        }
        
        Pair left = diaHelper(root.left);
        Pair right = diaHelper(root.right);
        
        int height = Math.max(left.height,right.height)+1;
        
        int dist = left.height + right.height;
        
        int dia = Math.max(dist, Math.max(left.dia,right.dia));
        
        return new Pair(height,dia);
        
        
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        Pair ans = diaHelper(root);
        return ans.dia;
        
        
        
    }
}



















