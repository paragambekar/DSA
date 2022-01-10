class Solution {
    
    int dr[] = new int[]{0,0,1,-1};
    int dc[] = new int[]{-1,1,0,0};
    
    private void flood(int image[][], int sr, int sc, int oldColor, int newColor){
        
        if(sr < 0 || sr == image.length || sc < 0 || sc == image[0].length || image[sr][sc] != oldColor){
            return;
        }
        
        image[sr][sc] = newColor;
        
        for(int i = 0; i < 4; i++){
            int nr = sr + dr[i];
            int nc = sc + dc[i];
            
            flood(image,nr,nc,oldColor,newColor);
        }
        
        
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
         if (image[sr][sc] == newColor) return image;
        
        int oldColor = image[sr][sc];
        
        flood(image,sr,sc,oldColor,newColor);
        return image;
        
    }
}