import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1868_D4_파핑파핑지뢰찾기 {
	static int Click, T, N, dotCount;
	static char[][] map;
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static P ClickPoint;

	public static class P {
		int y, x;

		public P(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static Queue<P> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(r.readLine());
			map = new char[N][N];
			Click = 0;
			dotCount = 0;
			queue = new LinkedList<P>();
			for (int i = 0; i < N; i++) {
				char[] tmp = r.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp[j];
					if (map[i][j] == '.') {
						dotCount++;
					}
				}
			} // 초기화 완료

			// 게임 시작!!!
			while (dotCount > 0) {
				boolean ok = false;// true : 8방탐색 했는데 주변에 지뢰가 없어 클릭 가능하다, false : 주변에 지뢰가 없는 점이 없다.
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] == '.') {
							ok = true;
							int y = i;
							int x = j;
							for (int d = 0; d < 8; d++) {
								int ny = y + dy[d];
								int nx = x + dx[d];
								if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
									if (map[ny][nx] != '*')
										continue;
									else if (map[ny][nx] == '*') {
										ok = false;
										break;
									}
								}
							}
							if (ok) {
								map[y][x] = '0';
								Click++;
								dotCount--;// 클릭함
								queue.add(new P(y,x));
								while (!queue.isEmpty()) {// 이제 확장해 가면 된다.
									P now = queue.poll();
									for (int d = 0; d < 8; d++) {
										int nextY = now.y + dy[d];
										int nextX = now.x + dx[d];
										if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < N
												&& map[nextY][nextX] == '.') {
											int mine = 0;
											for (int dir = 0; dir < 8; dir++) {
												int checkY = nextY + dy[dir];
												int checkX = nextX + dx[dir];
												if (checkY >= 0 && checkY < N && checkX >= 0 && checkX < N) {
													if (map[checkY][checkX] == '*') {
														mine++;
													}
												}
											}
											if (mine == 0) {
												map[nextY][nextX] = '0';
												dotCount--;
												queue.add(new P(nextY, nextX));
											} else if (mine != 0) {
												dotCount--;
												map[nextY][nextX] = (char) (mine + '0');
											}
										}
									}
								}
							}
						}
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] == '.') {
							dotCount--;
							Click++;
						}
					}
				}
			}
			System.out.println("#" + t + " " + Click);
		}
	}
}
