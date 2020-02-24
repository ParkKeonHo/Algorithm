import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//파이프 연결 
public class Solution_4340 {
	static int[][] map, result;
	static int N, T;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };// 상 하 좌 우
	static int Sy, Sx, Fy, Fx;

	static class P {
		int y, x;
		boolean garo;
		int direction;

		public P(int y, int x, boolean garo, int direction) {
			super();
			this.y = y;
			this.x = x;
			this.garo = garo;
			this.direction = direction;
		}
	}

	static Queue<P> queue;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			result = new int[N][N];
			Sy = N - 1;
			Sx = N - 1;
			Fy = 0;
			Fx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					result[i][j] = Integer.MAX_VALUE;
				}
			} // map init complete
			queue = new LinkedList<P>();
			int time = 2;
			result[Sy][Sx] = 1;
			int dir = 0;
			if(map[Sy][Sx] == 1 || map[Sy][Sx] == 2)dir = 2;
			else if(map[Sy][Sx] == 3 || map[Sy][Sx] == 4 || map[Sy][Sx] == 5 || map[Sy][Sx] == 6)dir = 0;
			queue.add(new P(Sy, Sx, true, dir));
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					P now = queue.poll();
					if (now.garo) {// 가로로 들어왔다면
						if (map[now.y][now.x] == 1 || map[now.y][now.x] == 2) {
								int ny = now.y + dy[now.direction];
								int nx = now.x + dx[now.direction];
								if (ny >= 0 && ny < N && nx >= 0 && nx < N && map[ny][nx] != 0) {
									result[ny][nx] = time;
									queue.add(new P(ny, nx, true, now.direction));
								}
						} else if (map[now.y][now.x] == 3 || map[now.y][now.x] == 4 || map[now.y][now.x] == 5
								|| map[now.y][now.x] == 6) {
							for (int d = 0; d < 2; d++) {
								int ny = now.y + dy[d];
								int nx = now.x + dx[d];
								if (ny >= 0 && ny < N && nx >= 0 && nx < N && map[ny][nx] != 0) {
									result[ny][nx] = time;
									queue.add(new P(ny, nx, false, d));
								}
							}
						}
					} else {// 세로로 들어왔다면
						if (map[now.y][now.x] == 1 || map[now.y][now.x] == 2) {
								int ny = now.y + dy[now.direction];
								int nx = now.x + dx[now.direction];
								if (ny >= 0 && ny < N && nx >= 0 && nx < N && map[ny][nx] != 0) {
									result[ny][nx] = time;
									queue.add(new P(ny, nx, false, now.direction));
								}
						} else if (map[now.y][now.x] == 3 || map[now.y][now.x] == 4 || map[now.y][now.x] == 5
								|| map[now.y][now.x] == 6) {
							for (int d = 2; d < 4; d++) {
								int ny = now.y + dy[d];
								int nx = now.x + dx[d];
								if (ny >= 0 && ny < N && nx >= 0 && nx < N && map[ny][nx] != 0) {
									result[ny][nx] = time;
									queue.add(new P(ny, nx, true, d));
								}
							}
						}
					}
				}
				if(result[Fy][Fx] != Integer.MAX_VALUE) {
					break;
				}
				time++;
			}
			System.out.println("#" + t + " " + (result[Fy][Fx]));

		}
	}
}
