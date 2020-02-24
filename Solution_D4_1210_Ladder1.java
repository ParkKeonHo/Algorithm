package com.ssafy.algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1 {
	static int T = 10; // 테스트케이
	static int N = 100; // 맵 크기
	static int[][] map = new int[N + 1][N];
	static int[] dy = { 1, 0, 0 };// 아래, 왼쪽, 오른쪽
	static int[] dx = { 0, -1, 1 };// 아래, 왼쪽, 오른

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {
			int tc = Integer.parseInt(r.readLine());
			int startX = 0;
			int startY = 0;
			for (int i = 99; i >= 0; i--) {
				StringTokenizer st = new StringTokenizer(r.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						startX = j;
						startY = i;
					}
				}
			}
			Arrays.fill(map[100], 3);
			int d = 0; // 방향
			
			while(true) {
				if(map[startY][startX] == 3) {
					break;
				}
				if(startX-1>=0 && map[startY][startX-1] == 1) {
					d=1;
					while(true) {
						if(map[startY][startX] == 0) {
							startX -= dx[d];
							break;
						} else if(startX == 0) {
							break;
						}
						startX += dx[d];
					}
				}
				//left
				else if(startX+1 < N && map[startY][startX+1] == 1) {
					d=2;
					while(true) {
						if(map[startY][startX] == 0) {
							startX -= dx[d];
							break;
						} else if(startX == N-1) {
							break;
						}
						startX += dx[d];
					}
				}				
				startY += dy[0];
			}
			System.out.println("#"+(tc)+" "+(startX));
		} // map 초기화

	}
}