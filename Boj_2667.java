import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2667 {
	static int label;//단지번호 
	static int count;
	static int N;
	static boolean[][] visit;
	static int[][] map;
	static int[] houseNumber;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static Queue<P> queue;
	public static class P{
		int y, x;

		public P(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	public static void bfs() {
		while(!queue.isEmpty()) {
			P p = queue.poll();
			int sx = p.x;
			int sy = p.y;
			for (int dir = 0; dir < 4; dir++) {
				int nx = sx+dx[dir];
				int ny = sy+dy[dir]; 
				if(nx>=0 && nx<N && ny>=0 && ny<N &&!visit[ny][nx] && map[ny][nx] != 0) {
					visit[ny][nx] = true;
					map[ny][nx] = label;
					queue.add(new P(ny, nx));
					count++;
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(r.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		queue = new LinkedList<>();
		label = 1;
		count = 1;
		for (int i = 0; i < N; i++) {
			String s = r.readLine();
			for (int j = 0; j < N; j++) {
				int x = s.charAt(j) - '0';
				if(x == 0) {
					map[i][j] = 0;
				}else {
					map[i][j] = -1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==-1) {
					visit[i][j] = true;
					queue.add(new P(i, j));
					map[i][j] = label;
					bfs();
					label++;
				}
			}
		}
		houseNumber = new int[label];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					continue;
				}
				houseNumber[map[i][j]]++;
			}
		}
		System.out.println(label-1);
		Arrays.sort(houseNumber);
		for (int i = 1; i < label; i++) {
			System.out.println(houseNumber[i]);
		}
	}
}
