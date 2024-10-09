import java.util.*;
import java.lang.*;

class Solution {
    static HashMap<String,Integer> list;
    static int[] topNum;
    static char[] isSelected;
    
    public String[] solution(String[] orders, int[] course) {
        list = new HashMap();
        topNum = new int[11];
        ArrayList<String> temp = new ArrayList();
        for(String S : orders){
            for(Integer n : course){
                isSelected = new char[n];
                combi(0, 0, n, S);
            }
        }
        for (String key: list.keySet()) {
			Integer value = list.get(key);
            if(topNum[key.length()] == value && topNum[key.length()] >= 2){
                temp.add(key);
            }
		}
        Collections.sort(temp);
        String[] answer = new String[temp.size()];
        for(int i=0; i<temp.size();i++){
            answer[i] = temp.get(i);
        }

        return answer;
    }
    
    public void combi(int idx, int start, int limit, String target){
        if(idx >= limit){
            String S = "";
            for(int i=0; i<isSelected.length; i++){
                S += isSelected[i];
            }
            S = sortString(S);
            if(list.containsKey(S)){
                int num = list.get(S);
                if(topNum[S.length()] < num+1)
                    topNum[S.length()] = num+1;
                list.replace(S,num+1);
            }else{
                if(topNum[S.length()] < 1)
                    topNum[S.length()] = 1;
                list.put(S,1);
            }
            return;
        }
        
        for(int i = start; i < target.length(); i++){
            isSelected[idx] = target.charAt(i);
            combi(idx+1,i+1,limit,target);
        }
        
    }
    
    public String sortString(String s){
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        String result = new String(charArr);
        return result;
    }
    
}