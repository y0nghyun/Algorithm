import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            int idx = i;
            if(check(s, idx))
                answer++;
        }
        return answer;
    }
    
    public static boolean check(String s,int start){
        Stack<Character> stack = new Stack();
        for(int i=0; i<s.length(); i++){
            if(start>= s.length())
                start = 0;
            char temp = s.charAt(start);
            if(temp == '(' || temp == '[' || temp == '{')
                stack.push(temp);
            else if(temp == ')'){
                if(stack.isEmpty() || stack.peek() != '(')
                    return false;
                stack.pop();
            }else if(temp == ']'){
                if(stack.isEmpty() || stack.peek() != '[')
                    return false;
                stack.pop();
            }else{
                if(stack.isEmpty() || stack.peek() != '{')
                    return false;
                stack.pop();
            }
            start++;
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}