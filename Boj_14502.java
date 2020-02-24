import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//연구소 
public class Boj_14502 {
	static class P{ // 0의 좌표를 저장할 포인트 
		int y, x;
		public P(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static int [] dy = {-1, 1, 0, 0};
	static int [] dx = {0, 0, -1, 1};
	static int CleanPoint, N, M, Max;
	static Queue<P> queue;
	static P[] CleanPointArray;
	static int[][] map, copy;
	static boolean[] used;
	static void deepCopy() {
		copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	static int check() {
		int CleanArea = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j] == 0) {
					CleanArea++;
				}
			}
		}
		return CleanArea;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		CleanPoint = 0;
		CleanPointArray = new P[N*M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(r.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					CleanPointArray[CleanPoint++] = new P(i, j);
				}
			}
		} // map init complete
		Max = Integer.MIN_VALUE;
		used = new boolean[CleanPoint];
		CleanPointC3(0, 0);
		System.out.println(Max);
	}
	private static void CleanPointC3(int start, int count) {
		if(count == 3) {
			queue = new LinkedList<P>();
			deepCopy();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copy[i][j] == 2) {
						queue.add(new P(i, j));
					}
				}
			}
			for (int i = 0; i < CleanPoint; i++) {
				if(used[i]) {
					copy[CleanPointArray[i].y][CleanPointArray[i].x] = 1;
				}//그 위치에다가 벽을 세워본다.
			}
			bfs();
			return;
		}
		if(start == CleanPoint) {
			return;
		}
		used[start] = true;
		CleanPointC3(start+1, count+1);
		used[start] = false;
		CleanPointC3(start+1, count);
	}
	private static void bfs() {
		while(!queue.isEmpty()) {
			P now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int ny = now.y+dy[d];
				int nx = now.x+dx[d];
				if(ny>=0 && ny<N && nx>=0 && nx<M && copy[ny][nx] == 0) {
					copy[ny][nx] = 2;
					queue.add(new P(ny, nx));
				}
			}
		}
		int result = check();
		Max = Math.max(Max, result);
	}
}
