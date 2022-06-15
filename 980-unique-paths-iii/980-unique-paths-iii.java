class Solution {
    
    public int paths(int grid[][],int x, int y,int obstacles, int count, boolean visited[][]){
        
        int u = grid.length;
        int v = grid[0].length;
        
        if(x < 0 || y < 0 || x >= u || y >= v || grid[x][y] == -1 || (visited[x][y] == true)) return 0;
       
        
        if(grid[x][y] == 2){
            if(count == ((u*v)-obstacles-1)){
                return 1;
            }else{
                return 0;
            }
        }
        
        
        visited[x][y] = true;
        
        int up = paths(grid,x-1,y,obstacles,count+1,visited);
        int right = paths(grid,x,y+1,obstacles,count+1,visited);
        int down = paths(grid,x+1,y,obstacles,count+1,visited);
        int left = paths(grid,x,y-1,obstacles,count+1,visited);
        
        visited[x][y] = false;
        
        return up + right + down + left;
        
    }
    
    public int uniquePathsIII(int[][] grid) {
        
        int startR = -1;
        int startC = -1;
        int destR = -1;
        int destC = -1;
        int obstacles = 0;
        
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] == 1){
                    startR = i;
                    startC = j;
                }else if(grid[i][j] == 2){
                    destR = i;
                    destC = j;
                }else if(grid[i][j] == -1){
                    obstacles++;
                }
            }
        }
        
        return paths(grid,startR,startC,obstacles,0,visited);
        
        
    }
}