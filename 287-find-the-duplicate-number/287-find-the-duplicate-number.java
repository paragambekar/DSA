class Solution {
    public int findDuplicate(int[] nums) {
        
        int n = nums.length;
        
        int farr[] = new int[n];
        
        for(int i = 0; i < nums.length; i++){
            farr[nums[i]]++;
            
            if(farr[nums[i]] == 2) return nums[i];
        }
        return -1;
    }
}