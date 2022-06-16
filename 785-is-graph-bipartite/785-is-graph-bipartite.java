class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        
        int visited[] = new int[n];
        Arrays.fill(visited,-1);
        
        for(int m = 0; m < n; m++){
            if(visited[m] == -1){
                Queue<Integer> q = new LinkedList<>();
            q.add(m);
            visited[m] = 0;

            while(!q.isEmpty()){

                int node = q.poll();
                for(int i = 0; i < graph[node].length; i++){
                    if(visited[graph[node][i]] == -1){
                        if(visited[node] == 0){
                            visited[graph[node][i]] = 1;
                            q.add(graph[node][i]);
                        }else{
                            visited[graph[node][i]] = 0;
                            q.add(graph[node][i]);
                        }
                    }else{
                        if(visited[graph[node][i]] == visited[node]){
                            return false;
                        }
                    }
                }

            }
            
            }
        }
        
        return true;
    }
}