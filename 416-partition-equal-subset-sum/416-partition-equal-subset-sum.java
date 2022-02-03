class Solution {
    
    private boolean partition(int nums[], int idx, int target,int dp[][]){
        
        if(target == 0){
            return true;
        }
        
        if(idx == 0 && nums[idx] == target){
            return true;
        }
        
         if(idx == 0 && nums[idx] != target){
            return false;
        }
        
        
        if(dp[idx][target] != -1){
           if(dp[idx][target] == 0){
               return false;
           }else{
               return true;
           }
        }
        
        boolean notTake = partition(nums,idx-1,target,dp);
        boolean take = false;
        if(nums[idx] <= target){
            take = partition(nums,idx-1,target-nums[idx],dp);  
        }
        boolean ans = take || notTake;
        
        if(ans == false){
            dp[idx][target] = 0;
        }else{
            dp[idx][target] = 1;
        }
        
        return ans;
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
        
        int dp[][] = new int[m][n+1];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = -1;
            }
        }
       
        
        return partition(nums,m-1,n,dp);
        
    }
}