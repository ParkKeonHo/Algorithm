package ssafyalgo_0214;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int D, W, K;
	static int[][] map;
	static int ans;
	static int[] arr0, arr1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			String[] line = br.readLine().split(" ");
			D = Integer.parseInt(line[0]);
			W = Integer.parseInt(line[1]);
			K = Integer.parseInt(line[2]);

			map = new int[D][W];

			for (int i = 0; i < D; i++) {
				line = br.readLine().split(" ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}

			ans = -1;
			arr0 = new int[W];
			arr1 = new int[W];
			Arrays.fill(arr1, 1);
			
			for (int i = 0; i < D; i++) {
				comb(0, 0, i);

				if (ans != -1)
					break;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void comb(int idx, int cnt, int r) {
		if (ans != -1)
			return;

		if (cnt == r) {
			if (check()) {
				ans = r;
			}
			return;
		}

		if (idx == D)
			return;

		int[] tmp = map[idx];
		map[idx] = arr0;
		comb(idx + 1, cnt + 1, r);
		map[idx] = arr1;
		comb(idx + 1, cnt + 1, r);
		map[idx] = tmp;
		comb(idx + 1, cnt, r);
	}

	static boolean check() {
		for (int j = 0; j < W; j++) {
			int cnt = 1;
			for (int i = 1; i < D; i++) {
				if (map[i - 1][j] == map[i][j]) {
					cnt++;
				} else {
					cnt = 1;
				}

				if (cnt == K)
					break;
			}
			if (cnt < K)
				return false;
		}
		return true;
	}
}