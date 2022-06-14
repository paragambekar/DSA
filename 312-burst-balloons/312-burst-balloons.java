class Solution {
    
    public int maxPoints(int arr[], int i, int j,int dp[][]){
        
        if(i > j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int ans = Integer.MIN_VALUE;
        for(int idx = i; idx <=j; idx++){
            int points = (arr[i-1]*arr[idx]*arr[j+1]) + maxPoints(arr,i,idx-1,dp) + maxPoints(arr,idx+1,j,dp);
            ans = Math.max(ans,points);
        }
        
        return dp[i][j] = ans;
        
    }
    
    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int arr[] = new int[n+2];
        
        for(int i = 0; i < arr.length; i++){
            if(i == 0 || i == arr.length-1){
                arr[i] = 1;
            }else{
                arr[i] = nums[i-1];
            }
        }
        
        int dp[][] = new int[n+2][n+2];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return maxPoints(arr,1,n,dp);
        
    }
}