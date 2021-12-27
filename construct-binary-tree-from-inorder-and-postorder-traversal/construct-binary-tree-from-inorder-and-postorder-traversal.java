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
    
    public TreeNode buildHelper(int inorder[], int inStart, int inEnd, int postorder[], int postStart, int postEnd){
        
        if(postStart > postEnd){
            return null;
        }
        
        int rootData = postorder[postEnd];
        
        TreeNode root = new TreeNode(rootData);
        
        int rootIndex = -1;
        int count = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == rootData){
                rootIndex = i;
                break;
            }
            count++;
        }
        
        root.left = buildHelper(inorder,inStart, rootIndex - 1, postorder, postStart, postStart+rootIndex- inStart - 1);
        root.right = buildHelper(inorder,rootIndex + 1, inEnd, postorder, postStart+rootIndex - inStart, postEnd-1);
        
        return root;
        
        
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        TreeNode root = buildHelper(inorder, 0, inorder.length - 1, postorder, 0 , postorder.length -1);
        
        return root;
        
        
    }
}