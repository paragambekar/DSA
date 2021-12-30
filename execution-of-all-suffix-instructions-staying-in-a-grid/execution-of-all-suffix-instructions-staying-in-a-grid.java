class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int ans[] = new int[s.length()];
        
        int grid[] = new int[2];
        grid[0] = startPos[0];
        grid[1] = startPos[1];
        
         int count = 0;
        for(int j = 0; j < s.length(); j++){
            
            int l = grid[0];
            int m = grid[1];
            count = 0;
            for(int i = j; i < s.length(); i++){
            
             
        
            if(s.charAt(i)=='R'){
                m = m+1;
            }else if(s.charAt(i) == 'L'){
                m = m - 1;
            }else if(s.charAt(i) == 'U'){
                l = l - 1;
            }else if(s.charAt(i) == 'D'){
                l = l + 1;
            }
            
            if(l >= n || l < 0 || m >=n || m < 0){
                ans[j] = count;
                break;
            }else{
                count++;
            }  
        }
            
            ans[j] = count;
            
            
        }
        
        return ans;
        
        
    }
}