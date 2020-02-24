package com.swexpert.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D1_2005_파스칼삼각형 {
	static int T;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(r.readLine());
			System.out.println("#"+t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print("1 ");
					if(i>=2) {
						int n = 1;
						while(n < i) {
							System.out.print(i+" ");
							n++;
						}
						System.out.print("1 ");
						break;
					}
				}
				System.out.println();
			}
		}
	}
}
