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

class Tuple{
    TreeNode node;
    int row;
    int col;
    
    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        
        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root,0,0));
        
        while(!q.isEmpty()){
            
            Tuple front = q.poll();
            
            TreeNode curr = front.node;
            int x = front.row;
            int y = front.col;
            
            if(!map.containsKey(x)){
                map.put(x, new TreeMap<Integer,PriorityQueue<Integer>>());
            }
            
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<Integer>());
            }
            
            map.get(x).get(y).offer(curr.val);
            
            if(curr.left != null){
                q.add(new Tuple(curr.left,x-1,y+1));
            }
            
            if(curr.right != null){
                q.add(new Tuple(curr.right,x+1,y+1));
            }
                  
        }
        
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
        
        
        
    }
}