class Solution {
    public int maximumTop(int[] nums, int k) {
        
        int n = nums.length;
        
        // moves not available
        if(k == 0){
            if(n >= 1){
                return nums[0];
            }else{
                return -1;
            }
        }
        
        if(k == 1){
            if(n >= 2){
               return nums[1];
            }else{
                return -1;
            }
        }
        
        if(n == 1){
            
            if(k % 2 == 0){
                return nums[0];
            }else{
                return -1;
            }
            
        }
        
        int max = 0;
        
        for(int i = 0; i < Math.min(n,k-1); i++){
            max = Math.max(max,nums[i]);
        }
        
        if(k < n){
            max = Math.max(max,nums[k]);
        }
        
        return max;
        
    }
}