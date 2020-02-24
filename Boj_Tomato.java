import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_Tomato {
//익은 토마토 1 기다리는 토마토 -2 익을때의 토마토 날짜
	static int[][] map;
	static boolean[][] visit;
	static int N, M;
	static int check() {
		int day = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > max) {
					max = map[i][j];
				}
				if(map[i][j] == -2) {
					return day;
				}
			}
		}
		return max;
	}
	static class P{
		int y, x;

		public P(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	static int Sx, Sy;
	static Queue<P> queue;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = { 0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		M = Integer.parseInt(st.nextToken());//가로
		N = Integer.parseInt(st.nextToken());//세로	
		queue = new LinkedList<P>();
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(r.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					map[i][j] = -2;
				}else if(map[i][j] == 1) {
					queue.add(new P(i, j));
					map[i][j] = 0;
					visit[i][j] = true;
				}
			}
		}
		int day = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				P now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int ny = now.y+dy[d];
					int nx = now.x+dx[d];
					if(ny >= 0 && ny < N && nx >= 0 && nx < M && !visit[ny][nx] && map[ny][nx] == -2) {
						visit[ny][nx] = true;
						map[ny][nx] = day;
						queue.add(new P(ny,nx));
					}
				}
			}
			day++;
		}
		System.out.println(check());
	}
}
