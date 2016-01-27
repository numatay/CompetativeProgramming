package codeforces.cr340;

import java.io.*;

public class ProblemA {
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("path.in"));
        PrintWriter wr = new PrintWriter(new FileWriter("path.out"));

		/* solution */
        int n = Integer.parseInt(br.readLine());
        int steps = n / 5;
        n = n % 5;
        steps += n / 4;
        n = n % 4;
        steps += n / 3;
        n = n % 3;
        steps += n / 2;
        n = n % 2;
        steps += n / 1;
        n = n % 1;
        
        System.out.println(steps);
        







		/* cleaning up */
        wr.close();
    }

	public static void main(String[] args) {
		
		ProblemA s = new ProblemA();
		try {
			s.solve();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
