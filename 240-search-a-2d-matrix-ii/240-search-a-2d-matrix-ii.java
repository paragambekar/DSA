class Solution {
    
    private boolean isValid(int matrix[][], int i, int j){
        int m = matrix.length;
        int n = matrix[0].length;
        
        if(i >= 0 && i < m && j >= 0 && j < n){
            return true;
        }
        
        return false;
        
    }
    
    private boolean search(int matrix[][], int i, int j, int target){
        
        while(true){
        if(isValid(matrix,i,j)){
            if(target == matrix[i][j]){
                return true;
            }else if(target < matrix[i][j]){
                j--;
            }else if(target > matrix[i][j]){
                i++;
            }
        }else{
              return false;  
            }
        }
        
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix,0,matrix[0].length-1,target);
    }
}