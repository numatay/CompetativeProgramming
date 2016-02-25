package codeforces.cr340;


import java.io.*;
import java.util.Scanner;

public class ProblemC {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new FileReader("in.txt"));
		int n = in.nextInt();
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		
		int[][] dist = new int[2][n];
		int[] flx = new int[n];
		int[] fly = new int[n];
		
		for (int i = 0; i < n; i++) {
			flx[i] = in.nextInt();
			fly[i] = in.nextInt();
			dist[0][i] = getDist(x1,y1,flx[i],fly[i]);
			dist[1][i] = getDist(x2,y2,flx[i],fly[i]);
			
			System.out.println("Dist p1: " + dist[0][i]);
			System.out.println("Dist p2: " + dist[1][i]);
			System.out.println("----");
		}
		
		int dd = getDist(x1,y1,x2,y2);
		System.out.println("dd " + dd);
		
		int sum = Integer.MAX_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
		int mm = 0;
		int mm1 = 0;

		if (n >= 3) {
			
			for (int i = 0; i < n; i++) {
				if (min1 > dist[0][i]) {
					min1 = dist[0][i];
					mm = i;
				}
			}
			for (int i = 0; i < n; i++) {
				if (max1 < dist[1][i] && i != mm) {
					max1 = dist[1][i];
				}
			}	
			for (int i = 0; i < n; i++) {
				if (min2 > dist[1][i]) {
					min2 = dist[1][i];
					mm1 = i;
				}
			}
			for (int i = 0; i < n; i++) {
				if (max2 < dist[0][i] && i != mm) {
					max2 = dist[0][i];
				}
			}	
			System.out.println(Math.min((min1+max1),(min2+max2)));
		} else {
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int tmp = dist[0][i] + dist[1][j];
					if (sum > tmp) {
						sum = tmp;
					}
					//System.out.println(dist[0][i] + dist[1][j]);
				}
				
			}
			System.out.println(sum);
			
		}
	
	}
	
	public static int getDist(int x1, int y1, int x2, int y2) {
		return (x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1);
	}
	
	
	
}