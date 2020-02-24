package com.swexpert.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D1_2058_자릿수더하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s = r.readLine();
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i)-'0';
		}
		System.out.print(sum);
	}
}
