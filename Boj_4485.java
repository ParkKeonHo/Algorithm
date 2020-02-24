import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//녹색 옷을 입은 애가 젤다지?

public class Boj_4485 {
	static class P {
		int y, x, cost;

		public P(int y, int x, int cost) {
			super();
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map, Minmap;
	static int N;
	static int Sy = 0, Sx = 0;
	static Queue<P> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while(true) {
			N = Integer.parseInt(r.readLine());
			if(N == 0) {
				break;
			}
			map = new int[N][N];
			Minmap = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(r.readLine());
				Arrays.fill(Minmap[i], Integer.MAX_VALUE);
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			queue = new LinkedList<P>();
			queue.add(new P(Sy, Sx, map[Sy][Sx]));
			while (!queue.isEmpty()) {
				P now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int ny = now.y+dy[d];
					int nx = now.x+dx[d];
					if(ny>=0 && ny<N && nx>=0 && nx< N) {
						if(now.cost+map[ny][nx] < Minmap[ny][nx]) {
							Minmap[ny][nx] = now.cost+map[ny][nx];
							queue.add(new P(ny, nx, now.cost+map[ny][nx]));
						}else {
							continue;
						}
					}
				}
			}
			System.out.println("Problem "+t+": "+Minmap[N-1][N-1]);
			t++;
		}
	}
}
