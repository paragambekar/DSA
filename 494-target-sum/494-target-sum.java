class Solution {
    
    public int targetSum(int nums[], int idx, int target, int dp[][]){
        
        if(idx == 0){
           if(target == 0 && nums[idx] == 0){
               return 2;
           }
            
            if(target == 0 || target == nums[idx]){
                return 1;
            }else{
                return 0;
            }
        }
        
        if(dp[idx][target] != -1) return dp[idx][target];
        
        int notTake = targetSum(nums,idx-1, target,dp);
        
        int take = 0;
        if(nums[idx] <= target){
            take = targetSum(nums,idx-1, target-nums[idx],dp);
        }
        
        
        return dp[idx][target] = notTake + take;
        
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n;i++){
            sum+= nums[i];
        }
        if(sum-target < 0) return 0;
        if((sum - target) % 2 == 1) return 0;
        int s2 = (sum - target)/2;
        
        int dp[][] = new int[n][s2+1];
        
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        
        return targetSum(nums,nums.length-1,s2,dp);
        // return 0; 
        
    }
}