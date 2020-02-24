package com.swexpert.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_D3_암호문1 {
	static char P;
	static int x;
	static int y;
	static LinkedList<Integer> ll;
	static int N;
	static int number;//명령 갯
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			ll = new LinkedList<>();
			ll.clear();
			N = Integer.parseInt(r.readLine());
			StringTokenizer st = new StringTokenizer(r.readLine());
			while(st.hasMoreTokens()) {
				ll.add(Integer.parseInt(st.nextToken()));
			}
			number = Integer.parseInt(r.readLine());
			st = new StringTokenizer(r.readLine());
			while(st.hasMoreTokens()) {
				P = st.nextToken().charAt(0);
				if(P == 'I') {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int i = 0; i < y; i++) {
						ll.add(x++, Integer.parseInt(st.nextToken()));
					}
				}
			}
			System.out.print("#"+t+" ");
			for (int i = 0; i < 10; i++) {
				System.out.print(ll.get(i)+" ");
			}System.out.println();
		}
		
	}
}
