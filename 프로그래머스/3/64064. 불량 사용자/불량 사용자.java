import java.util.*;

class Solution {
    
    static int answer;
    static boolean[] isUsed;
    static Set<String> combi;
   
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        isUsed = new boolean[user_id.length];
        combi = new HashSet<>();
        recur(user_id,banned_id,0);
        return answer;
    }
    
    static public void recur(String[] user_id, String[] banned_id, int idx){
        if(idx == banned_id.length){
            String s = "";
            for(int i=0;i<isUsed.length;i++){
                if(isUsed[i])
                    s += i;
            }
            if(!combi.contains(s)){
                combi.add(s);
                answer++;
            }
            return;
        }
        for(int i=0; i<user_id.length; i++){
            if(isUsed[i] || user_id[i].length() != banned_id[idx].length())
                continue;
            if(!check(user_id[i],banned_id[idx]))
                continue;
            isUsed[i] = true;
            recur(user_id, banned_id, idx+1);
            isUsed[i] = false;
        }
    }
    
    static public boolean check(String s1, String s2){
        for(int i=0; i<s1.length(); i++){
            if(s2.charAt(i) != '*' && s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }
}