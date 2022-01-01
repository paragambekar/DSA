class Solution {
    
    private int decode(String s, int index, int dp[]){
        
        if(index == s.length()){
            return 1;
        }
        
        if(s.charAt(index) == '0'){
            return 0;
        }
        
        if(index == s.length()-1){
            return 1;
        }
        
        if(dp[index]!= -1){
            return dp[index];
        }
        
        int way1 = decode(s,index+1,dp);
        int way2 = 0;
        
        if(Integer.parseInt(s.substring(index,index+2)) <= 26){
            way2 = decode(s,index+2,dp);
        }
        
         return dp[index] = way1+way2; 
        
    }
    
    public int numDecodings(String s) {
        
        int n = s.length(); 
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return decode(s,0,dp);
        
    }
}