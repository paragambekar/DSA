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
    
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) return null;
        
        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else{
            if(root.left != null && root.right != null){
                int v = findMax(root.left,Integer.MIN_VALUE);
                root.val = v;
                root.left = deleteNode(root.left,v);
                return root;
            }else if(root.right != null){
                return root.right;
            }else if(root.left != null){
                return root.left;
            }else{
                return null;
            }
            
        }
        
        return root;
    }
    
    public int findMax(TreeNode root, int max){
        while(root != null){
            max = root.val;
            root = root.right;
        }
        return max;
    }
}






