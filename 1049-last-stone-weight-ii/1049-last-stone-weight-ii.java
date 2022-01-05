class Solution {
    
    public void subsetSum(int stones[], boolean dp[][], int target){
        
        for(int i = 0; i < dp[0].length; i++){
            dp[0][i] = false;
        }
        
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                
                if(stones[i-1] <= j){
                    dp[i][j] = dp[i-1][j-stones[i-1]] ||dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        
        
    }
    
    public int lastStoneWeightII(int[] stones) {
        
        int range = 0;
        for(int i = 0; i < stones.length; i++){
            range += stones[i];
        }
        
        boolean dp[][] = new boolean[stones.length+1][range+1];
        
        subsetSum(stones,dp,range);
        
//         for(int i = 0; i < dp.length; i++){
//             for(int j = 0; j < dp[0].length; j++){
                
//                 System.out.print(dp[i][j]+" ");
                
//             }
//             System.out.println();
//         }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < (dp[0].length + 1)/2;i++){
            
            if(dp[stones.length][i] == true){
                list.add(i);
            }
            
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < list.size(); i++){
            min = Math.min(min,range-(2*(list.get(i))));
        }
        
        return min;
        
        
        
     
    }
}