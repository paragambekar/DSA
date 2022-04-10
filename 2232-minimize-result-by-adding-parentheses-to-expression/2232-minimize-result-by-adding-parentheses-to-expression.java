class Solution {
    
    
    public String minimizeResult(String expression) {
        
        
        String s1 = "";
        String s2 = "";
        String temp = "";
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < expression.length(); i++){
            
            if(expression.charAt(i) != '+'){
                temp = temp + expression.charAt(i);
            }else{
                s1 = temp;
                // System.out.println("s1 "+s1);
                temp = "";
            }
            
        }
        s2 = temp;
        // System.out.println("s2 "+s2);
        String exp = "";
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                
                String lhsbb = s1.substring(0,i);
                int lhbb = -1;
                if(lhsbb.equals("")){
                    lhbb = 1;
                }else{
                    lhbb = Integer.parseInt(lhsbb);
                }
                
                String lhsab = s1.substring(i);
                int lhab = Integer.parseInt(lhsab);
                
                String rhsbb = s2.substring(0,j+1);
                int rhbb = Integer.parseInt(rhsbb);
                
                String rhsab = s2.substring(j+1);
                int rhab = -1;
                if(rhsab.equals("")){
                    rhab = 1;
                }else{
                    rhab = Integer.parseInt(rhsab);
                }
                
                // System.out.println(lhsbb + "(" + lhsab + "+" + rhsbb + ")" + rhsab);
                
                
                int sum = lhbb * (lhab + rhbb) * rhab;
                
                
                
                if(sum  < min){
                    min = sum;
                    exp = lhsbb + "(" + lhsab + "+" + rhsbb + ")" +  rhsab ;           
                }
                
                
            }
        }
        
        return exp;
    }
}