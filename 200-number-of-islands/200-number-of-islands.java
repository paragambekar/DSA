class Pair{
    int row;
    int col;
    
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    
    int dr[] = new int[]{0,0,1,-1};
    int dc[] = new int[]{-1,1,0,0};
    
    private boolean isValid(char grid[][], int i, int j, boolean visited[][]){
        int m = grid.length;
        int n = grid[0].length;
        
        
        if(i >= 0 && i < m && j >=0 && j < n &&  grid[i][j] == '1'  && visited[i][j] == false){
            return true;
        }
        return false;
    }
    
    private void islandbfs(char grid[][], int i, int j,boolean visited[][]){
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(i,j));
        visited[i][j] = true;
        
        while(!q.isEmpty()){
            
            Pair front = q.poll();
            visited[front.row][front.col] = true;
            
                for(int k = 0; k < 4; k++){
                int nr = front.row + dr[k];
                int nc = front.col + dc[k];
                    
                   if(isValid(grid,nr,nc,visited)){
                       q.add(new Pair(nr,nc));
                       visited[nr][nc] = true;
                   }    
            }
              
        }
        
        
        
        
    }
    
    public int numIslands(char[][] grid) {
        
         if(grid==null || grid.length==0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        boolean visited[][] = new boolean[m][n];
        
        
        int islands = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(grid[i][j] == '1' && visited[i][j] == false){
                    islandbfs(grid,i,j,visited);
                    islands++; 
                }
                
            }
        }
        
        return islands;
    }
}