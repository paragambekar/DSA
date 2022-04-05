class Solution {
    public int maxArea(int[] height) {
        
        int ans = 0;
        int curr = 0;
        
        int i = 0;
        int j = height.length-1;
        
        while(i < j){
            
            if(height[i] <= height[j]){
                curr = height[i] * (j-i);
                i++;
            }else{
                curr = height[j] * (j-i);
                j--;
            }
            
            ans = Math.max(ans,curr);
            
        }
        
        return ans;
        
    }
}