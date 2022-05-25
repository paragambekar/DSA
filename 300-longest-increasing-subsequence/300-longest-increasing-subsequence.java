class Solution {
    
    private int lis(int idx,int last, int nums[], int dp[][]){
        
        if(idx == nums.length) return 0;
        
        if(dp[idx][last+1] != -1) return dp[idx][last+1];
        
        int include = 0;
        if(last == -1 || nums[idx] > nums[last]){
            include = 1 + lis(idx+1,idx,nums,dp);
        }
        
        int exclude = lis(idx+1,last,nums,dp);
        
        return dp[idx][last+1] = Math.max(include,exclude);
        
    }
    
    public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 1) return 1;
        
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        
        for(int idx = n-1; idx >= 0; idx--){
            
            for(int last = idx-1; last >= -1; last--){
                
                int include = 0;
                if(last == -1 || nums[idx] > nums[last]){
                    include = 1 + dp[idx+1][idx+1];
                }

                int exclude = dp[idx+1][last+1];

                dp[idx][last+1] = Math.max(include,exclude);
                
            }
            
        }
        
        
        return dp[0][0];
        // return lis(0,-1,nums,dp);
        
    }
}