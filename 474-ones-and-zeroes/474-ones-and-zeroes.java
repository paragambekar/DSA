class Solution {
    
    private int findMax(String[] str, int index, int m, int n,int dp[][][]){
        
        if(index < 0){
            return 0;
        }
        
        int zeros = 0;
        int ones = 0;
        String s = str[index];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                ones++;
            }else{
                zeros++;
            }
        }
        
        if(dp[m][n][index] != 0){
            return dp[m][n][index];
        }
        
        if(zeros <= m && ones <= n){
            
            int include = 1 + findMax(str,index-1,m-zeros,n-ones,dp);
            int exclude = findMax(str,index-1,m,n,dp);
            
            return dp[m][n][index] = Math.max(include,exclude);
            
        }else{
            return dp[m][n][index] = findMax(str,index-1,m,n,dp);
        }
        
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        
        int dp[][][] = new int[m+1][n+1][strs.length];
        
        return findMax(strs,strs.length-1,m,n,dp);
        
    }
}