import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//연구소3 
public class Boj_17412 {
	static int Virus, N, M, ans;
	static int[][] map, copy;
	static boolean[] used;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] visit;

	static class P {
		int y, x;

		public P(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static Queue<P> queue;
	static P[] VirusPoint;

	static void deepCopy() {
		copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

	static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copy[i][j] == 0 && !visit[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	static void VirusCM(int start, int count) {
		if (count == M) {
			queue = new LinkedList<P>();
			visit = new boolean[N][N];
			for (int i = 0; i < Virus; i++) {
				if (used[i]) {
					queue.add(VirusPoint[i]);
					visit[VirusPoint[i].y][VirusPoint[i].x] = true;
				}
			}
			deepCopy();
			bfs();
			return;
		}
		for (int i = start; i < Virus; i++) {
			if (!used[i]) {
				used[i] = true;
				VirusCM(i + 1, count + 1);
				used[i] = false;
			}
		}
	}

	static void bfs() {
		int time = 0;
		while (!queue.isEmpty()) {
			if (check()) {// 맵을 다 돌았을
				if (ans > time) {
					ans = time;
					break;
				}
			}
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				P now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];
					if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visit[ny][nx] && map[ny][nx] != 1) {
						visit[ny][nx] = true;
						queue.add(new P(ny, nx));
						copy[ny][nx] = time;
					}
				}
			}
			time++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = Integer.MAX_VALUE;
		Virus = 0;
		VirusPoint = new P[10];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(r.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					VirusPoint[Virus++] = new P(i, j);
				}
			}
		} // map init complete
		used = new boolean[Virus];
		VirusCM(0, 0);
		if(ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);

	}
}
