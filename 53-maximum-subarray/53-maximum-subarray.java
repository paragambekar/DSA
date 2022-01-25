class Solution {
    public int maxSubArray(int[] nums) {
        
        int sum = Integer.MIN_VALUE;
        int currsum = 0;
        for(int i = 0; i < nums.length; i++){
            currsum+= nums[i];
            
            sum = Math.max(currsum,sum);
            
            if(currsum < 0){
                currsum = 0;
            }
            
        }
        
        return sum;
    }
}