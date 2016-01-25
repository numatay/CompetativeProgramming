package templates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Skeleton {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		try {
			s.solve();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}

class Solution {
	public void solve() throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("in.txt")); 
		PrintStream ps = new PrintStream(System.out);
		
		/* solution */
		
		
		
		
		
		
		
		/* cleaning up */
		ps.close();
	}
}