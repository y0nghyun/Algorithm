import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> pars = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '(')
                pars.push(cur);
            else{
                if(pars.isEmpty()){
                    answer = false;
                    break;
                }
                else{
                    pars.pop();
                }
            }
        }
        if(!pars.isEmpty())
            answer = false;
        return answer;
    }
}