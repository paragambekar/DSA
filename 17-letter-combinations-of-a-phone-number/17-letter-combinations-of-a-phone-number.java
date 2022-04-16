class Solution {
    
    public void letterCombi(String digits, String map[], List<String> ans, int idx, String ds){
        
        // System.out.println("Hello");
        if(ds.length() == digits.length()){
            // System.out.println(ans);
            ans.add(ds);
            return;
        }
        
        if(idx == digits.length()) return;
        
        String currString = map[digits.charAt(idx)-'0'];
        // System.out.println(currString);
        for(int i = 0; i < currString.length(); i++){
            letterCombi(digits,map,ans,idx+1,ds+currString.charAt(i));
        }
        
    }
    
    public List<String> letterCombinations(String digits) {
        
        String map[] = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        List<String> ans = new ArrayList<String>();
        if(digits.length() == 0) return ans;
        
        letterCombi(digits,map,ans,0,"");
        return ans;
        
    }
}