class Solution {
    public int findDuplicate(int[] nums) {
        
        int n = nums.length;
        
        int farr[] = new int[n];
        
        for(int i = 0; i < nums.length; i++){
            farr[nums[i]]++;
            
            if(farr[nums[i]] == 2) return nums[i];
        }
        
        for(int i = 0; i < farr.length; i++){
            System.out.println(farr[i]+" ");
        }
        return -1;
    }
}