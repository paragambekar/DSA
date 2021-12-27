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
    
    public TreeNode flat(TreeNode root){
        
        if(root == null){
            return null;
        }
        
        TreeNode left = flat(root.left);
        TreeNode right = flat(root.right);
        
        TreeNode temp = left;
        
        if(temp != null){
            
            while(temp.right != null){
                temp = temp.right;
            }
            
            temp.right = right;
            root.right = left;
            root.left = null;
            
        }
        
        return root;
        
    }
    
    public void flatten(TreeNode root) {
        
        TreeNode top = flat(root);
        
    }
}