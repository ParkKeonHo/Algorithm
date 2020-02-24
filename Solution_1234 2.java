package com.swexpert.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.IllegalSelectorException;
import java.util.StringTokenizer;

public class Solution_1234 {
	static String s;
	static int T = 10;
	static int len;
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			len = Integer.parseInt(st.nextToken());
			s = st.nextToken();
			for (int i = 0; i < len/2; i++) {
				s = s.replaceAll("00", "");
				s = s.replaceAll("11", "");
				s = s.replaceAll("22", "");
				s = s.replaceAll("33", "");
				s = s.replaceAll("44", "");
				s = s.replaceAll("55", "");
				s = s.replaceAll("66", "");
				s = s.replaceAll("77", "");
				s = s.replaceAll("88", "");
				s = s.replaceAll("99", "");
			}
			System.out.println("#"+t+" "+s);
		}
		
	}
}
