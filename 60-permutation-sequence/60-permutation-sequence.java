class Solution {
    
    private void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int nums[],int i){
        
        int j = nums.length-1;
        
        while(i < j){
            swap(nums,i,j);
            i++;
            j--;
        }
        
    }
    
    public String getPermutation(int n, int k) {
        
        int nums[] = new int[n];
        for(int i = 0; i < nums.length; i++){
            nums[i] = i+1;
        }
        
        for(int m = 1; m < k; m++){
            
            int i = n-2;
            while(i >= 0 && nums[i] >= nums[i+1]) i--;
            
            if(i >= 0){
                int j = n-1;
                while(nums[j] <= nums[i]) j--;
                swap(nums,i,j);
            }
            
            reverse(nums,i+1);
        }
        
        String ans = "";
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            ans+= Integer.toString(num);
        }
        return ans;
    }
}