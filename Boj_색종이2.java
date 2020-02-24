import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_색종이2 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int count;
	static int T; // 색종이 갯
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		map = new int[102][102];
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = y; i < y+10; i++) {
				for (int j = x; j < x+10; j++) {
					map[i][j] = 1;
				}
			}
		}//맵 초기화 완료
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if(map[i][j] == 1){
					for (int d = 0; d < 4; d++) {
						int nx = j+dx[d];
						int ny = i+dy[d];
						if(map[ny][nx] == 0){
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
		
	}
}
