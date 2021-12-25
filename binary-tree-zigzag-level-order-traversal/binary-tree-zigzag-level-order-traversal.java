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
        
        if(root == null){
            return ans;
        }
    
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        boolean lr = true;
        while(!q.isEmpty()){
            
            int size = q.size();
            
            List<Integer> ds = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                
                TreeNode front = q.poll();
                
                if(lr){
                    ds.add(front.val);
                }else{
                    ds.add(0,front.val);
                }
                
                if(front.left != null){
                    q.add(front.left);
                }
                
                if(front.right != null){
                    q.add(front.right);
                }
                
            }
            lr = !lr;
            ans.add(new ArrayList<>(ds));
            
            
        }
        return ans;
    }
}