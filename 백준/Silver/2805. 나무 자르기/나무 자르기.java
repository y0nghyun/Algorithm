import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] trees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		int max = 0;
		int min = 0;
		long sum = 0;
		trees = new int[n];
		
		s = br.readLine();
		st = new StringTokenizer(s);
		for(int i=0; i<n; i++) {
			trees[i] = Integer.parseInt(st.nextToken()); 
			if(trees[i] > max)
				max = trees[i];
		}
		int mid = 0;
		mid = (max+min)/2;
		sum = result(mid);
		
		while(min <= max) {
			if(sum < m)
				max = mid - 1;
			else 
				min = mid + 1;
			
			mid = (max+min)/2;
			sum = result(mid);
		}
		System.out.println(mid);
		
	}
	static long result(int high) {
		long sum = 0;
		for(int i= 0; i < trees.length; i++)
			if(trees[i]-high > 0)
				sum += trees[i]-high;
		return sum;
	}

}
