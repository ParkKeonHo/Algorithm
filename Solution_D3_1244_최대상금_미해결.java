package com.swexpert.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금_미해결 {
	static int T;
	static int[] su;
	static int SwitchAble;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			count = 0;
			StringTokenizer st = new StringTokenizer(r.readLine());
			String s = st.nextToken();
			su = new int[s.length()];
			for (int i = 0; i < su.length; i++) {
				su[i] = s.charAt(i) - '0';
			}
			SwitchAble = Integer.parseInt(st.nextToken());
			int position = 0;
			boolean eq = false;
			for (int i = 0; i < su.length; i++) {
				int max = Integer.MIN_VALUE;
				for (int j = i; j < su.length; j++) {
					if (max < su[j]) {
						position = j;
						max = su[j];
					}
				}
				if (position == i) {
					continue;
				}
				else {
					int temp = su[position];
					su[position] = su[i];
					su[i] = temp;
					count++;
					if(count == SwitchAble) {
						eq = true;
						break;
					}
				}
			}
			if(!eq) {
				while(count != SwitchAble) {
					int temp = su[su.length-1];
					su[su.length-1] = su[su.length-2];
					su[su.length-2] = temp;
					count++;
				}
			}
			System.out.print("#"+t + " ");
			for (int i = 0; i < su.length; i++) {
				System.out.print(su[i]);
			}
			System.out.println();
		}
	}
}
