class Solution {
    public void rotate(int[][] matrix) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int n = matrix.length;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                list.add(matrix[i][j]);
            }
        }
        
        int k = 0;
        for(int i = n-1; i >=0; i--){
            for(int j = 0; j < n; j++){
                matrix[j][i] = list.get(k);
                k++;
            }
        }
        
        
    }
}