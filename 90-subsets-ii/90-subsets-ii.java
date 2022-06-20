class Solution {
    
    public void subset(int nums[], int idx,boolean choosenPrev, List<Integer> ds, List<List<Integer>> ans){
        
        if(idx == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        ds.add(nums[idx]);
        subset(nums,idx+1,true,ds,ans);
        ds.remove(ds.size()-1);
        
        if(idx >=1 && nums[idx] == nums[idx-1] && choosenPrev) return;
        
        subset(nums,idx+1,false,ds,ans);
        
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        
      List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> ds = new ArrayList<>();
        
        subset(nums,0,false,ds,ans);
        return ans;
        
    }
}