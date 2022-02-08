class Solution {
    
    public boolean subset(int nums[], int i, int target, Boolean dp[][]){
        
        if(target == 0){
            return true;
        }
        
        if(i < 0){
            return false;
        }
        
        if(dp[i][target] != null){
            return dp[i][target];
        }
        
        boolean notPick = subset(nums,i-1,target,dp);
        boolean pick = false;
        if(nums[i] <=  target){
            pick = subset(nums,i-1,target-nums[i],dp);
        }
        
        return dp[i][target] = notPick || pick;
        
    }
    
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
        }
        
        if(sum % 2 == 1){
            return false;
        }
        
        int target = sum / 2;
        
        Boolean dp[][] = new Boolean[nums.length][target+1];
        
        return subset(nums, nums.length-1,target,dp);
        
        
        
    }
}