class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            
            int idx = Math.abs(nums[i]);
            
            int num = idx-1;
            
            if(nums[num] < 0){
                ans.add(idx);
            }
            
            nums[num] = -nums[num];
            
        }
        
        return ans;
        
    }
}