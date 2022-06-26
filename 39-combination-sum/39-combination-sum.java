class Solution {
    
    
    public void helper(int nums[], int idx, int target, List<List<Integer>> ans, List<Integer> ds){
        
        // if(idx == nums.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
                return;
            }
            
        // }
        
        for(int i = idx; i < nums.length; i++){
            if(nums[i] <= target){
                ds.add(nums[i]);
                helper(nums,i,target-nums[i],ans,ds);
                ds.remove(ds.size()-1);
            }
            
            // helper(nums,i+1,target,ans,ds);
            
        }
        
//         if(target >= nums[idx]){
//         ds.add(nums[idx]);
//         helper(nums,idx,target-nums[idx],ans,ds);
//         ds.remove(ds.size()-1);
//         }
        
//         helper(nums,idx+1,target,ans,ds);
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> ds = new ArrayList<>();
        
        helper(candidates,0,target,ans,ds);
        return ans;
        
        
    }
}