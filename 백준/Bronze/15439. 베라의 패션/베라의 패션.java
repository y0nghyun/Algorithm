import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //상의 N개 하의 N개
        br.close();

        bw.write(N*(N-1) + "\n");

        bw.flush();
        bw.close();
    }

}