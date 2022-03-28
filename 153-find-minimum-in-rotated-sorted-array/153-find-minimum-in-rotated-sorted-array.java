class Solution {
    public int findMin(int[] nums) {
        
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            
            int mid = start + (end-start)/2;
            
            // for sorted array
            if(nums[start] <= nums[mid] && nums[end] >= nums[mid]){
                return nums[start];
            }else if(nums[start] >= nums[mid] && nums[mid] <= nums[end]){
                end = mid;
            }else{
                start = mid+1;
            }
            
            
        }
                                 
         return -1;                        
        
    }
}