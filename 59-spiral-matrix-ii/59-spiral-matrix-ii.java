class Solution {
    public int[][] generateMatrix(int n) {
        
        int grid[][] = new int[n][n];
        
        int startRow = 0;             int startCol = 0;
        int endRow = n-1;             int endCol = n-1;
        
        int count = 1;
        
        while(count <= n*n){
            
            for(int i = startCol; i <= endCol; i++){
                grid[startRow][i] = count++;
            }
            startRow++;
            
            for(int i = startRow; i <= endRow; i++){
                grid[i][endCol] = count++;
            }
            endCol--;
            
            for(int i = endCol; i >= startCol; i--){
                grid[endRow][i] = count++;
            }
            endRow--;
            
            for(int i = endRow; i>= startRow; i--){
                grid[i][startCol] = count++;
            }
            startCol++;
            
            
        }
        
        return grid;
        
    }
}