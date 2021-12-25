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
    int dia;
    int height;
    
    public Pair(int dia, int height){
        this.dia = dia;
        this.height = height;
    }
}

class Solution {
    
    public Pair diaOfBT(TreeNode root){
        
        if(root == null){
            Pair pair =  new Pair(0,0);
            return pair;
        }
        
        Pair leftPair = diaOfBT(root.left);
        Pair rightPair = diaOfBT(root.right);
        
        int height = Math.max(leftPair.height,rightPair.height) + 1;
        
        int dist = leftPair.height + rightPair.height;
        
        int lDia = leftPair.dia;
        int rDia = rightPair.dia;
        
        int dia = Math.max(dist, Math.max(lDia,rDia));
        
        return (new Pair(dia,height));
        
        
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        Pair ans = diaOfBT(root);
        
        return ans.dia;
        
    }
}









