package templates;

import java.io.*;

public class Skeleton {
    public void solve() throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("path.in"));
        PrintWriter wr = new PrintWriter(new FileWriter("path.out"));

		/* solution */







		/* cleaning up */
        wr.close();
    }

	public static void main(String[] args) {
		
		Skeleton s = new Skeleton();
		try {
			s.solve();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
