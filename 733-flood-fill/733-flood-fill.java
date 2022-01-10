class Pair{
    int row;
    int col;
    
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    
    int dr[] = new int[]{-1,0,1,0};
    int dc[] = new int[]{0,1,0,-1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int m = image.length;
        int n = image[0].length;
        
    
        int oldColor = image[sr][sc];
        if(oldColor == newColor){
            return image;
        }
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(sr,sc));
        
        while(!q.isEmpty()){
            
            Pair front = q.poll();
            image[front.row][front.col] = newColor;
            
            for(int i = 0; i < 4; i++){
                int nr = front.row + dr[i];
                int nc = front.col + dc[i];
                
                if(isValid(image,oldColor,nr,nc,m,n)){
                    q.add(new Pair(nr,nc));
                }
                
            }
            
        }
        
        return image;  
    }
    
    private boolean isValid(int image[][], int oldColor, int nr, int nc, int m, int n){
        if(nr >=0 && nr < m && nc >=0 && nc < n && image[nr][nc] == oldColor){
            return true;
        }
        return false;
    }
}