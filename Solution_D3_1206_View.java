package com.swexpert.algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1206_View {
	static int T = 10;
	static int B; //빌딩 갯수 
	static int[] H; //빌딩 높이 저장 배열 
	static int[] dy = {1, 0, 0}; //하 좌 우 
	static int[] dx = {0, -1, 1};
	static boolean[][] map;
	static int count; //조망권 확보 빌딩 갯수 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {
			count = 0;
			B = Integer.parseInt(r.readLine());
			map = new boolean[256][B]; // 높이 갯
			StringTokenizer st = new StringTokenizer(r.readLine());
			H = new int[B];
			for (int i = 0; i < B; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			for (int x = 0; x < B; x++) {
				for (int y = 0; y < H[x]; y++) {
					map[y][x] = true;
				}
			}			
			for (int i = 0; i < 256; i++) {
				for (int j = 0; j < B; j++) {
					boolean eq = true;
					if(map[i][j] == true) {
						int x = j;
						int y = i;
						for (int k = 0; k < 2; k++) {//양측 검사 
							int Lx = x+dx[1];//좌측 
							if(map[y][Lx] == true) {
								eq = false;
								break;
							}else {
								x = Lx;
							}
						}
						x = j;
						y = i;
						for (int k = 0; k < 2; k++) {//양측 검사 
							int Rx = x+dx[2];//우측 
							if(map[y][Rx] == true) {
								eq = false;
								break;
							}else {
								x = Rx;
							}
						}
						if(eq) count++;
					}
				}
			}
			System.out.println("#"+t+" "+count);
		}
	}
}
