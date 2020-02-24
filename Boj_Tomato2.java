import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_Tomato2 {
	static int[][][] map;
	static boolean[][][] visit;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dz = { -1, 1 };

	static class P {
		int z, y, x;

		public P(int z, int y, int x) {
			super();
			this.z = z;
			this.y = y;
			this.x = x;
		}

	}

	static int H, N, M; // 높이 세로 가로
	static int Sz, Sx, Sy; // 높이 세로 가로

	public static int check() {
		int day = -1;
		int max = Integer.MIN_VALUE;
		boolean eq = false;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[k][i][j] > max) {
						max = map[k][i][j];
					} if (map[k][i][j] == -2) {
						eq = true;
					}
				}
			}
		}
		return eq ? day : max;
	}

	static Queue<P> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		visit = new boolean[H][N][M];
		queue = new LinkedList<P>();
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(r.readLine());
				for (int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if (map[h][i][j] == 0) {
						map[h][i][j] = -2;
					} else if (map[h][i][j] == 1) {
						Sz = h;
						Sy = i;
						Sx = j;
						visit[Sz][Sy][Sx] = true;
						map[Sz][Sy][Sx] = 0;
						queue.add(new P(Sz, Sy, Sx));
					}
				}
			}
		}
		int day = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				P now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];
					if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visit[now.z][ny][nx]
							&& map[now.z][ny][nx] == -2) {
						map[now.z][ny][nx] = day;
						visit[now.z][ny][nx] = true;
						queue.add(new P(now.z, ny, nx));
					}
				}
				int up = now.z+dz[0];
				int down = now.z+dz[1];
				if(up >= 0 && !visit[up][now.y][now.x] && map[up][now.y][now.x] == -2) {
					map[up][now.y][now.x]= day;
					visit[up][now.y][now.x]= true;
					queue.add(new P(up, now.y, now.x));
				}
				if(down < H && !visit[down][now.y][now.x] && map[down][now.y][now.x] == -2) {
					map[down][now.y][now.x]= day; 
					visit[down][now.y][now.x]= true;
					queue.add(new P(down, now.y, now.x));
				}
			}
			day++;
		}
		System.out.println(check());
	}
}
