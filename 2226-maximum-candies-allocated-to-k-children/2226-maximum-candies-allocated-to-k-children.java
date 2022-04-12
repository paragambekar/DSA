class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < candies.length; i++){
            pq.add(candies[i]);
        }
        Arrays.sort(candies);
        int start = 1;
        int end = candies[candies.length-1];
        
        int maxCandies = 0;
        
        while(start <= end){
            
            int mid = start + (end-start)/2;    
            
            long children = k;
            for(int i = 0; i < candies.length; i++){
                
                if(candies[i]-mid >= 0) children--;
                
                int canHelp = (candies[i]-mid) / mid;
                
                children = children - canHelp;  
                
            
            }
            if(children <= 0){
                maxCandies = Math.max(maxCandies,mid);
                start = mid +1;    
            }else{
                end = mid - 1;
            }
            
            
            
            
        }
        
        return maxCandies;
        
    }
}