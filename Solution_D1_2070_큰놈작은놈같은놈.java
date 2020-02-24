package com.swexpert.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D1_2070_큰놈작은놈같은놈 {
	static int T;
	public static void main(String[] args) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			if(i-j < 0)
				System.out.println("#"+t+" <");
			else if(i-j == 0)
				System.out.println("#"+t+" =");
			else if(i-j > 0)
				System.out.println("#"+t+" >");
		}
	}
}
