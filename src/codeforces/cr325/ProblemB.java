package codeforces.cr325;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("in.txt");
		Scanner in = new Scanner(f);
		
		int n = in.nextInt();
		
		int[] pretop = new int[n];
		int[] top = new int[n];
		int[] bot = new int[n];
		int[] prebot = new int[n];
		int[] mid = new int[n];
		int[] sum = new int[n];
		
		
		for (int i = 1; i < n; i++) {
			top[i] = in.nextInt();
		}
		for (int i = 1; i < n; i++) {
			bot[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			mid[i] = in.nextInt();
		}
		for (int i = 1; i < n; i++) {
			pretop[i] = pretop[i-1] + top[i];
		}
		for (int i = n-1; i > 0; i--) {
			prebot[i-1] = prebot[i] + bot[i];
		}

		int i,k = 0;
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		for (i = n-1; i > 0; i--) {
			sum[i] = pretop[i] + mid[i] + prebot[i];
		}
		sum[i] = pretop[i] + mid[i] + prebot[i];
		
		for (int j = 0; j < n; j++) {
			if (sum[j] < min1) {
				min1 = sum[j];
				k = j;
			}
		}
		for (int j = 0; j < n; j++) {
			if (sum[j] < min2 && i != k) {
				min2 = sum[j];
			}
		}
		
		System.out.println(min1+ " " +min2);
		
		
	}

	

}
