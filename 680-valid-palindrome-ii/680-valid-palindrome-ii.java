class Solution {
    
    public boolean isPal(String s, int i, int j){
        
        if(i < 0 || j > s.length()) return false;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
        
    }
    
    public boolean validPalindrome(String s) {
        
        int l = 0;
        int r = s.length()-1;
        
        while(l < r){
            
            if(s.charAt(l) != s.charAt(r)){
                return isPal(s,l+1,r) || isPal(s,l,r-1);
            }
            
            l++;
            r--;
            
        }
        
        return true;
        
    }
}