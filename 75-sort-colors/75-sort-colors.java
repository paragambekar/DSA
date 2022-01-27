class Solution {
    
    private void swap(int nums[], int i, int j){
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
    
    public void sortColors(int[] nums) {
        
        int zeroPos = 0;
        int twoPos = nums.length-1;
        int curr = 0;
        
        while(curr <= twoPos){
            
            if(nums[curr] == 0){
                swap(nums,curr,zeroPos);
                curr++;
                zeroPos++;
            }else if(nums[curr] == 2){
                swap(nums,curr,twoPos);
                twoPos--;
            }else{
                curr++;
            }
            
        }
        
        
        
    }
}