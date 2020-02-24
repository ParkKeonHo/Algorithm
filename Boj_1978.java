import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1978 {
	public static boolean isPrime(int n) {
		boolean isP = true;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				isP = false;
				break;
			}
		}
		return isP;
	}
	public static boolean[] isP = new boolean [1001];
	static int N;
	static int[] result;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		isP[0] = false;
		isP[1] = false;
		
		for (int i = 2; i < 1001; i++) {
			isP[i] = isPrime(i);
		}
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(r.readLine());
		StringTokenizer st = new StringTokenizer(r.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(isP[x]) {
				count++;
			}
		}
		System.out.print(count);
	}
}
