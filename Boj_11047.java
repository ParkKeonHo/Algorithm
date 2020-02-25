import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_11047 {
	static int N, ans;
	static long K;
	static long A[];
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st.nextToken());
		K = (long)Integer.parseInt(st.nextToken());
		A = new long[N];
		Arrays.fill(A, 0);
		for (int i = 0; i < N; i++) {
			A[i] = (long)Integer.parseInt(r.readLine());
		}
		ans = 0;
		int j = N-1;
		while(j != 0) {
			if(A[j] > K) {
				j--;
				continue;
			}else if(A[j] <= K) {
				ans += K/A[j];
				K = K%A[j];
			}
		}
		ans += K;
		System.out.println(ans);
	}
//	static void Calculate(long a, long b, boolean eq) { // a 는 목표 b는 동전 가치 
//		if(b == 1) {
//			ans += a;
//			return;
//		}
//		if(a%b == 0) {
//			ans += a/b;
//			return;
//		}
//		if(a>=b) {
//			long k = a%b;
//			ans += a/b;
//			if(eq) {
//				Calculate(k, b/5, false);
//			}else {
//				Calculate(k, b/2, true);
//			}
//		}
//		if(a<b && eq) {
//			Calculate(a, b/5, false);
//		}else if(a<b && !eq) {
//			Calculate(a, b/2, true);
//		}
//		
//	}
}
