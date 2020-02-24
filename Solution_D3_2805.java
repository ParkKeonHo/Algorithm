import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2805 {
	static int T;
	static int N;
	static char map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(r.readLine());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = r.readLine().toCharArray();
			}
			int sum = 0;
			int k = N/2;
			int j = N/2;
			for (int i = 0; i < N; i++) {
				for (int l = j; l <= k; l++) {
					sum += map[i][l]-48;
				}
				if(i >= N/2) {
					j++;
					k--;
				}else if(i < N/2) {
					j--;
					k++;					
				}
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}