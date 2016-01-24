package codeforces.cr325;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ProblemA {

	public static void main(String[] args) {
		//File f = new File("in.txt");
		int n;
	
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int[] arr = new int[n+1];
		
		
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		arr[n] = 0;
		
		int total = 0;
		int idx = 0;
		int i;
		
		boolean flag = false;
		
		for (i = 1; i < n+1; i++) {
			if (arr[i-1] + arr[i] > 0) {
				if (arr[i-1] == 1 && arr[i] == 0) {
					total += 1;
					flag = true;
				}
				if (arr[i-1] + arr[i] == 2) {
					total += 1;
					flag = false;
				}
				if (arr[i-1] == 0 && arr[i] == 1 && flag) {
					flag = false;
					total += 1;
				}
			} else {
				flag = false;
			}
		}

		System.out.println(total);
	}

}