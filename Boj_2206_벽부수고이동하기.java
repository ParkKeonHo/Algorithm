import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2206_벽부수고이동하기 {
	static int N, M;
	static int[][] map;
	static int[][] result;
	static boolean[][] visit;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static class P{
		int y, x;
		boolean power;
		public P(int y, int x, boolean power) {
			super();
			this.y = y;
			this.x = x;
			this.power = power;
		}
		
	}
	static Queue<P> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		result = new int[N][M];
//		for (int i = 0; i < N; i++) {
//			Arrays.fill(result[i], Integer.MAX_VALUE);
//		}
		visit = new boolean[N][M];
		queue = new LinkedList<P>();
		for (int i = 0; i < N; i++) {
			char[] tmp = r.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j]-'0';
			}
		}
		int Fx = M-1;
		int Fy = N-1;
		int Sx = 0;
		int Sy = 0;
		visit[Sy][Sx] = true;
		result[Sy][Sx] = 1;
		queue.add(new P(Sy, Sx, true));
		int count = 2;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				P now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nx = now.x+dx[d];
					int ny = now.y+dy[d];
					if(nx >= 0 && nx < M && ny >= 0 && ny < N && !visit[ny][nx]) {
						if(now.power == true && map[ny][nx] == 1) {
								result[ny][nx] = count;
							queue.add(new P(ny, nx, false));
							visit[ny][nx] = true;
						}else if(now.power == true && map[ny][nx] == 0){
								result[ny][nx] = count;
							queue.add(new P(ny, nx, true));
							visit[ny][nx] = true;							
						}else if(now.power == false && map[ny][nx] == 1) {
							continue;
						}else if(now.power == false && map[ny][nx] == 0) {
								result[ny][nx] = count;
							queue.add(new P(ny, nx, false));
							visit[ny][nx] = true;
						}
					}
				}
			}
			count++;
		}
		System.out.println(result[Fy][Fx] != 0 ? result[Fy][Fx] : -1);
	}
	
}
