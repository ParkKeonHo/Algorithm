import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//벽 부수고 이동하기 
public class Boj_2206 {
	static boolean[][][] visit;
	static Queue<P> queue;
	static class P{
		int y, x, power, time;//1:Power가 남아 있다. 0:Power이 없음 
		public P(int y, int x, int power, int time) {
			super();
			this.y = y;
			this.x = x;
			this.power = power;
			this.time = time;
		}
	}
	static int[][] result, map;
	static int Sx, Sy, Fx, Fy, N, M;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st. nextToken());
		M = Integer.parseInt(st. nextToken());
		map = new int[N][M];
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] tmp = r.readLine().toCharArray();
			Arrays.fill(result[i], Integer.MAX_VALUE);
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp[j]-48;
			}
		}
		queue = new LinkedList<P>();
		visit = new boolean[N][M][2];
		Sx = 0;
		Sy = 0;
		Fx = M-1;
		Fy = N-1;
		queue.add(new P(Sy, Sx, 1, 0));
		visit[Sy][Sx][1] = true;
		result[Sy][Sx] = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				P now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int ny = now.y+dy[d];
					int nx = now.x+dx[d];
					if(ny>=0 && ny<N && nx>=0 && nx<M) {
						//힘이 있을때 1을 만났을 때 
						if(now.power == 1 && !visit[ny][nx][1] && map[ny][nx] == 1) {
							queue.add(new P(ny, nx, 0, now.time+1));
							visit[ny][nx][0] = true;
							if(result[ny][nx] > now.time+1) {
								result[ny][nx] = now.time+1;
							}
						}
						//힘이 있을때 0을 만났을 때
						else if(now.power == 1 && !visit[ny][nx][1] && map[ny][nx] == 0) {
							queue.add(new P(ny, nx, 1, now.time+1));
							visit[ny][nx][1] = true;
							if(result[ny][nx] > now.time+1) {
								result[ny][nx] = now.time+1;
							}
						}
						//힘이 없을때 1을 만났을 때
						else if(now.power == 0 && map[ny][nx] == 1) {
							continue;
						}
						//힘이 없을때 0을 만났을 때 
						else if(now.power == 0 && !visit[ny][nx][0] && map[ny][nx] == 0) {
							queue.add(new P(ny, nx, 0,now.time+1));
							visit[ny][nx][0] = true;
							if(result[ny][nx] > now.time+1) {
								result[ny][nx] = now.time+1;
							}
						}
					}
				}
			}
		}
		System.out.println((result[Fy][Fx]==Integer.MAX_VALUE)?-1:result[Fy][Fx]+1);
	}
}
