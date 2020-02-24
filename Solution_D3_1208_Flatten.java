package com.swexpert.algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1208_Flatten {
	static int T = 10;
	static int sum;
	static int[] arr;
	static int avg;
	static int dump;
	static int Answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {
			sum = 0;
			dump = Integer.parseInt(r.readLine());
			arr = new int[100];
			StringTokenizer st = new StringTokenizer(r.readLine());
			int n = 0;
			while(st.hasMoreTokens()) {
				arr[n] = Integer.parseInt(st.nextToken());
				sum += arr[n];
				n++;
			}
			int max = 0;
			int min = 0;
			Arrays.sort(arr);
			while(dump != 0 && arr[99]-arr[0] != 0 && arr[99]-arr[0] != 1) {
				Arrays.sort(arr);//오름차순 정렬 된다.
				max = arr[99];
				min = arr[0];
				arr[99] = max-1;
				arr[0] = min+1;
				dump--;
			}
			if(dump == 0) {
				Arrays.sort(arr);
				Answer = arr[99] - arr[0];
			}else {
				Answer = max - min;
			}
			System.out.println("#"+t+" "+Answer);
			
		}
		
	}
}