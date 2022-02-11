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
    
    void subsets(ArrayList<Integer> arr, int i, ArrayList<Integer> ans, int sum){
        
        if(i == arr.size()){
            ans.add(sum);
            return;
        }
        
        sum += arr.get(i);
        subsets(arr,i+1,ans,sum);
        sum-= arr.get(i);
        
        subsets(arr,i+1,ans,sum);
        
    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        subsets(arr,0,ans,0);
        return ans;
        
    }
}