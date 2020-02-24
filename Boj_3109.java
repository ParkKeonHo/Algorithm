import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//빵집 
public class Boj_3109 {
	static boolean[][] visit;
	static char[][] map;
	static int R, C, ans;
	static boolean Finish;
	static int[] dy = {-1, 0, 1};
	static int[] dx = {1, 1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] tmp = r.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp[j];
			}
		}//map init complete
		for (int i = 0; i < R; i++) {
			dfs(i, 0);
			Finish = false;
		}
		for (int i = 0; i < R; i++) {
			if(map[i][C-1]=='*') {
				ans++;
			}
		}
		System.out.println(ans);
		
	}
	private static void dfs(int y, int x) {
		if(Finish) {
			return;
		}
		if(x == C-1) {//도착 했다면 
			map[y][x] = '*';
			Finish = true;
			return;
		}
		visit[y][x] = true;
		for (int d = 0; d < 3; d++) {
			if(Finish) {return;}
			int ny = y+dy[d];
			int nx = x+dx[d];
			if(ny>=0 && ny<R && nx>=0 && nx<C && !visit[ny][nx] && map[ny][nx] != 'x' && map[ny][nx] != '*') {
				dfs(ny, nx);
			}
		}
	}
}
