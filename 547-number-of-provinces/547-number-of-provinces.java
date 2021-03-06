class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        
        boolean visited[] = new boolean[n];
        
        int count = 0;
        
        
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;
                
                while(!q.isEmpty()){
            
                int node = q.poll();

                for(int j = 0; j < n; j++){
                    if(isConnected[node][j] == 1 && !visited[j]){
                        visited[j] = true;
                        q.add(j);
                    }
                }

                
                }
                count++;
            }
            
        }
        
        
        
        return count;
        
        
    }
}