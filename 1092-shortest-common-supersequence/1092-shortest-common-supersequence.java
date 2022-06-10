class Solution {
    
    public String superString(String s1, String s2, String lcs){
        
        System.out.println(s1+" "+s2+" "+lcs);
        int n = s1.length();
        int m = s2.length();
        
        int i = 0; int j = 0; int k = 0;
        
        String ans = "";
        while(i < n && j < m && k < lcs.length()){
            
            if((s1.charAt(i) == s2.charAt(j)) && ((s1.charAt(i) == lcs.charAt(k)))){  
                ans += s1.charAt(i);
                i++;
                j++;
                k++;
            }else if(s1.charAt(i) == lcs.charAt(k)){
                ans+= s2.charAt(j);
                j++;
            }else{
                ans+= s1.charAt(i);
                i++;
            }
        }
        
        if(i < n){
            ans+= s1.substring(i);
        }
        
        if(j < m){
            ans+= s2.substring(j);
        }
        
        return ans;
        
//         while(true){
//            if((s1.charAt(i) == s2.charAt(j)) && (s1.charAt(i) || s2.charAt(j) == lcs.charAt(k)){
               
//            }
//         }
        
//         (s1.charAt(i) == s2.charAt(j));
        
//         (s1.charAt(i) || s2.charAt(j) == lcs.charAt(k);
        
    }
    
    public String shortestCommonSupersequence(String str1, String str2) {
            
        int n = str1.length();
        int m = str2.length();
        
        int dp[][] = new int[n+1][m+1];
        
         for(int idx1 = 1; idx1 <= n; idx1++){
            for(int idx2 = 1; idx2 <= m; idx2++){
                
                if(str1.charAt(idx1-1) == str2.charAt(idx2-1)){
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                }else{
                    dp[idx1][idx2] = Math.max(dp[idx1][idx2-1],dp[idx1-1][idx2]);
                }
                
            }
        }
        
        for(int i= 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println(dp[n][m]);
        String lcs = "";
        
        
        int l = n; int k = m  ;      
        while(l > 0 && k > 0){
            if(str1.charAt(l-1) == str2.charAt(k-1)){
                lcs = str1.charAt(l-1) + lcs;
                l--;
                k--;
            }else{
                if(dp[l-1][k] > dp[l][k-1]){
                    l--;
                }else{
                    k--;
                }
            }
        }
                
                 
        
        return superString(str1,str2,lcs);
        
            
        
    }
}