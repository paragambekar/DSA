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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
      List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean leftToRight = true;
        while(!q.isEmpty()){
            
            int n = q.size();
            
            List<Integer> subList = new ArrayList<>();
            
            for(int i = 0; i < n; i++){
                
                TreeNode front = q.poll();
                
                if(leftToRight){
                    subList.add(front.val);
                }else{
                    subList.add(0,front.val);
                }
                
                if(front.left != null){
                    q.add(front.left);
                }
                
                if(front.right != null){
                    q.add(front.right);
                }
                
            }
            
            ans.add(new ArrayList<>(subList));
            leftToRight = !leftToRight;
            
        }
        
        return ans;
        
    }
}