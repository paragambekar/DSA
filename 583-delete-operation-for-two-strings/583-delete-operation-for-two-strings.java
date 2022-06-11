class Solution {
    
    public int lcs(String s1, String s2){
        
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        
        for(int idx1 = 1; idx1 <= n; idx1++){
            for(int idx2 = 1; idx2 <= m; idx2++){
                
                if(s1.charAt(idx1-1) == s2.charAt(idx2-1)){
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                }else{
                   dp[idx1][idx2] = Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);
                }
                
            }
        }
        
        // for(int i = 0; i < dp.length; i++){
        //     for(int j  = 0; j < dp[0].length ; j++){
        //       System.out.print(dp[i][j] + " ");  
        //     }
        //     System.out.println();
        // }
        
        return dp[n][m];
        
    }
    
    public int minDistance(String word1, String word2) {
        
        // return (word1.lenght() - lcs(word1, word2)) + (word2.length() - )
        
        int lc = lcs(word1, word2);
        System.out.println(lc);
        return (word1.length() - lc) + (word2.length() - lc);
        
    }
}