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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root == null){
            return new TreeNode(val);
        }
        
        if(root.left == null && val  < root.val){
            TreeNode curr = new TreeNode(val);
            root.left = curr;
            return root;
        }
        
        if(root.right == null && val > root.val){
            TreeNode curr = new TreeNode(val);
            root.right = curr;
            return root;
        }
        
        if(val > root.val){
             insertIntoBST(root.right,val);
        }else{
             insertIntoBST(root.left,val);
        }
        
        return root;
        
    }
}




