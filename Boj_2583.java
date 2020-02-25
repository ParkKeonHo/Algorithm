import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//영역 구하기 
public class Boj_2583 {
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean[][] visit;
	static int Sy, Sx, Ey, Ex, M, N, D;
	static int[] Area;
	static int[][] map;
	static void dfs(int y, int x, int cnt) {
		if(!visit[y][x]) {
			visit[y][x] = true;
			Area[cnt]++;
			for (int d = 0; d < 4; d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				if(ny>=0 && ny<M && nx >=0 && nx<N && !visit[ny][nx] && map[ny][nx] == 0) {
					dfs(ny, nx, cnt);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		M =Integer.parseInt(st.nextToken());
		N =Integer.parseInt(st.nextToken());
		D =Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visit = new boolean[M][N];
		Area = new int[M*N];
		for (int i = 0; i < D; i++) {
			st = new StringTokenizer(r.readLine());
			Sx = Integer.parseInt(st.nextToken());
			Sy = Integer.parseInt(st.nextToken());
			Ex = Integer.parseInt(st.nextToken());
			Ey = Integer.parseInt(st.nextToken());
			for (int y = Sy; y < Ey; y++) {
				for (int x = Sx; x < Ex; x++) {
					map[y][x] = 1;
				}
			}
		}//맵 초기화 완료
		int k = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 && !visit[i][j]) {
					dfs(i, j, k++);
				}
			}
		}
		Arrays.sort(Area);
		System.out.println(k);
		for (int i = 0; i < Area.length; i++) {
			if(Area[i] != 0) {
				System.out.print(Area[i]+" ");
			}
		}
		
	}
}
