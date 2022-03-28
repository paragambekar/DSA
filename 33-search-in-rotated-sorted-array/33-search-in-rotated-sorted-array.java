class Solution {
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            
            int mid = start + (end-start)/2;
            
            if(nums[mid] == target){
                return mid;
            }else if((target >= nums[start] && target < nums[mid]) || (target > nums[end] && target > nums[mid])){
                end = end-1;
            }else{
                start = start + 1;
            }
            
        }
        
        return -1;
        
    }
}