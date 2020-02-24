package ssafyalgo_0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_치즈도둑 {
	static int T;
	static int N;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[][] map;
	static boolean[][] visit;
	static int[] result;
	static Queue<P> queue;
	public static class P{
		int y, x;

		public P(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	public static int dungUri(int Day) {
		boolean[][] eat = new boolean[N][N];
		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] <= Day) {
					eat[i][j] = true;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!eat[i][j]) {
					queue.add(new P(i,j));
					while(!queue.isEmpty()) {
						P now = queue.poll();
						for (int d = 0; d < 4; d++) {
							int nx = now.x+dx[d];
							int ny = now.y+dy[d];
							while(nx >= 0 && nx < N && ny >= 0 && ny < N && !eat[ny][nx]) {
								eat[ny][nx] = true;
								queue.add(new P(ny,nx));
							}
						}
						
					}
					num++;
				}
			}
		}
		return num;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(r.readLine());
			queue = new LinkedList<>();
			map = new int[N][N];
			visit = new boolean[N][N];
			result = new int[101];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(r.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//맵 초기화 완료
			for (int day = 0; day <= 100; day++) {
				result[day] = dungUri(day);
			}
			Arrays.sort(result);
			System.out.println(Arrays.toString(result));
			System.out.println("#"+t+" "+result[100]);
		}
	}
}
