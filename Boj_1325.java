import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1325 {
	static C[] result;
	static int[] save;
	static boolean[][] map;
	static boolean[] visit;
	static int count;
	static int N;
	static int M;
	static int[] computer;
	static int max = Integer.MIN_VALUE;

	public static void dfs(int start_node) {
		for (int i = 1; i < N+1; i++) {
			if(visit[i]) {
				break;
			}
			if(map[start_node][i] == true && !visit[i]) {
				dfs(i);
				count++;
			}
		}
	}

	public static class C {
		int num;
		int position;

		public C(int num, int position) {
			super();
			this.num = num;
			this.position = position;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][N + 1];
		visit = new boolean[N + 1];
		visit[0] = true;
		computer = new int[N + 1];
		save = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(r.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// A가B를 신뢰한다.
			map[B][A] = true;
		}
		for (int i = 1; i < N + 1; i++) {
			visit[i] = true;
			dfs(i);
			visit[i] = false;
			computer[i] = count;
			count = 0;
		}
		result = new C[N + 1];
		for (int i = 1; i < computer.length; i++) {
			System.out.print(computer[i]+" ");
			result[i] = new C(computer[i], i);
		}
		for (int i = 1; i < result.length - 1; i++) {
			for (int j = i + 1; j < result.length; j++) {
				if (result[i].num > result[j].num) {
					C tmp = result[i];
					result[i] = result[j];
					result[j] = tmp;
				}
			}
		}
		int max = result[N].num;
		for (int i = result.length - 1; i >= 1; i--) {
			if (max == result[i].num) {
				System.out.print(result[i].position + " ");
			}
		}
	}
}
