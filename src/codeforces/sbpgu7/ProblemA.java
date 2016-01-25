package codeforces.sbpgu7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ProblemA {

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
		BufferedReader br = new BufferedReader(new FileReader("path.in")); 
		PrintWriter wr = new PrintWriter(new FileWriter("path.out"));
		
		/* solution */
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		char[][] mp = new char[n][m];
		int x = 0, y = 0;
		
		char[] rows = null;
		for (int i = 0; i < n; i++) {
			rows = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				mp[i][j] = rows[j];
				if (rows[j] == 'A') {
					x = i;
					y = j;
				}
			}
		}
		int c = 0;
		char ch = 'A';
		boolean flag = true;
		while(flag) {
			flag = false;
			if (mp[x][y] == ch) {
				ch++;
				c++;
				flag = true;
			}
			if (x+1 < n && mp[x+1][y] == ch) { //bot
				x++;
			} else if (x-1 >= 0 && mp[x-1][y] == ch) { //top
				x--;
			} else if (y+1 < m && mp[x][y+1] == ch) { //right
				y++;
			} else if (y-1 >= 0 && mp[x][y-1] == ch) { //left
				y--;
			}
		}
		
		wr.println((c == 26 ? "YES" : "NO"));
		wr.close();
	}
	

}