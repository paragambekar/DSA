class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        
        int majElem = nums[0];
        int count = 0;
        for(int i = 0; i < n; i++){
            
            if(count == 0){
                majElem = nums[i];
                count = 1;
            }else if(nums[i] == majElem){
                count++;
            }else{
                count--;
            }
        }
        
        return majElem;
        
    }
}