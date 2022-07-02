class Solution {
    
    public void swap(int nums[], int i, int j){
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
    
    public int removeDuplicates(int[] nums) {
        
        int curr = nums[0];
        int runner = 1;
        
        while(runner < nums.length){
            if(nums[runner] == curr){
                nums[runner] = -101;
                runner++;
            }else{
                curr = nums[runner];
                runner++;
            }
        }
        
        // for(int k = 0; k < nums.length; k++){
        //     System.out.print(nums[k]+" ");
        // }
        
        int nextPos = 1; 
        int num = 1;
        int count = 0;
        
        while(num < nums.length){
            
            if(nums[num] != -101) count++;
            
            if(nums[num] == -101){
                num++;
            }else{
                swap(nums,num,nextPos);
                num++;
                nextPos++;
            }
            
        }
        
        
        
        return count+1;
        
        
    }
}