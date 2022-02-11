class Solution {
    
    public void subsetHelper(int nums[], int idx, List<Integer> ds, List<List<Integer>> ans){
        
        if(idx == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        ds.add(nums[idx]);
        subsetHelper(nums,idx+1,ds,ans);
        ds.remove(ds.size()-1);
        
        subsetHelper(nums,idx+1,ds,ans);
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> ds = new ArrayList<>();
        
        subsetHelper(nums,0,ds,ans);
        return ans;
        
        
    }
}