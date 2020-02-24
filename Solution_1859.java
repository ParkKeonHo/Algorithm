import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백만장자 프로젝트 
public class Solution_1859 {
	static boolean[] used;
	static int N, T;
	static long ans;
	static long[] price;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(r.readLine());
			price = new long[N];
			long Max = Integer.MIN_VALUE;
			ans = 0;
			StringTokenizer st = new StringTokenizer(r.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = N-1; i >= 0; i--) {
				if(Max < price[i]) {
					Max = price[i];
				}
				ans += (Max-price[i]);
			}
			System.out.println("#"+t+" "+ans);
		}

	}

}
