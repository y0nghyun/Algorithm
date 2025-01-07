import java.util.Scanner;

public class Main {

    static String target;
    static boolean flag;
    private static void solution(String cur) {
        if(cur.equals(target))
            flag = true;
        if(cur.length() <= target.length())
            return;
        if(cur.charAt(cur.length()-1)=='A'){
            solution(cur.substring(0,cur.length()-1));
        }
        if(cur.charAt(0) == 'B'){
            cur = cur.substring(1);
            solution(StringReverse(cur));
        }

    }

    private static String StringReverse(String s) {
        String reversedString = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversedString += s.charAt(i);
        }
        return reversedString;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = sc.nextLine();
        String cur = sc.nextLine();
        flag = false;
        solution(cur);
        if(flag)
            System.out.println(1);
        else
            System.out.println(0);
    }
}