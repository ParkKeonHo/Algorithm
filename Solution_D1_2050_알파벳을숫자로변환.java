package com.swexpert.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D1_2050_알파벳을숫자로변환 {
	static int T;
	public static void main(String[] args) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s = r.readLine();
		char a = 'A';
		for (int i = 0; i < s.length(); i++) {
			int a1 = s.charAt(i) - a;
			System.out.print((a1+1)+" ");
		}
	}
}
