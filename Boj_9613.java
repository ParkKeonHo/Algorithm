import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Gcd의 합 
public class Boj_9613 {
	static long GCD(long a, long b) {
		if(b == 0) {
			return a;
		}
		return GCD(b, a%b);
	}
	static long sum;
	static int N, T;
	static boolean[] used;
	static long[] su;
	static long[] tmp;
	static void combi(int start, int count) {
		if(count == 2) {
			int j = 0;
			for (int i = 0; i < N; i++) {
				if(used[i]) {
					tmp[j++] = su[i];
				}
			}
			if(tmp[0]>tmp[1]) {
				sum += GCD(tmp[0], tmp[1]);
			}else if(tmp[0]<=tmp[1]) {
				sum += GCD(tmp[1], tmp[0]);
			}
			return;
		}
		for (int i = start; i < N; i++) {
			if(!used[i]) {
				used[i] = true;
				combi(i+1, count+1);
				used[i] = false;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			N = Integer.parseInt(st.nextToken());
			used = new boolean[N];
			su = new long[N];
			tmp = new long[2];
			sum = 0L;
			for (int j = 0; j < N; j++) {
				su[j] = Integer.parseInt(st.nextToken());
			}
			combi(0, 0);
			System.out.println(sum);
		}
	}
}
