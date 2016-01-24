package codeforces.cr325;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("in.txt");
		Scanner in = new Scanner(f);
		
		int n = in.nextInt();
		int[] v = new int[n];
		int[] d = new int[n];
		int[] p = new int[n];
		
		for (int i = 0; i < n; i++) {
			v[i] = in.nextInt();
			d[i] = in.nextInt();
			p[i] = in.nextInt();
			
		}
		
		for (int i = 0; i < n; i++) {
			
		}

	}

}
