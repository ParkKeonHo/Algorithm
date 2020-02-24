package ssafyalgo_0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_중급_미로1 {
	static int Sx, Sy;
	
	static int[][] map;
	static int T = 10;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = { 0, 0, -1, 1};
	static int Fx, Fy;
	
	
	
	
	
	public static void dfs(int y, int x) {
		map[y][x] = 4;
		for (int d = 0; d < 4; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			if(ny>=0&&ny<16 && nx>=0 && nx<16 && map[ny][nx] != 1 && map[ny][nx] != 4) {
				dfs(ny,nx);
			}
		}
	}
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {
			int tc = Integer.parseInt(r.readLine());
			map = new int[16][16];
			for (int i = 0; i < 16; i++) {
				char[] tmp = r.readLine().trim().toCharArray();
				for (int j = 0; j < 16; j++) {
					map[i][j] = tmp[j]-48;
					if(map[i][j] == 2) {
						Sy = i;
						Sx = j;
					}else if(map[i][j] == 3) {
						Fy = i;
						Fx = j;
					}
				}
			}//map initialize
			dfs(Sy, Sx);
			System.out.println("#"+tc+" "+((map[Fy][Fx] == 3)? 0:1));
		}
	}
}
