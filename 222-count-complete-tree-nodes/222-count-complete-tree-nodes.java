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
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int count = 0;
        while(!q.isEmpty()){
            
            int n = q.size();
            
            for(int i = 0; i < n; i++){
                TreeNode front = q.poll();
                count++;
                
                if(front.left != null){
                    q.add(front.left);
                }
                
                if(front.right != null){
                    q.add(front.right);
                }
                
            }
            
        }
        
        return count;
        
    }
}