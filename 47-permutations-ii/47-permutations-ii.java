class Solution {
    
    private void permutate(int nums[],List<Integer> ds,List<List<Integer>> ans,boolean freq[]){
        
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
    
            // if(freq[i]){
            //     continue;
            // }
             if(i > 0 && (nums[i-1]==nums[i]) && freq[i-1]) continue;
            
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                permutate(nums,ds,ans,freq);
                freq[i] = false;
                ds.remove(ds.size()-1);
            }
        }
        
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
       
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        Arrays.sort(nums);
        permutate(nums,ds,ans,freq);
        return ans;
        
    }
}