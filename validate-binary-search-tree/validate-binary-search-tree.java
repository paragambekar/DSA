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
class Trio{
    long min;
    long max;
    boolean isBST;
    
    public Trio(long min, long max, boolean isBST){
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}

class Solution {
    
    public Trio validBST(TreeNode root){
        
        if(root == null){
            return (new Trio(Long.MAX_VALUE,Long.MIN_VALUE,true));
        }
        

        Trio left = validBST(root.left);
        
        Trio right = validBST(root.right);

        boolean isbst = true;
        
        if(root.left != null){
            if(root.left.val >= root.val){
                isbst = false;
            }
        }
        
        if(root.right != null){
            if(root.right.val <= root.val){
                isbst = false;
            }
        }
        
        if(right.min <= root.val){
            isbst = false;
        }
        
        if(left.max >= root.val){
            isbst = false;
        }
        
        
        
        long min = Math.min(root.val,Math.min(left.min,right.min));
        
        long max = Math.max(root.val,Math.max(left.max,right.max));
        
        boolean bst = isbst && left.isBST && right.isBST;
        
        return (new Trio(min,max,bst));
        
        
        
        
        
        
    }
    
    public boolean isValidBST(TreeNode root) {
        
        Trio ans = validBST(root);
        
        return ans.isBST;
        
        
    }
}















