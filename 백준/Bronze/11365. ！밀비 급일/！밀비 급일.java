import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();
            
            if (input.equals("END")) {
                break;
            }
            
            StringBuilder reversed = new StringBuilder(input);
            System.out.println(reversed.reverse().toString());
        }

        sc.close();
    }
}