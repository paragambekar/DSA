// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    
    void helper(ArrayList<Integer> arr, int idx,int sum, ArrayList<Integer> ans){
        
        // if(idx == arr.size()){
        //     ans.add(sum);
        //     return;
        // }
        
        // helper(arr,idx+1,sum+arr.get(idx),ans);
        
        // helper(arr,idx+1,sum,ans);
        
        ans.add(sum);
        
        for(int i = idx; i < arr.size(); i++){
            
            helper(arr,i+1,sum+arr.get(i),ans);
            
        }
        
    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        
        ArrayList<Integer> ans = new ArrayList<>();
        helper(arr,0,0,ans);
        return ans;
        
    }
}