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
        int dp[][] = new int[n][n+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        
        return lis(0,-1,nums,dp);
        
    }
}