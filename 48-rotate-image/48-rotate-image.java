class Solution {
    
    public void swap(int matrix[][], int i, int j){
        
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
        
    }
    
    public void transpose(int matrix[][]){
        
        int n = matrix.length;
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                swap(matrix,i,j);
            }
        }
        
        
    }
    
    public void swap2(int matrix[][],int i){
        
        int l = 0;
        int r = matrix.length-1;
        
        while(l < r){
            int temp = matrix[i][l];
            matrix[i][l] = matrix[i][r];
            matrix[i][r] = temp;
            l++;
            r--;
        }
        
    }
    
    public void reverse(int matrix[][]){
        
        for(int i = 0; i < matrix.length; i++){
            swap2(matrix,i);
        }
        
        
    }
    
    public void rotate(int[][] matrix) {
        
        transpose(matrix);
        reverse(matrix);
    }
}