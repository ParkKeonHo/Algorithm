package com.ssafy.algorithm;

import java.util.Arrays;

public class Solution_Gravity {
	static int N = 100;
	static char[][] map = new char[N][N];
	static void build_data(int[] data) {
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) ((Math.random() * N) + 1);
		}
	}

	public static void main(String[] args) {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Arrays.fill(map[i], '#');
			}
		}
		int[] data;
		data = new int[N];
		build_data(data);
		char c = 'A';
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i]; j++) {
				map[i][j] = c;
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		int max = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 'A') {
					int Y = i;
					int Anumber = 0;
					while(Y<N) {
						if(map[Y][j] == 'A') {
							Anumber++;//5
						}
						Y++;
					}
					if((N-i)-Anumber > max) {
						max = (N-i)-Anumber;
					}
				}
			}
		}System.out.print("최장길이:"+" "+max);
	}

}
