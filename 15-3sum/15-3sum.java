class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
       int n = nums.length;
        
       List<List<Integer>> ans = new ArrayList<>(); 
        
        for(int i = 0; i < n-2; i++){
            
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int left = i+1;
            int right = n-1;
            
            while(left < right){
                
            
                if(nums[left] + nums[right] == -nums[i]){
                    List<Integer> ds = new ArrayList<>();
                    ds.add(nums[i]);
                    ds.add(nums[left]);
                    ds.add(nums[right]);
                    ans.add(new ArrayList<>(ds));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    
                    left++;
                    right--;
                }else if(nums[left] + nums[right] > -nums[i]){
                    right--;
                }else{
                    left++;
                }
            }
            
            
            
        }
        
        return ans;
        
        
    }
}