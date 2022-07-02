class Solution {
    public int[] twoSum(int[] nums, int target) {
       
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[2]; 
        
        for(int i = 0; i < nums.length; i++){
            
            if(map.containsKey(target-nums[i])){
                int start = i;
                int end = map.get(target-nums[i]);
                
                ans[0] = start;
                ans[1] = end;                
            }
            
            map.put(nums[i], i);   
        }
        // System.out.println(map);
        
        
       
        return ans;
       
    }
}