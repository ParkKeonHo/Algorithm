package com.swexpert.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576_Tomato {
	static int N, M, day;
	static boolean[][] visited;
	static int[][]map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static Queue<P> queue = new LinkedList<>();
	public static class P{
		int y;
		int x;
		public P(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	public static void bfs() {
		day = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				P now = queue.poll();
				visited[now.y][now.x] = true;
				map[now.y][now.x] = day;
				for (int j = 0; j < 4; j++) {
					int ny = now.y+dy[j];
					int nx = now.x+dx[j];
					if(ny>=0 && ny < N && nx >= 0 && nx < M && map[ny][nx]!=-1 && !visited[ny][nx]) {
						queue.add(new P(ny,nx));
						visited[ny][nx] = true;
					}
				}
			}
			day++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(r.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					queue.add(new P(i,j));
				}
			}
		}
		bfs();
		int max = Integer.MIN_VALUE;
		boolean eq = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					max = 0;
					eq = false;
					break;
				}
				else if(map[i][j] > max) {
					max = map[i][j];
				}
			}
			if(!eq)break;
		}
		System.out.println(max-1);
	}

}
