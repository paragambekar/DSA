class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        
        int farr[] = new int[n+2];
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0 && nums[i] < farr.length){
                farr[nums[i]]++;
            }
        }
        
        for(int i = 1; i < farr.length; i++){
            if(farr[i] == 0) return i;
        }
        
        return -1;
        
    }
}