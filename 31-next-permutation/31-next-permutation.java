class Solution {
    
    private void swap(int nums[], int j, int i){
        
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        
    }
    
    private void reverse(int nums[], int i){
        
        int l = i;
        int r = nums.length-1;
        
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        
    }
    
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
            int i = n-2;
            while(i >=0 && nums[i] >= nums[i+1]){
                i--;   
        }
        
        if(i >=0){
            int j = n-1;
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        
        reverse(nums,i+1);
        
    }
}

// step 1: find first decreasing no. from end;
// step 2: swap it with just greater element
// step 3: reverse that other part and that your next permutation