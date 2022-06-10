class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        
        int dp[][] = new int[n+1][n+1];
        
        String s1 = "";
        String s2 = "";
        
        for(int i = 0; i < s.length(); i++){
            s1 += s.charAt(i);
            s2 = s.charAt(i) + s2;
        }
        
        for(int idx1 = 1; idx1 <= n; idx1++){
            for(int idx2 = 1; idx2 <= n; idx2++){
                
                if(s1.charAt(idx1-1) == s2.charAt(idx2-1)){
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                }else{
                    dp[idx1][idx2] = Math.max(dp[idx1][idx2-1],dp[idx1-1][idx2]);
                }
                
            }
        }
        return n - dp[n][n];
        
    }
}