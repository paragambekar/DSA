class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans = new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int startRow = 0;             int startCol = 0;
        int endRow = m-1;             int endCol = n-1;
        
        int count = 1;
        
        while(count <= m*n){
            
            for(int i = startCol; i <= endCol; i++){
                if(count > m*n) break;
                ans.add(matrix[startRow][i]);
                count++;
                System.out.println(count);
            }
            startRow++;
            
            for(int i = startRow; i <= endRow; i++){
                if(count > m*n) break;
                ans.add(matrix[i][endCol]);
                count++;
                System.out.println(count);
            }
            endCol--;
            
            for(int i = endCol; i >= startCol; i--){
                if(count > m*n) break;
                ans.add(matrix[endRow][i]);
                count++;
                System.out.println(count);
            }
            endRow--;
            
            for(int i = endRow; i>= startRow; i--){
                if(count > m*n) break;
                ans.add(matrix[i][startCol]);
                count++;
                System.out.println(count);
            }
            startCol++;
            
            
        }
        return ans;
        
    }
}