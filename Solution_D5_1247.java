import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최적경로 
public class Solution_D5_1247 {
	static int T, N, ans;
	static class P{
		int y, x;
		public P(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static P[] map, route;
	static boolean[] used;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(r.readLine().trim());
			map = new P[N+2];
			route = new P[N+2];
			used = new boolean[N+2];
			used[0] = true;
			used[1] = true;
			ans = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(r.readLine().trim());
			for (int i = 0; i < N+2; i++) {
				map[i] = new P((Integer.parseInt(st.nextToken())), (Integer.parseInt(st.nextToken())));
			}
			makeRoute(0);
			System.out.println("#"+t+" "+ans);
		}
		
	}
	private static void makeRoute(int idx) {
		if(idx == N+2) {
			int distance = 0;
			for (int i = 0; i < N+1; i++) {
				distance += ((Math.abs(route[i].x-route[i+1].x))+(Math.abs(route[i].y-route[i+1].y)));
			}
			ans = Math.min(ans, distance);
			return;
		}
		if(idx == 0) {
			route[idx] = map[0];
			makeRoute(idx+1);
		}
		if(idx == N+1) {
			route[idx] = map[1];
			makeRoute(idx+1);
		}
		for (int i = 2; i < N+2; i++) {
			if(!used[i]) {
				used[i] = true;
				route[idx] = map[i];
				makeRoute(idx+1);
				used[i] = false;
			}
		}
	}
	
}
