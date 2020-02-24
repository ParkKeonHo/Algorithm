import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_PuyoPuyo {
	static char[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1,0, 0};
	
	static class P{
		int y, x;

		public P(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static int Pang() {
		Queue<P> queue = new LinkedList<P>();
		boolean ok = false;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				int cnt = 0;
				if(map[i][j] != '.') {
					boolean[][] visit = new boolean[12][6];
					cnt++;
					visit[i][j] = true;
					queue.add(new P(i, j));
					while(!queue.isEmpty()) {
						P now = queue.poll();
						for (int d = 0; d < 4; d++) {
							int ny = now.y+dy[d];
							int nx = now.x+dx[d];
							if(ny>= 0 && ny < 12 && nx >= 0 && nx < 6 && !visit[ny][nx] && map[ny][nx] == map[now.y][now.x]) {
								visit[ny][nx] = true;
								cnt++;
								queue.add(new P(ny, nx));
							}
						}
					}
					if(cnt>=4) {
						ok = true;
						for (int k = 0; k < 12; k++) {
							for (int m = 0; m < 6; m++) {
								if(visit[k][m]) {
									map[k][m] = '.';
								}
							}
						}
					}
				}
			}
		}
		return ok?1:0;
	}
	static void mapSetting() {
		for (int i = 11; i >= 1; i--) {
			for (int j = 0; j < 6; j++) {
				if(map[i][j] == '.') {
					boolean eq = false;
					for (int k = i-1; k >=0; k--) {
						if(map[k][j] !='.') {
							eq = true;
							break;
						}
					}
					if(eq) {
						while(map[i][j] == '.') {
							for (int k = i; k >=1; k--) {
								map[k][j] = map[k-1][j];
							}
						}
					}
				}
			}
		}
	}
	static int chain;
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		for (int i = 0; i <12; i++) {
			char[] tmp = r.readLine().toCharArray();
			for (int j = 0; j < 6; j++) {
				map[i][j] = tmp[j];
			}
		}
		int result = Pang();
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
		System.out.println();
		mapSetting();
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
		chain = result;
		while(result != 0) {
			result = Pang();
			System.out.println();
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					System.out.print(map[i][j]);
				}System.out.println();
			}
			mapSetting();
			System.out.println();
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					System.out.print(map[i][j]);
				}System.out.println();
			}
			chain+= result;
		}
		System.out.println(chain);
	}
}