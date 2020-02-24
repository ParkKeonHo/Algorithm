package com.swexpert.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_4485_JelDa {
	static int N;
	static int[][] map;
	static int[][] result;
	static boolean[][] visited;
	static Queue<P> queue = new LinkedList<>();
	static int dx[] = { 0, 1, -1, 0 };
	static int dy[] = { 1, 0, 0, -1 };

	public static class P {
		int y;
		int x;
		int point;

		public P(int y, int x, int point) {
			super();
			this.y = y;
			this.x = x;
			this.point = point;
		}
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			P now = queue.poll();
			visited[now.y][now.x] = true;
			if (result[now.y][now.x] >= now.point) {
				result[now.y][now.x] = now.point;
			}
			for (int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
					int npoint = map[ny][nx] + now.point;
					queue.add(new P(ny, nx, npoint));
					visited[ny][nx] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		int Case = 1;
		Scanner sc = new Scanner(System.in);
		while(true) {
			N = sc.nextInt();
			if (N == 0) {
				break;
			} else {
				map = new int[N][N];
				result = new int[N][N];
				visited = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						map[i][j] = sc.nextInt();
						result[i][j] = Integer.MAX_VALUE;
					}
				}
				queue.add(new P(0, 0, map[0][0]));
				bfs();
				for (int i = 0; i < N; i++) {
					for (int j = 0; j <N; j++) {
						System.out.print(result[i][j]+" ");
					}System.out.println();
				}
				System.out.println("Problem " + Case++ + ": " + result[N - 1][N - 1]);
			}
		}
	}
}
