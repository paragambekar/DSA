class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(int num : map.keySet()){
            
            if(map.get(num) > nums.length /3){
                ans.add(num);
            }
            
        }
        
        
        System.out.println(map);
        
        return ans;
        
    }
}