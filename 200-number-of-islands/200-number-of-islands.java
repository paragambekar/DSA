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
    
    private void dfsisland(char grid[][], int i, int j, boolean visited[][]){
        
        int m = grid.length;
        int n = grid[0].length;
        
        if(i < 0 || i == m || j < 0 || j == n || grid[i][j] == '0'){
            return;
        }
        
        visited[i][j] = true;
        
        for(int k = 0; k < 4; k++){
            int nr = i + dr[k];
            int nc = j + dc[k];
            
            if(isValid(grid,nr,nc,visited)){
                dfsisland(grid,nr,nc,visited);
            }

        }
        
    
        
        
    }
    
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        boolean visited[][] = new boolean[m][n];
        
        int islands = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(grid[i][j] == '1' && visited[i][j] == false){
                    visited[i][j] = true;
                    dfsisland(grid,i,j,visited);
                    islands++;
                    
                }
                
            }
        }
        return islands;
        
    }
}