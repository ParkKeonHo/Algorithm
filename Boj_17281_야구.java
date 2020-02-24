import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17281_야구 {
	static int[] ground;
	static int outCount;
	static int[] InputList;
	static int[][] withoutOnePlayerList;
	static int rowIndex;
	static int turn;
	static Queue<Integer> GamePlayerList;
	static int INNING;
	static int[] maxGoal;
	static int Player1;
	static int[] tmpList = new int[8];
	static int[] RealGame;

	static void LineUp(int flag, int digit) {
		if (digit == 8) {
			for (int i = 0; i < 8; i++) {
				withoutOnePlayerList[rowIndex][i] = tmpList[i];
			}
			rowIndex++;
			return;
		} else {
			for (int i = 0; i < InputList.length; i++) {
				if ((flag & 1 << i) != 0) {
					continue;
				} else if ((flag & 1 << i) == 0) {
					tmpList[digit] = InputList[i];
					LineUp((flag | 1 << i), digit + 1);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		INNING = Integer.parseInt(r.readLine());
		maxGoal = new int[INNING];
		turn = 0;
		for (int inning = 0; inning < INNING; inning++) {
			rowIndex = 0;
			outCount = 0; // 아웃 카운트 초기화_이닝이 새로 시작되므로
			InputList = new int[8];// index : 0~7
			Player1 = 0;
			StringTokenizer st = new StringTokenizer(r.readLine());
			int t = 0;
			while (t != 9) {
				if (t == 0) {
					Player1 = Integer.parseInt(st.nextToken());
				} else {
					InputList[t - 1] = Integer.parseInt(st.nextToken());
				}
				t++;
			} // 입력된 각 선수들의 행동 초기화

			withoutOnePlayerList = new int[40320][8];
			// 가능한 타순 리스트 경우의수 저장하기
			LineUp(0, 0); // withoutOnePlayerList가 초기화 됨
			int num = turn; // 매 이닝 시작때마다 전 이닝에서 끝난타자 부터 시작하도
			for (int i = 0; i < 40320; i++) { // 각 리스트 별로 최댓값 뽑자.
				RealGame = new int[9];
				outCount = 0;
				GamePlayerList = new LinkedList<>();
				ground = new int[4];
				int w = 0;
				int tm = num;
				while (w != 9) {
					if (inning == 0 && w == 3) {
						RealGame[w] = Player1;
						w++;
					} else {
						if (tm == 9) {
							RealGame[w] = Player1;
							w++;
							tm = 0;
						}
						RealGame[w] = withoutOnePlayerList[i][tm];
						tm++;
						w++;
					}
				} // 게임할 타순 완료
				w = 0;
				while (w != 9) {
					GamePlayerList.add(RealGame[num]);
					num++;
					if (num == 9) {
						num = 0;
					}
					w++;
				}
				while (outCount != 3) {
					int Action = GamePlayerList.poll();
					GamePlayerList.add(Action);
					num++;
					if (num == 9) {
						num = 0;
					}
					if (Action == 0) {
						outCount++;
						continue;
					} else {
						for (int j = 2; j >= 0; j--) {
							int nextposition = j + Action;
							if (nextposition > 3) {
								nextposition = 3;
							}
							if (ground[j] != 0) {
								ground[nextposition] += ground[j];
								ground[j] = 0;
							}
						}
					}
				}
				outCount = 0;
				int result = ground[3];
				for (int j = 0; j < ground.length; j++) {
					ground[j] = 0;
				}
				if (maxGoal[inning] < result) {
					maxGoal[inning] = result;
					turn = num;
				}
			}

		}
		int Goal = 0;
		for (int i = 0; i < INNING; i++) {
			Goal += maxGoal[i];
		}
		System.out.println(Goal);
	}

}
