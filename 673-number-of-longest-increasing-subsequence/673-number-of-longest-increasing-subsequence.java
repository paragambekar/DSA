class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        
        
        for(int i = 1; i < n; i++){
            
            for(int j = 0; j < i; j++){ 
                
                if(nums[i] > nums[j]){
                    
                    if(dp[j]+1 == dp[i]){
                        // the lis of max len was already reach and now adding this will give one more lis of similar count
                        count[i] += count[j];
                    }
                    
                    if(dp[j]+1 > dp[i]){
                        count[i] = count[j];
                    }
                    
                    dp[i] = Math.max(1+dp[j],dp[i]);
                    
                }
            }
        }
        
        int maxlen = 1;
        for(int i: dp){
            maxlen = Math.max(maxlen,i);
        }
        
        int res = 0; 
        for(int i = 0; i < n; i++){
            
            if(dp[i]==maxlen){
                res+=count[i];
            }
            
        }
        
        for(int i = 0; i < n; i++){
            System.out.print(dp[i]+" ");
        }
         System.out.println();
        
        for(int i = 0; i < n; i++){
            System.out.print(count[i]+" ");
        }
        
        return res;
        
        
    }
}