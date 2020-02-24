import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178_미로탐색 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	public static class P{
		int y, x;

		public P(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = { 0, 0, -1, 1};
	static Queue<P> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			char[] tmp = r.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j]-48;
			}
		}
		P start = new P(0, 0);
		visit[0][0] = true;
		queue.add(start);
		bfs();
		System.out.println(map[N-1][M-1]);
	}
	public static void bfs() {
		int distance = 2;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				P now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nx = now.x+dx[d];
					int ny = now.y+dy[d];
					if(nx >= 0 && nx < M && ny>=0 && ny < N && !visit[ny][nx] && map[ny][nx] != 0) {
						visit[ny][nx] = true;
						map[ny][nx] = distance;
						queue.add(new P(ny,nx));
					}
				}
			}
			distance++;
		}
	}
}
