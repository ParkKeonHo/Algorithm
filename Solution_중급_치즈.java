package ssafyalgo_0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_중급_치즈 {
	static int N;
	static int M;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = { 0, 0, -1, 1};
	static int map[][];
	static int CheeseCount;
	static int Hour;
	static Queue<P> queue;
	static int T;
	static class P{
		int y, x;

		public P(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			queue = new LinkedList<>();
			CheeseCount = 0;
			queue.clear();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(r.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						CheeseCount++;
					}
				}
			}
			Hour = 0;
			int out = -1;
			while(CheeseCount > 0) {
				//외부 지정 : -1 내부 : 0
				queue.add(new P(0, 0));
				map[0][0] = out;
				while(!queue.isEmpty()) {
					P now = queue.poll();
					for (int d = 0; d < 4; d++) {
						int ny = now.y+dy[d];
						int nx = now.x+dx[d];
						if(ny>=0 && ny <N && nx>=0 && nx < M && map[ny][nx] != 1 && map[ny][nx] != out) {
							map[ny][nx] = out;
							queue.add(new P(ny, nx));
						}
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if(map[i][j] == 1) {
							int count = 0;
							for (int d = 0; d < 4; d++) {
								if(map[i+dy[d]][j+dx[d]] == out) {
									count++;
								}
							}
							if(count>= 2) {
								CheeseCount--;
								map[i][j] = 0;
							}
						}
					}
				}
				out--;
				Hour++;
			}
			System.out.println(Hour);
		}
	}
}
