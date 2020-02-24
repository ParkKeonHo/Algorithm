package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_3307_최장증가부분수열 {
	static int T;
	static int N;
	static int[] A;
	static int[] D;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(r.readLine());
			A = new int[N];
			D = new int[N];
			StringTokenizer st = new StringTokenizer(r.readLine());
			for(int i = 0; i < A.length; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}//A 입력 완료
			Arrays.fill(D, 1);
			for(int i = 0; i < A.length;i++) {
				for(int j = 0; j < i; j++) {
					if(A[i]>=A[j] && D[i] <= D[j]) {
						D[i] = D[j] +1;
					}
				}
			}
			int max = 0;
			for (int i = 0; i < A.length; i++) {
				if(max < D[i])
					max = D[i];
			}
			System.out.println("#"+t+" "+max);
			
		}
		
	}
}