class Solution {
    
    public void swap(int nums[], int i, int j){
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
    
    public void moveZeroes(int[] nums) {
        
        int numPos = 0;
        int runner = 0;
        
        while(runner < nums.length){
            
            if(nums[runner] == 0){
                runner++;
            }else{
                swap(nums,numPos,runner);
                runner++;
                numPos++;
            }
            
        }
        
    }
}