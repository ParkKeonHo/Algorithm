import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2804 {
	static int N;
	static int M;
	static String A;
	static String B;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		A = st.nextToken();
		B = st.nextToken();
		N = A.length();
		M = B.length();
		map = new char[M][N];
		for (int i = 0; i < M; i++) {
			Arrays.fill(map[i], '.');
		}
		boolean eq = false;
		int row = 0;
		int col = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(A.charAt(i) == B.charAt(j)) {
					row = j;
					col = i;
					eq = true;
					break;
				}
			}
			if(eq) {
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			map[row][i] = A.charAt(i);
		}
		for (int i = 0; i < M; i++) {
			map[i][col] = B.charAt(i);
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
