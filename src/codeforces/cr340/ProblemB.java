package codeforces.cr340;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemB {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		
		
		
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			if (arr[i] == 1) {
				l.add(i);
			}
			
		}
		long sum = (l.size() == 0 ? 0 : 1);
		for (int i = 1; i < l.size(); i++) {
			sum *= (l.get(i)-l.get(i-1));
		}
		
		System.out.println(sum);

	}
	
	
	
}
