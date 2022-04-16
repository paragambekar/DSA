class Solution {
    
    public void generate(int n,int opening, int closing, String ds, List<String> ans){
        
        if(opening < 0 || closing < 0) return;
        
        if(ds.length() == (2*n)){
            ans.add(ds);
            return;
        }
        
        if(closing < opening) return;
        
        
        
        if(ds.length() == 0){
            generate(n,opening-1,closing,ds+"(",ans);
        }else{
            
            if(opening <= closing){
                generate(n,opening-1,closing,ds+"(",ans);
                generate(n,opening,closing-1,ds+")",ans);
            }
            
            
        }
        
        
    }
    
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        generate(n,n,n,"",ans);
        return ans;
        
    }
}