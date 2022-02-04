class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = n/2;
        
        int ans = -1;
        int count = 0;
        int i = 0; int j = 0;
        while(j < n){
            
            if(nums[i] == nums[j]){
                count++;
                j++;
            }else{
                i = j;
                count = 0;
            }
            
            if(count > m){
                return nums[i];
            }
    
            
        }
       return ans; 
    }
}