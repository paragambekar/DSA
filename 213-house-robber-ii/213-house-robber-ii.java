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
        int n = nums.length;
        
        if(n == 1) return nums[0];
        
        int considerLast[] = new int[n-1];
        int considerFirst[] = new int[n-1];
        
        for(int i = 0; i < n-1; i++){
            considerFirst[i] = nums[i];
            considerLast[i] = nums[i+1];
        }
        
//         for(int i = 0; i < considerFirst.length; i++){
//             System.out.print(considerFirst[i]+ " ");
//         }
        
//         System.out.println();
        
//         for(int i = 0; i < considerLast.length; i++){
//             System.out.print(considerLast[i]+ " ");
//         }
        
        int dpf[] = new int[n-1];
        int dpl[] = new int[n-1];
        Arrays.fill(dpf,-1);
        Arrays.fill(dpl,-1);
        
        return Math.max(robHelper(n-2, considerFirst,dpf), robHelper(n-2, considerLast,dpl));
    
        
    }
}