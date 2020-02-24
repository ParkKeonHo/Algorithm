import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import org.omg.CORBA.INTERNAL;

public class Solution_7562_나이트의이동 {
	static int T;
	static int I;
	static int[][] map;
	static int Sy;
	static int Sx;
	static int Fy;
	static int Fx;
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			I = Integer.parseInt(r.readLine());
			map = new int[I][I];
			visit = new boolean[I][I];
			StringTokenizer st = new StringTokenizer(r.readLine());
			Sy = Integer.parseInt(st.nextToken());
			Sx = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(r.readLine());
			Fy = Integer.parseInt(st.nextToken());
			Fx = Integer.parseInt(st.nextToken());
			bfs(Sx, Sy, Fx, Fy, map, visit);
			System.out.println(map[Fy][Fx]);
		}
		
	}
	public static void bfs(int Sx, int Sy, int Fx, int Fy,int[][] map, boolean[][] visit) {
		Queue<Integer> queueX = new LinkedList<>();
		Queue<Integer> queueY = new LinkedList<>();
		queueX.add(Sx);
		queueY.add(Sy);
		visit[Sy][Sx] = true;
		map[Sy][Sx] = 0;
		while(!queueX.isEmpty()) {
			int sx = queueX.poll();
			int sy = queueY.poll();
			if(sx == Fx && sy == Fy) {
				return;
			}
			for (int i = 0; i < 8; i++) {
				int nx = sx+dx[i];
				int ny = sy+dy[i];
				if(nx<I && nx>=0 && ny<I && ny>=0 && !visit[ny][nx]) {
					queueX.add(nx);
					queueY.add(ny);
					visit[ny][nx] = true;
					map[ny][nx] = map[sy][sx]+1;
				}
			}
		}
		
	}

}
