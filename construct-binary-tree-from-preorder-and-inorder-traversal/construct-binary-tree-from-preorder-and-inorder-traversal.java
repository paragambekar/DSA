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
    
    public TreeNode buildHelper(int preorder[], int preStart, int preEnd, int inorder[], int inStart, int inEnd){
        
        if(preStart > preEnd){
            return null;
        }
        
        int rootData = preorder[preStart];
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
        
        root.left = buildHelper(preorder,preStart+1, preStart+count, inorder, inStart, rootIndex -1);
        root.right = buildHelper(preorder, preStart+count+1,preEnd, inorder, rootIndex+1, inEnd);
        
        return root;
        
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
       TreeNode root = buildHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
        
        
        
        
    }
}