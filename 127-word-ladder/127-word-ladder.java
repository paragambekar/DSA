class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord)){
            return 0;
        }
        
        HashMap<String,Boolean> vmap = new HashMap<>();
        
        for(String s: wordList){
            vmap.put(s,false);
        }
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        vmap.put(beginWord,true);
        
        int ans = 1;
        
        while(!q.isEmpty()){
    
            int n = q.size();
            
            for(int i = 0; i < n; i++){
                
                String front = q.poll();
                if(front.equals(endWord)){
                    return ans;
                }
                
                wordMatch(front,vmap,q); 
            }
            
            ans++;
            
            
        }
        
       return 0; 
    }
    
    public void wordMatch(String w, HashMap<String,Boolean> vmap, Queue<String> q){
        
        for(int i = 0; i < w.length(); i++){
        
            char[] ch = w.toCharArray();
            
            for(int j = 0; j < 26; j++){
                
                ch[i] = (char)('a'+ j);
                
                String s = String.valueOf(ch);
                
                if(vmap.containsKey(s) && vmap.get(s) == false){
                    q.add(s);
                    vmap.put(s,true);
                }
                
            }
            
        }
        
        
        
    }
}









