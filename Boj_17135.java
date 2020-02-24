import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//캐슬 디펜스 
public class Boj_17135 {
	static int N, M, D, ans, Enemy;
	static int[][] map, GameMap;
	static boolean[][] visit, AttackPoint;

	static class P {
		int y, x;

		public P(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static P[] Archer;
	static Queue<P> queue;
	static int[] dy = { 0, -1, 0 };
	static int[] dx = { -1, 0, 1 };
	static boolean[] used;

	// -------------------------------필요한 필드 >> 힙 메모리 생성
	// 완료--------------------------------
	static void deepCopy() {
		GameMap = new int[N + 1][M];
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < M; j++) {
				GameMap[i][j] = map[i][j];
			}
		}
	}

	private static void DefenseGame(int idx, int count) {
		if (count == 3) {// 궁수가 다 자리를 잡았다면
			deepCopy();// game 진행할 맵을 생성하자.
			int k = 0;
			for (int i = 0; i < M; i++) {
				if (used[i]) {
					Archer[k++] = new P(N, i);
				}
			} // 궁수 위치 저장하자
			int cnt = 0;// 공격 당한 적의 수를 저장
			int liveEnemy = Enemy; // 종료 조건
			// 게임 진행
			while (liveEnemy != 0) {
				// 궁수 3명이 차례로 공격을 한다.
				AttackPoint = new boolean[N + 1][M]; // 공격할 위치 다시 초기화
				for (int Arch = 0; Arch < 3; Arch++) {
					visit = new boolean[N + 1][M];
					Arrays.fill(visit[N], true);// visit map 초기화 완료
					boolean attack = false; // 공격할 적을 찾았다면 true가 될 것이다.
					queue = new LinkedList<P>();
					queue.add(Archer[Arch]);// 첫번째 궁수부터 공격할 적 탐색 시작 1~3궁수
					int time = 0;
					while (time != D) { // 사정거리 밖으로 계산하지 않기 위해
						int size = queue.size();
						for (int i = 0; i < size; i++) {
							P now = queue.poll();
							for (int d = 0; d < 3; d++) { // 좌우상 순으로 움직인다.
								int ny = now.y + dy[d];
								int nx = now.x + dx[d];
								if (ny >= 0 && ny < N + 1 && nx >= 0 && nx < M && !visit[ny][nx]) {
									if (GameMap[ny][nx] == 1) {// 가장 가까운 적을 찾았다면
										AttackPoint[ny][nx] = true;
										attack = true;
										break;
									} else if (GameMap[ny][nx] == 0) {
										visit[ny][nx] = true;
										queue.add(new P(ny, nx));
									}
								}
							}
							if (attack) {
								break;
							}
						}
						if (attack) {
							break;
						}
						time++;
					}

				}
				// 공격이 끝났다면
				for (int i = 0; i < N; i++) { // 왜냐면 공격 가능한 곳은 0~N-1이기 때문에
					for (int j = 0; j < M; j++) {
						if (AttackPoint[i][j]) {
							cnt++;// 공격당한 적의 수를 늘려주자.
							liveEnemy--;// 그만큼 맵안에 있는 적의 수를 줄여주어야 한다.
							GameMap[i][j] = 0; // 죽은 것을 표시한다.
						}
					}
				}
				for (int i = 0; i < M; i++) {
					if (GameMap[N - 1][i] == 1) {
						liveEnemy--; // 성에 닿아 사라질 놈들 줄여주자
					}
				}
				// 게임 맵을 한칸 씩 아래로 내려야 한다.
				for (int i = N - 2; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						GameMap[i + 1][j] = GameMap[i][j];
					}
				}
				for (int i = 0; i < M; i++) {
					GameMap[0][i] = 0;
				} // 맵 세팅 완료 다시 시작
			}
			// 게임이 끝났다면
			ans = Math.max(ans, cnt);
			return;
		}
		for (int i = idx; i < M; i++) {
			if(!used[i]) {
				used[i] = true;
				DefenseGame(i+1, count+1);
				used[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		used = new boolean[M];
		Archer = new P[3];
		ans = 0;
		Enemy = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(r.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					Enemy++;
				}
			}
		}
		DefenseGame(0, 0);
		System.out.println(ans);

	}

}
