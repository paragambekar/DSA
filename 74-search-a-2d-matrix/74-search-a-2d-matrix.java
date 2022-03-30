class Solution {
    
    public boolean isValid(int grid[][], int i, int j){
        
        int n = grid.length;
        int m = grid[0].length;
        
        if(i < 0 || i >= n || j < 0 || j >= m) return false;
        
        return true;
        
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int i = matrix.length-1;
        int j = 0;
        
        while(isValid(matrix,i,j)){
            
            if(matrix[i][j] == target) return true;
            
            if(matrix[i][j] > target){
                i--;
            }else{
                j++;
            }
            
        }
        
        return false;
        
    }
}