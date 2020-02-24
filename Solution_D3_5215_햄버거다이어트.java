package com.swexpert.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트 {
	static int T;
	static int N;
	static int L;
	static int[] Jumsu;
	static int[] Cal;
	static int R;
	static int max;
	static int[] indexArray;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(
				new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			Jumsu = new int[N];
			Cal = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(r.readLine());
				Jumsu[i] = Integer.parseInt(st.nextToken());
				Cal[i] = Integer.parseInt(st.nextToken());
			}//입력 끝
			
			max = 0;
			for (R = 1;  R <= N; R++) {
				indexArray = new int[R];
				combi(0,0);
			}
			System.out.println("#"+t+" "+max);		
		}
	}
	public static void combi(int start, int count) {
		if(count == R) {
			int jumsuSum = 0;
			int carorieSum = 0;
			for (int i = 0; i < R; i++) {
				jumsuSum += Jumsu[indexArray[i]];
				carorieSum += Cal[indexArray[i]];
			}
			if(max < jumsuSum && carorieSum <= L) {
				max = jumsuSum;
			}
			return;
			}
		else {
			for (int i = start; i < N; i++) {
				indexArray[count] = i;
				combi(i+1, count+1);
			}
		}
	}
}
