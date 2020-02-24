import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4111 {
	static int K; // 수신기 
	static int N; // 카메라 
	static int T;
	static boolean[] highway;
	static int sum;
	static int limit;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(r.readLine());
			K = Integer.parseInt(r.readLine());
			StringTokenizer st = new StringTokenizer(r.readLine());
			if(N<=K) {
				System.out.println("#"+t+" "+0);
				continue;
			}
			int len = st.countTokens();
			int[] tmp = new int[len];
			for (int i = 0; i < len; i++) {
				tmp[i] = Integer.parseInt(st.nextToken())-1;
			}
			Arrays.sort(tmp);
			max = tmp[len-1] - tmp[0]; //최대 길이 
			if(max%K == 0) {
				limit = max/K;
			}else {
				limit = (max/K)+1;
			}
			highway = new boolean[tmp[len-1]+1];
			for (int i = 0; i < tmp.length; i++) {
				highway[tmp[i]] = true;
			}
			int position = 0;
			for (int i = 0; i < highway.length; i++) {
				if(highway[i] == true && K != 1) {
					for (int j = i; j < i+limit-1; j++) {
						if(j<9 && highway[j] == true) {
							position = j;
							highway[j] = false;
						}
					}
				}else if(highway[i] == true && K == 1) {
					sum += tmp[len-1]-i;
					break;
				}
					K--;
					sum += position-i;
			}
			
			
			System.out.println("#"+t+" "+sum);
			
		}
	}
}
