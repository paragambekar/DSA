class Solution {
    
    public void subset(int nums[], int idx, List<Integer> ds, List<List<Integer>> ans){
        
        ans.add(new ArrayList<>(ds));
        
        for(int i = idx; i < nums.length; i++){
            
            if(i > idx && nums[i] == nums[i-1]){
                continue;
            }
            ds.add(nums[i]);
            subset(nums,i+1,ds,ans);
            ds.remove(ds.size()-1);
            
            
        }
        
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        
      List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> ds = new ArrayList<>();
        
        subset(nums,0,ds,ans);
        return ans;
        
    }
}