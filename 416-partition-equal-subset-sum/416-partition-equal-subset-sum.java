class Solution {
    
    private boolean partition(int nums[], int idx, int target,Boolean dp[][]){
        
        if(target == 0){
            return true;
        }
        
        if(idx == 0 && nums[idx] == target){
            return true;
        }
        
         if(idx == 0 && nums[idx] != target){
            return false;
        }
        
        
        if(dp[idx][target] != null){
           return dp[idx][target];
        }
        
        boolean notTake = partition(nums,idx-1,target,dp);
        boolean take = false;
        if(nums[idx] <= target){
            take = partition(nums,idx-1,target-nums[idx],dp);  
        }
        
        return dp[idx][target] = take || notTake;
    }
    
    public boolean canPartition(int[] nums) {
        
        int target = 0;
        for(int i = 0; i < nums.length; i++){
            target += nums[i];
        }
        // System.out.println(target);
        
        if(target % 2 == 1){
            return false;
        }
        
        int m = nums.length;
        // System.out.println(m);
        
        int n = target / 2 ;
        // System.out.println(n);
        
        Boolean dp[][] = new Boolean[m][n+1];
        
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j <= n; j++){
        //         dp[i][j] = -1;
        //     }
        // }
       
        
        return partition(nums,m-1,n,dp);
        
    }
}