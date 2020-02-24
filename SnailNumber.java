import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnailNumber {
	static int col;
	static int map[][];
	static int[] dy= {0, 1, 0, -1};
	static int[] dx= {1, 0, -1, 0};
	static boolean visit[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		col = Integer.parseInt(r.readLine());
		map = new int[col][col];
		visit = new boolean[col][col];
		int y =0, x=0, d=0;
		visit[y][x] = true;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < col; j++) {
				map[y][x] = (i*col+j)+1;
				visit[y][x] = true;
				int ny = y+dy[d];
				int nx = x+dx[d];
				if(ny<0 || ny >= col || nx < 0 || nx >= col || visit[ny][nx]) {
					d++;
					if(d == 4) {
						d= 0;
					}
					y = y+dy[d];
					x = x+dx[d];
				}else {
					y = ny;
					x = nx;
				}
			}
		}
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}

}
