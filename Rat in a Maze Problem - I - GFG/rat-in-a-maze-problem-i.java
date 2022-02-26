// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    
    public static void pathHelper(int grid[][],int i, int j,String path, ArrayList<String>ans,boolean visited[][]){
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] == 0 || visited[i][j]==true){
            return;
        }
        
        if(i == grid.length-1 && j == grid.length-1){
            ans.add(path);
            return;
        }
        
        visited[i][j] = true;
        pathHelper(grid,i-1,j,path + "U",ans,visited);
        pathHelper(grid,i+1,j,path + "D",ans,visited);
        pathHelper(grid,i,j-1,path + "L",ans,visited);
        pathHelper(grid,i,j+1,path + "R",ans,visited);
        visited[i][j] = false;
        
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
       
       ArrayList<String> ans = new ArrayList<String>();
       
       boolean visited[][] = new boolean[n][n];
       
       pathHelper(m,0,0,"",ans,visited);
       return ans;
       
       
       
    }
}