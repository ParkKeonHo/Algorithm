import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1012_유기농배추 {
	static int T, M, N, K, cnt;
	static int[][] map;
	static Queue<P> queue;
	static class P{
		int y, x;

		public P(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0,-1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			queue = new LinkedList<P>();
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(r.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						map[i][j] = -1;
						queue.add(new P(i, j));
						while(!queue.isEmpty()) {
							P now = queue.poll();
							for (int d = 0; d < 4; d++) {
								int ny = now.y+dy[d];
								int nx = now.x+dx[d];
								if(ny >=0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == 1) {
									map[ny][nx] = -1;
									queue.add(new P(ny, nx));
								}
							}
						}
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
