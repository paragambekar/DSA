class Solution {
    
    public int robHelper(int i, int nums[], int dp[]){
        
        if(i == 0) return nums[i];
        
        if(i < 0) return 0;
        
        if(dp[i] != -1){
            return dp[i]; 
        }
        
        int pick = nums[i] + robHelper(i-2,nums,dp);
        
        int notPick = robHelper(i-1,nums,dp);
        
        return dp[i] = Math.max(pick,notPick);
        
    }
    
    public int rob(int[] nums) {
        
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return robHelper(nums.length-1, nums,dp);
        
    }
}