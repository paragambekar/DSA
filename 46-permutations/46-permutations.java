class Solution {
    
    public void permuteHelper(int nums[], boolean visited[], List<Integer> ds,List<List<Integer>> ans){
        
        // if(ds.size() == nums.length){
        //     ans.add(new ArrayList<>(ds));
        //     return;
        // }
        
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            
            if(!visited[i]){
                visited[i] = true;
                ds.add(nums[i]);
                permuteHelper(nums,visited,ds,ans);
                ds.remove(ds.size()-1);
                visited[i] = false;
            }
            
        }
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        boolean visited[] = new boolean[nums.length];
        
        List<Integer> ds = new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        
        permuteHelper(nums,visited,ds,ans);
        return ans;
        
    }
}